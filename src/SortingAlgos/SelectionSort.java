package SortingAlgos;

import java.util.Comparator;
import shapes.Shape;

public class SelectionSort {

    public static void selectionSort(Shape[] shapes, Comparator<Shape> comp) {
        int length = shapes.length;

        if (comp == null) {
            // Using natural ordering (Comparable)
            for (int i = 0; i < length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < length; j++) {
                    if (shapes[j].compareTo(shapes[minIndex]) < 0) {
                        minIndex = j;
                    }
                }
                // Swap the found minimum element with the first element
                Shape temp = shapes[minIndex];
                shapes[minIndex] = shapes[i];
                shapes[i] = temp;
            }
        } else {
            // Using custom comparator
            for (int i = 0; i < length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < length; j++) {
                    if (comp.compare(shapes[j], shapes[minIndex]) < 0) {
                        minIndex = j;
                    }
                }
                // Swap the found minimum element with the first element
                Shape temp = shapes[minIndex];
                shapes[minIndex] = shapes[i];
                shapes[i] = temp;
            }
        }
    }
}}