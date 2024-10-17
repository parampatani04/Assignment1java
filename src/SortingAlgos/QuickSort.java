package SortingAlgos;

package sortingAlgorithms;

import java.util.Comparator;
import shapes.Shape;

public class QuickSort {

    public static void quickSort(Shape[] array, int low, int high, Comparator<Shape> comp) {
        if (low < high) {
            int pi = partition(array, low, high, comp);

            quickSort(array, low, pi - 1, comp);
            quickSort(array, pi + 1, high, comp);
        }
    }

    private static int partition(Shape[] array, int low, int high, Comparator<Shape> comp) {
        Shape pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comp == null) {
                if (array[j].compareTo(pivot) < 0) {
                    i++;
                    // Swap array[i] and array[j]
                    Shape temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            } else {
                if (comp.compare(array[j], pivot) < 0) {
                    i++;
                    // Swap array[i] and array[j]
                    Shape temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        // Swap array[i + 1] and pivot
        Shape temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}