package reg.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultCollectionImpl_add_Test {
    @Test
    public void add_shouldReturnTrueAndIncreaseSize_whenCalled() {
        final DefaultCollection <String> dfc = new DefaultCollectionImpl <>();

        assertTrue(dfc.add("apples"));
        assertTrue(dfc.add("bananas"));
        assertTrue(dfc.add("carrots"));
        assertEquals(3, dfc.size());
    }

    @Test
    public void add_shouldReturnTrueAndDoubleItsSize_whenMoreThan10ItemsAdded() {
        final DefaultCollection <String> dfc = new DefaultCollectionImpl <>();
        for ( int i = 0; i < 15; i++ ) {
            assertTrue(dfc.add("item" + i));
        }

        assertEquals(15, dfc.size());
    }

    @Test
    public void add_shouldContainTheSameItems_whenCalled() {
        final DefaultCollection <String> dfc      = new DefaultCollectionImpl <>();
        final String[]                   toAdd    = { "apples", "bananas", "carrots", "mango", "doggo" };
        final Object[]                   expected = { "apples", "bananas", "carrots", "mango", "doggo", null, null, null, null, null };

        for ( String s : toAdd ) {
            dfc.add(s);
        }

        Object[] got = dfc.toArray();
        assertArrayEquals(expected, got);
    }

    @Test
    public void add_shouldDoubleItsSize_whenMoreThan10ItemsAdded() {
        final DefaultCollection <String> dfc      = new DefaultCollectionImpl <>();
        final String[]                   toAdd    = { "item0", "item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8", "item9", "item10", "item11", "item12" };
        final Object[]                   expected = { "item0", "item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8", "item9", "item10", "item11", "item12", null, null, null, null,null, null, null };

        for ( String s : toAdd ) {
            dfc.add(s);
        }

        Object[] got = dfc.toArray();
        assertArrayEquals(expected, got);
    }
}
