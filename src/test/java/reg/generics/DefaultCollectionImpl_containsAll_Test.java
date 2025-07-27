package reg.generics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DefaultCollectionImpl_containsAll_Test {
    @Test
    public void containsAll_shouldReturnTrue_whenCollectionIsNull() {
        final DefaultCollection <String> dfc        = new DefaultCollectionImpl <>();
        final String[]                   toAdd      = new String[] { "apples", "bananas", "carrots", "one", "two", "three" };
        final List <String>              collection = null;

        for ( int i = 0; i < toAdd.length; i++ ) {
            dfc.add(toAdd[i]);
        }

        assertTrue(dfc.containsAll(collection));
    }

    @Test
    public void containsAll_shouldReturnTrue_whenCollectionIsEmpty() {
        final DefaultCollection <String> dfc        = new DefaultCollectionImpl <>();
        final String[]                   toAdd      = new String[] { "apples", "bananas", "carrots", "one", "two", "three" };
        final List <String>              collection = new ArrayList <>();

        for ( int i = 0; i < toAdd.length; i++ ) {
            dfc.add(toAdd[i]);
        }

        assertTrue(dfc.containsAll(collection));
    }

    @Test
    public void containsAll_shouldReturnTrue_whenAllItemsAreThere() {
        final DefaultCollection <String> dfc        = new DefaultCollectionImpl <>();
        final String[]                   toAdd      = new String[] { "apples", "bananas", "carrots", "one", "two", "three" };
        final List <String>              collection = new ArrayList <>();
        collection.add("one");
        collection.add("two");
        collection.add("three");


        for ( int i = 0; i < toAdd.length; i++ ) {
            dfc.add(toAdd[i]);
        }

        assertTrue(dfc.containsAll(collection));
    }

    @Test
    public void containsAll_shouldReturnFalse_whenAnItemsIsMissing() {
        final DefaultCollection <String> dfc        = new DefaultCollectionImpl <>();
        final String[]                   toAdd      = new String[] { "apples", "bananas", "carrots", "one", "two", "three" };
        final List <String>              collection = new ArrayList <>();
        collection.add("one");
        collection.add("two");
        collection.add("three");
        collection.add("missme");


        for ( int i = 0; i < toAdd.length; i++ ) {
            dfc.add(toAdd[i]);
        }

        assertFalse(dfc.containsAll(collection));
    }
}
