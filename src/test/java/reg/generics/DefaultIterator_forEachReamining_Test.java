package reg.generics;

import org.junit.jupiter.api.Test;

public class DefaultIterator_forEachReamining_Test {
    @Test
    public void remove_shouldRemoveCurrentItem_whenCalled() {
        final DefaultCollection <String> dfc             = new DefaultCollectionImpl <>();
        final String[]                   toAdd           = new String[] { "apples", "bananas", "carrots", "one", "two", "three", "four" };
        final DefaultIterator <String>   defaultIterator = dfc.iterator();

        // dfc
        for ( int i = 0; i < toAdd.length; i++ ) {
            dfc.add(toAdd[i]);
        }

        defaultIterator.forEachRemaining(item -> {
            System.out.printf("item: '%s'\n", item);
        });
    }
}
