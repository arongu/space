package reg.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultCollectionImpl_clear_Test {
    @Test
    public void clear_shouldResetEverything_whenCalled() {
        final DefaultCollection <String> dfc = new DefaultCollectionImpl <>();

        assertTrue(dfc.add("apples"));
        assertTrue(dfc.add("bananas"));
        assertTrue(dfc.add("carrots"));
        assertEquals(3, dfc.size());

        dfc.clear();
        assertEquals(0, dfc.size());
        assertTrue(dfc.isEmpty());
        assertArrayEquals(new Object[0], dfc.toArray());
    }
}
