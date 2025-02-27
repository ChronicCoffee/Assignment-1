package appDomain;

import shapes.*;
import shapes.VolumeComparator;
import shapes.BaseAreaComparator;
import utilities.SortingUtil;

import java.io.*;
import java.util.*;

/**
 * Main driver class for the Sorting Application.
 * <p>
 * This program reads a file of shape data, parses command line arguments to determine
 * which property to sort by (height, volume, or base area) and which sorting algorithm
 * to use (Bubble, Selection, Insertion, Merge, Quick, or a custom Heap sort). It then
 * benchmarks the chosen sorting algorithm and displays selected elements from the sorted array.
 * </p>
 * <p>
 * Command line argument formats:
 * <ul>
 *   <li>-f&lt;file_name&gt; : Specifies the shape data file (absolute or relative path).</li>
 *   <li>-t&lt;criteria&gt;  : Specifies the sort criteria: h (height), v (volume), or a (base area).</li>
 *   <li>-s&lt;algorithm&gt; : Specifies the sort algorithm: b (bubble), s (selection), i (insertion),
 *       m (merge), q (quick), or z (custom/heap sort).</li>
 * </ul>
 * The arguments can be provided in any order.
 * </p>
 */
public class AppDriver {
    
    public static void main(String[] args) {
        // Variables to store command line parameters.
        String fileName = null;
        String criteria = null;
        String sortAlgorithm = null;
        
        // Parse the command line arguments.
        // Each argument is expected to be in the form: -f<file>, -t<criteria>, -s<algorithm>
        for (String arg : args) {
            if (arg.toLowerCase().startsWith("-f")) {
                fileName = arg.substring(2).replace("\"", "");
            } else if (arg.toLowerCase().startsWith("-t")) {
                criteria = arg.substring(2);
            } else if (arg.toLowerCase().startsWith("-s")) {
                sortAlgorithm = arg.substring(2);
            } else {
                System.out.println("Unrecognized argument: " + arg);
                printUsage();
                return;
            }
        }
        
        // Check if all required arguments are provided.
        if (fileName == null || criteria == null || sortAlgorithm == null) {
            System.out.println("Missing required arguments.");
            printUsage();
            return;
        }
        
        // Read shape data from the file.
        Shape[] shapes = null;
        try {
            shapes = readShapesFromFile(fileName);
        } catch (Exception e) {
            System.out.println("Error reading shapes from file: " + e.getMessage());
            return;
        }
        
        // Determine which comparator to use based on criteria.
        Comparator<Shape> comparator = null;
        if (criteria.equalsIgnoreCase("h")) {
            // Height: use natural ordering (compareTo) but reversed for descending order.
            comparator = Comparator.reverseOrder();
        } else if (criteria.equalsIgnoreCase("v")) {
            // Compare by volume (descending order).
            comparator = new VolumeComparator().reversed();
        } else if (criteria.equalsIgnoreCase("a")) {
            // Compare by base area (descending order).
            comparator = new BaseAreaComparator().reversed();
        } else {
            System.out.println("Invalid criteria type. Use h (height), v (volume), or a (base area).");
            printUsage();
            return;
        }
        
        // Clone the original array so that each sort works on identical unsorted data.
        Shape[] shapesToSort = shapes.clone();
        
        // Benchmark the chosen sorting algorithm.
        long startTime = System.nanoTime();
        switch (sortAlgorithm.toLowerCase()) {
            case "b": // Bubble sort
                SortingUtil.bubbleSort(shapesToSort, comparator);
                break;
            case "s": // Selection sort
                SortingUtil.selectionSort(shapesToSort, comparator);
                break;
            case "i": // Insertion sort
                SortingUtil.insertionSort(shapesToSort, comparator);
                break;
            case "m": // Merge sort
                SortingUtil.mergeSort(shapesToSort, comparator);
                break;
            case "q": // Quick sort
                SortingUtil.quickSort(shapesToSort, comparator);
                break;
            case "z": // Custom sort (Heap sort)
                SortingUtil.heapSort(shapesToSort, comparator);
                break;
            default:
                System.out.println("Invalid sort algorithm. Use b (bubble), s (selection), i (insertion), m (merge), q (quick), or z (custom).");
                printUsage();
                return;
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // Duration in milliseconds
        
        System.out.println("Sorting completed using algorithm: " + sortAlgorithm.toUpperCase());
        System.out.println("Time taken: " + duration + " ms");
        
        // Display sorted output: the first element, every 1000th element, and the last element.
        printSortedOutput(shapesToSort);
    }
    
    /**
     * Reads the shape data from a given file and returns an array of Shape objects.
     * <p>
     * The first line of the file should be an integer representing the number of shapes.
     * Each subsequent line should contain the shape type and its associated parameters.
     * </p>
     * @param fileName the path to the data file.
     * @return an array of Shape objects.
     * @throws IOException if there is an error reading the file.
     */
    private static Shape[] readShapesFromFile(String fileName) throws IOException {
        List<Shape> shapeList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = br.readLine();
        int numberOfShapes = Integer.parseInt(line.trim());
        
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;
            String[] tokens = line.split("\\s+");
            String shapeType = tokens[0].toLowerCase();
            try {
                switch (shapeType) {
                    case "cylinder":
                        double height = Double.parseDouble(tokens[1]);
                        double radius = Double.parseDouble(tokens[2]);
                        shapeList.add(new Cylinder(height, radius));
                        break;
                    case "cone":
                        height = Double.parseDouble(tokens[1]);
                        radius = Double.parseDouble(tokens[2]);
                        shapeList.add(new Cone(height, radius));
                        break;
                    case "pyramid":
                        height = Double.parseDouble(tokens[1]);
                        double side = Double.parseDouble(tokens[2]);
                        shapeList.add(new Pyramid(height, side));
                        break;
                    case "squareprism":
                        height = Double.parseDouble(tokens[1]);
                        side = Double.parseDouble(tokens[2]);
                        shapeList.add(new SquarePrism(height, side));
                        break;
                    case "triangularprism":
                        height = Double.parseDouble(tokens[1]);
                        side = Double.parseDouble(tokens[2]);
                        shapeList.add(new TriangularPrism(height, side));
                        break;
                    case "pentagonalprism":
                        height = Double.parseDouble(tokens[1]);
                        side = Double.parseDouble(tokens[2]);
                        shapeList.add(new PentagonalPrism(height, side));
                        break;
                    case "octagonalprism":
                        height = Double.parseDouble(tokens[1]);
                        side = Double.parseDouble(tokens[2]);
                        shapeList.add(new OctagonalPrism(height, side));
                        break;
                    default:
                        System.out.println("Unknown shape type: " + tokens[0]);
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error parsing line: " + line);
            }
        }
        br.close();
        
        if (shapeList.size() != numberOfShapes) {
            System.out.println("Warning: Expected " + numberOfShapes + " shapes but found " + shapeList.size());
        }
        return shapeList.toArray(new Shape[0]);
    }
    
    /**
     * Prints selected elements from the sorted shapes array:
     * the first element, every 1000th element (if available), and the last element.
     * @param sortedShapes the array of sorted Shape objects.
     */
    private static void printSortedOutput(Shape[] sortedShapes) {
        int n = sortedShapes.length;
        if (n == 0) return;
        System.out.println("Sorted output sample:");
        System.out.println("Index 0: " + sortedShapes[0]);
        // Print every 1000th element
        for (int i = 1000; i < n - 1; i += 1000) {
            System.out.println("Index " + i + ": " + sortedShapes[i]);
        }
        // Print the last element
        if (n > 1) {
            System.out.println("Index " + (n - 1) + ": " + sortedShapes[n - 1]);
        }
    }
    
    /**
     * Displays the correct usage of the program.
     */
    private static void printUsage() {
        System.out.println("Usage: java -jar Sort.jar -f<file_name> -t<criteria> -s<sort_algorithm>");
        System.out.println("Criteria: h (height), v (volume), a (base area)");
        System.out.println("Sort Algorithms: b (bubble), s (selection), i (insertion), m (merge), q (quick), z (custom/heap sort)");
    }
}
