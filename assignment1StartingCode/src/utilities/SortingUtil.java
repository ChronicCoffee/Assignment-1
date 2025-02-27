package utilities;

import java.util.Comparator;

/**
 * Utility class containing various sorting algorithms.
 * Each algorithm uses a helper method to perform comparisons:
 * if a Comparator is provided, it uses that; otherwise, it falls back
 * on the natural ordering (Comparable) of the objects.
 */
public class SortingUtil {

    /**
     * Helper method to compare two objects.
     * Uses the provided comparator if available; otherwise,
     * uses natural ordering by casting to Comparable.
     *
     * @param a   first object.
     * @param b   second object.
     * @param comp the comparator to use (can be null).
     * @param <T> the type of objects.
     * @return negative if a < b, zero if equal, positive if a > b.
     */
    @SuppressWarnings("unchecked")
    private static <T> int compare(T a, T b, Comparator<? super T> comp) {
        if (comp != null) {
            return comp.compare(a, b);
        } else {
            return -((Comparable<T>) a).compareTo(b);
        }
    }
    
    /* ----------------- Bubble Sort ----------------- */
    
    /**
     * Bubble sort using a comparator.
     * @param arr the array to sort.
     * @param comp the comparator to determine order.
     * @param <T> the type of objects.
     */
    public static <T> void bubbleSort(T[] arr, Comparator<? super T> comp) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (compare(arr[j], arr[j + 1], comp) > 0) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
    
    /**
     * Bubble sort using natural ordering.
     * @param arr the array to sort.
     * @param <T> type that extends Comparable.
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        bubbleSort(arr, null);
    }
    
    /* ----------------- Selection Sort ----------------- */
    
    /**
     * Selection sort using a comparator.
     * @param arr the array to sort.
     * @param comp the comparator to determine order.
     * @param <T> the type of objects.
     */
    public static <T> void selectionSort(T[] arr, Comparator<? super T> comp) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (compare(arr[j], arr[minIdx], comp) < 0) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                swap(arr, i, minIdx);
            }
        }
    }
    
    /**
     * Selection sort using natural ordering.
     * @param arr the array to sort.
     * @param <T> type that extends Comparable.
     */
    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        selectionSort(arr, null);
    }
    
    /* ----------------- Insertion Sort ----------------- */
    
    /**
     * Insertion sort using a comparator.
     * @param arr the array to sort.
     * @param comp the comparator to determine order.
     * @param <T> the type of objects.
     */
    public static <T> void insertionSort(T[] arr, Comparator<? super T> comp) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && compare(arr[j], key, comp) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    /**
     * Insertion sort using natural ordering.
     * @param arr the array to sort.
     * @param <T> type that extends Comparable.
     */
    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        insertionSort(arr, null);
    }
    
    /* ----------------- Merge Sort ----------------- */
    
    /**
     * Merge sort using a comparator.
     * @param arr the array to sort.
     * @param comp the comparator to determine order.
     * @param <T> the type of objects.
     */
    public static <T> void mergeSort(T[] arr, Comparator<? super T> comp) {
        if (arr.length < 2) return;
        mergeSortRecursive(arr, 0, arr.length - 1, comp);
    }
    
    /**
     * Merge sort using natural ordering.
     * @param arr the array to sort.
     * @param <T> type that extends Comparable.
     */
    public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        mergeSort(arr, null);
    }
    
    private static <T> void mergeSortRecursive(T[] arr, int left, int right, Comparator<? super T> comp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortRecursive(arr, left, mid, comp);
            mergeSortRecursive(arr, mid + 1, right, comp);
            merge(arr, left, mid, right, comp);
        }
    }
    
    @SuppressWarnings("unchecked")
    private static <T> void merge(T[] arr, int left, int mid, int right, Comparator<? super T> comp) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        Object[] leftArray = new Object[n1];
        Object[] rightArray = new Object[n2];
        
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }
        
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (compare((T) leftArray[i], (T) rightArray[j], comp) <= 0) {
                arr[k++] = (T) leftArray[i++];
            } else {
                arr[k++] = (T) rightArray[j++];
            }
        }
        while (i < n1) {
            arr[k++] = (T) leftArray[i++];
        }
        while (j < n2) {
            arr[k++] = (T) rightArray[j++];
        }
    }
    
    /* ----------------- Quick Sort ----------------- */
    
    /**
     * Quick sort using a comparator.
     * @param arr the array to sort.
     * @param comp the comparator to determine order.
     * @param <T> the type of objects.
     */
    public static <T> void quickSort(T[] arr, Comparator<? super T> comp) {
        quickSortRecursive(arr, 0, arr.length - 1, comp);
    }
    
    /**
     * Quick sort using natural ordering.
     * @param arr the array to sort.
     * @param <T> type that extends Comparable.
     */
    public static <T extends Comparable<T>> void quickSort(T[] arr) {
        quickSort(arr, null);
    }
    
    private static <T> void quickSortRecursive(T[] arr, int low, int high, Comparator<? super T> comp) {
        if (low < high) {
            int pi = partition(arr, low, high, comp);
            quickSortRecursive(arr, low, pi - 1, comp);
            quickSortRecursive(arr, pi + 1, high, comp);
        }
    }
    
    private static <T> int partition(T[] arr, int low, int high, Comparator<? super T> comp) {
        T pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (compare(arr[j], pivot, comp) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    /* ----------------- Heap Sort ----------------- */
    
    /**
     * Heap sort using a comparator.
     * @param arr the array to sort.
     * @param comp the comparator to determine order.
     * @param <T> the type of objects.
     */
    public static <T> void heapSort(T[] arr, Comparator<? super T> comp) {
        int n = arr.length;
        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, comp);
        }
        // One by one extract elements from the heap
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0, comp);
        }
    }
    
    /**
     * Heap sort using natural ordering.
     * @param arr the array to sort.
     * @param <T> type that extends Comparable.
     */
    public static <T extends Comparable<T>> void heapSort(T[] arr) {
        heapSort(arr, null);
    }
    
    private static <T> void heapify(T[] arr, int n, int i, Comparator<? super T> comp) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < n && compare(arr[left], arr[largest], comp) > 0) {
            largest = left;
        }
        if (right < n && compare(arr[right], arr[largest], comp) > 0) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest, comp);
        }
    }
    
    /* ----------------- Swap Utility ----------------- */
    
    /**
     * Utility method to swap two elements in an array.
     *
     * @param arr the array.
     * @param i index of the first element.
     * @param j index of the second element.
     * @param <T> the type of objects.
     */
    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
