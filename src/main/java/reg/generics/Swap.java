package reg.generics;

public class Swap<T> {
    public static <T> T[] swap (T[] array, int index1, int index2) {
        T value1= array[index1];
        array[index1] = array[index2];
        array[index2] = value1;
        return array;
    }
}


