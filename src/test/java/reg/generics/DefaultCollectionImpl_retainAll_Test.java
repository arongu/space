package reg.generics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultCollectionImpl_retainAll_Test {
    @Test
    public void retainAll_shouldRemoveAllElements_whenCollectionIsEmpty() {
        final DefaultCollection <String> dfc                = new DefaultCollectionImpl <>();
        final String[]                   toAdd              = new String[] { "apples", "bananas", "carrots", "one", "two", "three", "four" };
        final Object[]                   expected           = new Object[] { null, null, null, null, null, null, null, null, null, null };
        final List <String>              collectionToRetain = new ArrayList <>();

        // dfc
        for ( int i = 0; i < toAdd.length; i++ ) {
            dfc.add(toAdd[i]);
        }

        assertTrue(dfc.retainAll(collectionToRetain));
        assertArrayEquals(expected, dfc.toArray());
        assertEquals(0, dfc.size());
    }

    @Test
    public void retainAll_shouldKeepOnlyElementsFromCollection_whenCalled() {
        final DefaultCollection <String> dfc                = new DefaultCollectionImpl <>();
        final String[]                   toAdd              = new String[] { "apples", "bananas", "carrots", "one", "two", "three", "four" };
        final Object[]                   expected           = new Object[] { null, null, null, "one", null, null, null, null, null, null };
        final List <String>              collectionToRetain = new ArrayList <>();
        collectionToRetain.add("one");


        // dfc
        for ( int i = 0; i < toAdd.length; i++ ) {
            dfc.add(toAdd[i]);
        }

        assertTrue(dfc.retainAll(collectionToRetain));
        assertArrayEquals(expected, dfc.toArray());
        assertEquals(1, dfc.size());
    }
}
