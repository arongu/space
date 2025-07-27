package reg.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultCollectionImpl_remove_Test {
    @Test
    public void remove_shouldReturnTrueAndDecreaseSize_whenCalled() {
        final DefaultCollection <String> dfc = new DefaultCollectionImpl <>();
        assertTrue(dfc.add("apples"));
        assertTrue(dfc.add("bananas"));
        assertTrue(dfc.add("carrots"));

        assertEquals(3, dfc.size());
        assertTrue(dfc.remove("bananas"));
        assertEquals(2, dfc.size());
    }

    @Test
    public void remove_shouldContainTheSameItems_whenCalled() {
        final DefaultCollection <String> dfc      = new DefaultCollectionImpl <>();
        final String[]                   toAdd    = { "apples", "bananas", "carrots", "mango", "doggo" };
        final Object[]                   expected = { "apples", null, "carrots", null, "doggo", null, null, null, null, null };

        for ( String s : toAdd ) {
            dfc.add(s);
        }

        // before
        assertEquals(5, dfc.size());
        dfc.remove("bananas");
        dfc.remove("mango");
        // after remove
        Object[] got = dfc.toArray();
        assertArrayEquals(expected, got);
        assertEquals(3, dfc.size());
    }
}
