package appDomain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

import SortingAlgos.BubbleSort;
import SortingAlgos.InsertionSort;
import SortingAlgos.HeapSort;
import SortingAlgos.MergeSort;
import SortingAlgos.SelectionSort;
import SortingAlgos.QuickSort;

import shapes.SquarePrism;
import shapes.OctagonalPrism;
import shapes.VolumeCompare;
import shapes.Shape;
import shapes.Cone;
import shapes.Cylinder;
import shapes.Pyramid;
import shapes.TriangularPrism;
import shapes.PentagonalPrism;

public class AppDriver {

    private static String compareType;
    private static String sortType;
    private static String shapeFile;

    public static void main(String[] args) {

        // Parse arguments
        new AppDriver().parseArgs(args);

        Scanner input = null;

        try {
            input = new Scanner(new File(shapeFile));
        } catch (FileNotFoundException e) {
            try {
                int f = shapeFile.indexOf("shapes");
                input = new Scanner(new File("res\\" + shapeFile.substring(f, f + 11)));
            } catch (FileNotFoundException e1) {
                System.out.println("Error: Unable to find the file.");
                return;  // Prevent further execution
            }
        }

        // Read shapes data from file
        Shape[] shapes = new Shape[Integer.parseInt(input.nextLine())];

        for (int i = 0; i < shapes.length; i++) {
            String[] shapeData = input.nextLine().split(" ");
            double height = Double.valueOf(shapeData[1]);

            // Identify the shape based on the first few characters and instantiate
            if (shapeData[0].startsWith("Cy")) {
                shapes[i] = new Cylinder(height, Double.valueOf(shapeData[2]));
            } else if (shapeData[0].startsWith("Co")) {
                shapes[i] = new Cone(height, Double.valueOf(shapeData[2]));
            } else if (shapeData[0].startsWith("Py")) {
                shapes[i] = new Pyramid(height, Double.valueOf(shapeData[2]));
            } else if (shapeData[0].startsWith("Sq")) {
                shapes[i] = new SquarePrism(height, Double.valueOf(shapeData[2]));
            } else if (shapeData[0].startsWith("Tr")) {
                shapes[i] = new TriangularPrism(height, Double.valueOf(shapeData[2]));
            } else if (shapeData[0].startsWith("Pe")) {
                shapes[i] = new PentagonalPrism(height, Double.valueOf(shapeData[2]));
            } else if (shapeData[0].startsWith("Oc")) {
                shapes[i] = new OctagonalPrism(height, Double.valueOf(shapeData[2]));
            } else {
                System.out.println("Invalid format found in text file.");
            }
        }

        // Determine comparator based on user input
        Comparator<Shape> comp = null;

        if (compareType.equals("v")) {
            comp = new VolumeCompare();
        } else if (compareType.equals("a")) {
            comp = new BaseAreaCompare();
        } else {
            System.out.println("Invalid compare type! Use 'v' for volume or 'a' for base area.");
            return;  // Exit if invalid compare type
        }

        // Sorting and Benchmarking
        long startTime, endTime;
        switch (sortType) {
            case "b":
                startTime = System.nanoTime();
                BubbleSort.bubbleSort(shapes, comp);
                endTime = System.nanoTime();
                break;
            case "i":
                startTime = System.nanoTime();
                InsertionSort.insertionSort(shapes, comp);
                endTime = System.nanoTime();
                break;
            case "q":
                startTime = System.nanoTime();
                QuickSort.quickSort(shapes, 0, shapes.length - 1, comp);
                endTime = System.nanoTime();
                break;
            case "m":
                startTime = System.nanoTime();
                MergeSort.mergeSort(shapes, comp);
                endTime = System.nanoTime();
                break;
            case "h":
                startTime = System.nanoTime();
                HeapSort.heapSort(shapes, comp);
                endTime = System.nanoTime();
                break;
            case "s":
                startTime = System.nanoTime();
                SelectionSort.selectionSort(shapes, comp);
                endTime = System.nanoTime();
                break;
            default:
                System.out.println("Invalid sort type! Use 'b', 'i', 'q', 'm', 'h', or 's'.");
                return;
        }

        // Display results and timing
        new AppDriver().displayResults(shapes);
        System.out.println("\n" + sortType + " run time was: " + ((endTime - startTime) / 1000000) + " millisecond(s)");

        input.close();
    }

    private void parseArgs(String[] args) {
        if (args.length < 3) {
            System.out.println("Not enough arguments.");
            return;
        }

        for (String arg : args) {
            if (arg.startsWith("-t") || arg.startsWith("–t")) {
                AppDriver.compareType = arg.substring(2).toLowerCase();
            } else if (arg.startsWith("-s") || arg.startsWith("–s")) {
                this.sortType = arg.substring(2).toLowerCase();
            } else if (arg.startsWith("-f") || arg.startsWith("–f")) {
                this.shapeFile = arg.substring(2).replaceAll("\"", "").toLowerCase();
            }
        }
    }

    private void displayResults(Shape[] array) {
        System.out.println("First element is: " + array[0].toString(compareType));
        for (int i = 999; i < array.length - 1; i += 1000) {
            System.out.println((i + 1) + "-th element is: " + array[i].toString(compareType));
        }
        System.out.println("Last element is: " + array[array.length - 1].toString(compareType));
    }
}