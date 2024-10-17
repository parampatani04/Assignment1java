package SortingAlgos;

import java.util.Comparator;
import shapes.Shape;

public class MergeSort {

    public static void mergeSort(Shape[] shapes, Comparator<Shape> comp) {
        if (shapes.length < 2) {
            return;
        }
        int mid = shapes.length / 2;
        Shape[] left = new Shape[mid];
        Shape[] right = new Shape[shapes.length - mid];

        // Split array into two halves
        System.arraycopy(shapes, 0, left, 0, mid);
        System.arraycopy(shapes, mid, right, 0, shapes.length - mid);

        mergeSort(left, comp);
        mergeSort(right, comp);

        merge(shapes, left, right, comp);
    }

    private static void merge(Shape[] array, Shape[] left, Shape[] right, Comparator<Shape> comp) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (comp == null) {
                // Use natural ordering if no comparator
                if (left[i].compareTo(right[j]) <= 0) {
                    array[k++] = left[i++];
                } else {
                    array[k++] = right[j++];
                }
            } else {
                // Use custom comparator
                if (comp.compare(left[i], right[j]) <= 0) {
                    array[k++] = left[i++];
                } else {
                    array[k++] = right[j++];
                }
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}}