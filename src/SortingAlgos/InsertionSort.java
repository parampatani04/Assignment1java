package SortingAlgos;

import java.util.Comparator;
import shapes.Shape;

public class InsertionSort {

    public static void insertionSort(Shape[] array, Comparator<Shape> comp) {
        int length = array.length;

        if (comp == null) {
            // Sort using natural ordering (Comparable)
            for (int i = 1; i < length; ++i) {
                Shape key = array[i];
                int j = i - 1;

                while (j >= 0 && array[j].compareTo(key) > 0) {
                    array[j + 1] = array[j];
                    j = j - 1;
                }
                array[j + 1] = key;
            }
        } else {
            // Sort using comparator
            for (int i = 1; i < length; ++i) {
                Shape key = array[i];
                int j = i - 1;

                while (j >= 0 && comp.compare(array[j], key) > 0) {
                    array[j + 1] = array[j];
                    j = j - 1;
                }
                array[j + 1] = key;
            }
        }
    }
}