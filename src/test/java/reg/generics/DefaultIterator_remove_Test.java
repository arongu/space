package reg.generics;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultIterator_remove_Test {
    @Test
    public void remove_shouldRemoveCurrentItem_whenCalled() {
        final DefaultCollection <String> dfc             = new DefaultCollectionImpl <>();
        final String[]                   toAdd           = new String[] { "apples", "bananas", "carrots", "one", "two", "three", "four" };
        final Object[]                   expected        = new Object[] { "apples", "bananas", "carrots", "one", null, "three", "four", null, null, null };
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
        // now at two
        defaultIterator.remove();

        final Object[] got = dfc.toArray();
        assertArrayEquals(expected, got);
        assertEquals(6, dfc.size());
    }
}
