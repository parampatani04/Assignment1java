package SortingAlgos;

import java.util.Comparator;
import shapes.Shape;

public class HeapSort {

    public static void heapSort(Shape[] array, Comparator<Shape> comp) {
        int n = array.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i, comp);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap root (maximum element) with the last element
            Shape temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Heapify the reduced heap
            heapify(array, i, 0, comp);
        }
    }

    private static void heapify(Shape[] array, int n, int i, Comparator<Shape> comp) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (comp == null) {
            // Use natural ordering
            if (left < n && array[left].compareTo(array[largest]) > 0) {
                largest = left;
            }
            if (right < n && array[right].compareTo(array[largest]) > 0) {
                largest = right;
            }
        } else {
            // Use custom comparator
            if (left < n && comp.compare(array[left], array[largest]) > 0) {
                largest = left;
            }
            if (right < n && comp.compare(array[right], array[largest]) > 0) {
                largest = right;
            }
        }

        if (largest != i) {
            // Swap array[i] with array[largest]
            Shape temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(array, n, largest, comp);
        }
    }
}