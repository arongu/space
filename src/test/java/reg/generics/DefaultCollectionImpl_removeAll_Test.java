package reg.generics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultCollectionImpl_removeAll_Test {
    @Test
    public void removeAll_shouldReturnTrueAndIncreaseSize_whenCalled() {
        final DefaultCollection <String> dfc      = new DefaultCollectionImpl <>();
        final String[]                   toAdd    = new String[] { "apples", "bananas", "carrots", "one", "two", "three" };
        final Object[]                   expected = new Object[] { "apples", null, "carrots", null, "two", null, null, null, null, null };
        final List <String>              collectionToRemove = new ArrayList <>();
        collectionToRemove.add("one");
        collectionToRemove.add("bananas");
        collectionToRemove.add("three");


        // dfc
        for ( int i = 0; i < toAdd.length; i++ ) {
            dfc.add(toAdd[i]);
        }

        assertTrue(dfc.removeAll(collectionToRemove));
        assertArrayEquals(expected, dfc.toArray());
        assertEquals(3, dfc.size());
    }
}
