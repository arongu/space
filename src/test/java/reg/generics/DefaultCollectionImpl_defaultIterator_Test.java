package reg.generics;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultCollectionImpl_defaultIterator_Test {
    @Test
    public void retainAll_shouldRemoveAllElements_whenCollectionIsEmpty() {
        final DefaultCollection <String> dfc             = new DefaultCollectionImpl <>();
        final String[]                   toAdd           = new String[] { "apples", "bananas", "carrots", "one", "two", "three", "four" };
        final DefaultIterator <String>   defaultIterator = dfc.iterator();

        // dfc
        for ( int i = 0; i < toAdd.length; i++ ) {
            dfc.add(toAdd[i]);
        }

        assertTrue(defaultIterator.hasNext());
        assertEquals("apples", defaultIterator.next());
        assertEquals("bananas", defaultIterator.next());
        assertEquals("carrots", defaultIterator.next());
        assertEquals("one", defaultIterator.next());
        assertEquals("two", defaultIterator.next());
        assertEquals("three", defaultIterator.next());
        assertEquals("four", defaultIterator.next());
        assertFalse(defaultIterator.hasNext());
        assertThrows(NoSuchElementException.class, () -> defaultIterator.next());
    }
}
