package reg.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DefaultCollectionImpl_isEmpty_Test {
    @Test
    public void isEmpty_shouldReturnTrue_whenCollectionIsEmpty() {
        final DefaultCollection <String> dfc = new DefaultCollectionImpl <>();

        assertTrue(dfc.isEmpty());
    }

    @Test
    public void sEmpty_shouldReturnFalse_whenCollectionIsNotEmpty() {
        final DefaultCollection <String> dfc   = new DefaultCollectionImpl <>();
        final String[]                   toAdd = new String[] { "apples", "bananas", "carrots", "one", "two", "three" };

        for ( int i = 0; i < toAdd.length; i++ ) {
            dfc.add(toAdd[i]);
        }

        assertFalse(dfc.isEmpty());
    }
}
