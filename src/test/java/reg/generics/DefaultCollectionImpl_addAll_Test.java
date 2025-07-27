package reg.generics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultCollectionImpl_addAll_Test {
    @Test
    public void addAll_shouldReturnTrueAndIncreaseSize_whenCalled() {
        final DefaultCollection <String> dfc             = new DefaultCollectionImpl <>();
        final Object[]                   expected        = new Object[] { "apples", "bananas", "carrots", "one", "two", "three", null, null, null, null };
        final List <String>              collectionToAdd = new ArrayList <>();
        collectionToAdd.add("one");
        collectionToAdd.add("two");
        collectionToAdd.add("three");
        // dfc
        dfc.add("apples");
        dfc.add("bananas");
        dfc.add("carrots");

        assertTrue(dfc.addAll(collectionToAdd));
        assertArrayEquals(expected, dfc.toArray());
        assertEquals(6, dfc.size());
    }

    @Test
    public void addAll_shouldReturnTrueAndIncreaseSize_whenCollectionIsEmptyCalled() {
        final DefaultCollection <String> dfc             = new DefaultCollectionImpl <>();
        final Object[]                   expected        = new Object[] { "one", "two", "three", null, null, null, null, null, null, null };
        final List <String>              collectionToAdd = new ArrayList <>();
        collectionToAdd.add("one");
        collectionToAdd.add("two");
        collectionToAdd.add("three");

        assertTrue(dfc.addAll(collectionToAdd));
        assertArrayEquals(expected, dfc.toArray());
        assertEquals(3, dfc.size());
    }
}
