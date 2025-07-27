package reg.generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

public class DefaultCollectionImpl<T> implements DefaultCollection <T> {
    public static class DefaultIteratorImpl<T> implements DefaultIterator<T> {
        private final DefaultCollectionImpl<T> collectionImpl;

        int currentIndex = 0;
        public DefaultIteratorImpl(final DefaultCollectionImpl<T> collectionImpl ) {
            this.collectionImpl = collectionImpl;
        }

        @Override
        public boolean hasNext() {
            if ( collectionImpl.elements == null ) {
                return false;
            }

            return currentIndex < collectionImpl.elements.length - 1;
        }

        @Override
        public T next() {
            if ( hasNext() ) {
                return collectionImpl.elements[currentIndex++];
            }

            throw new NoSuchElementException();
        }
    }

    private int[] freedUpIndexes;
    private T[]   elements;

    private int size;
    private int head;

    public DefaultCollectionImpl() {
        size = 0;
        head = 0;
    }

    private void freeUp( int index ) {
        if ( freedUpIndexes == null ) {
            freedUpIndexes = new int[1];
            freedUpIndexes[0] = index;
        } else {
            freedUpIndexes = Arrays.copyOf(freedUpIndexes, freedUpIndexes.length + 1);
            freedUpIndexes[freedUpIndexes.length - 1] = index;
        }

        elements[index] = null;
        size--;
    }

    private boolean fillInGaps( T element ) {
        if ( freedUpIndexes != null ) {
            int indexToUse = freedUpIndexes[freedUpIndexes.length - 1];
            elements[indexToUse] = element;

            int truncatedSize = freedUpIndexes.length - 1;
            if ( truncatedSize == 0 ) {
                freedUpIndexes = null;
            } else {
                freedUpIndexes = Arrays.copyOf(freedUpIndexes, truncatedSize);
            }

            size++;
            return true;
        }

        return false;
    }

    @Override
    public DefaultIterator <T> iterator() {
        return new DefaultIteratorImpl <T>(this);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains( Object o ) {
        if ( o == null ) {
            return true;
        }

        if ( size == 0 ) {
            return false;
        }

        for ( T t : elements ) {
            if ( o.equals(t) ) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Object[] toArray() {
        if ( elements == null ) {
            return new Object[0];
        }

        final Object[] arr = new Object[elements.length];
        System.arraycopy(elements, 0, arr, 0, elements.length);
        return arr;
    }

    @Override
    public <E> E[] toArray( E[] ts ) {
        E[] arr = (E[]) new Object[ts.length];
        System.arraycopy(ts, 0, arr, 0, ts.length);
        return arr;
    }

    @Override
    public boolean add( T t ) {
        if ( t == null ) {
            return false;
        }

        if ( elements == null ) {
            elements = (T[]) new Object[10];
            elements[0] = t;
            head = 0;
        } else {
            if ( !fillInGaps(t) ) {
                int nextIndex = head + 1;
                int maxIndex  = elements.length - 1;
                if ( nextIndex > maxIndex ) {
                    elements = Arrays.copyOf(elements, elements.length * 2);
                }

                elements[nextIndex] = t;
                head = nextIndex;
            }
        }

        size++;
        return true;
    }

    @Override
    public boolean remove( Object o ) {
        if ( o == null ) {
            return false;
        }

        if ( elements == null || size == 0 ) {
            return false;
        }

        int oldSize = size;
        for ( int i = 0; i < elements.length; i++ ) {
            if ( elements[i] == null ) {
                continue;
            } else if ( o.equals(elements[i]) ) {
                freeUp(i);
            }
        }

        return size < oldSize;
    }

    @Override
    public boolean containsAll( Collection <?> collection ) {
        if ( collection == null ) {
            return true;
        }

        for ( Object o : collection ) {
            if ( !contains( o ) ) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll( Collection <? extends T> collection ) {
        if ( collection == null ) {
            return false;
        }

        int oldSize = size;
        for ( T t : collection ) {
            add(t);
        }

        return size > oldSize;
    }

    @Override
    public boolean removeAll( Collection <?> collection ) {
        if ( collection == null ) {
            return false;
        }

        int oldSize = size;
        for ( Object o : collection.toArray() ) {
            remove(o);
        }

        return size < oldSize;
    }

    @Override
    public boolean retainAll( Collection <?> collection ) {
        if ( collection == null ) {
            return false;
        }

        int oldSize = size();
        for ( int i = 0; i < elements.length; i++ ) {
            if ( elements[i] != null ) {
                if ( !collection.contains(elements[i]) ) {
                    freeUp(i);
                }
            }
        }

        return oldSize != size;
    }

    @Override
    public void clear() {
        elements = null;
        freedUpIndexes = null;
        size = 0;
        head = 0;
    }
}
