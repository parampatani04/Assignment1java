package SortingAlgos;

import java.util.Comparator;
import shapes.Shape;

public class BubbleSort {

    public static void bubbleSort(Shape[] array, Comparator<Shape> comp) {
        int length = array.length;

        if (comp == null) {
            // Sort using natural ordering (Comparable)
            for (int i = 0; i < length - 1; i++) {
                for (int j = 0; j < length - i - 1; j++) {
                    if (array[j].compareTo(array[j + 1]) > 0) {
                        // Swap array[j] and array[j + 1]
                        Shape temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        } else {
            // Sort using comparator
            for (int i = 0; i < length - 1; i++) {
                for (int j = 0; j < length - i - 1; j++) {
                    if (comp.compare(array[j], array[j + 1]) > 0) {
                        // Swap array[j] and array[j + 1]
                        Shape temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
    }
}