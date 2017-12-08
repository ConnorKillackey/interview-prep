/**
 * Implementations of various different sorting algorithms.
 * Author: Robert Saunders
 */
public class Sorting {

    /**
     * Implementation of the merge sort algorithm.
     * Splits array in half, sorts each half, then merges halfs.
     * @param numArray The array to be sorted.
     * @return The sorted array.
     */
    public static int[] mergeSort(int[] numArray) {
        return null;
    }

    /**
     * Implementation of the quicksort algorithm.
     * @param numArray The array to be sorted.
     * @param pivot The pivot point for the algorithm.
     * @return The sorted algorithm.
     */
    public static int[] quickSort(int[] numArray, int pivot) {
        return null;
    }

    /**
     * Implmentation of the bubble sort algorithm.
     * Swaps consecutive elements until it can't anymore.
     * Sort is done in place to improve space complexity.
     * Note: I add a swapped flag, if no swap we can bail.
     * @param numArray The array to be sorted.
     * @return The sorted array.
     */
    public static void bubbleSort(int[] numArray) {
        boolean swapped;
        int n = numArray.length;
        int temp;

        for (int i = 0; i < n; i++) {
            swapped = false;
            for (int k = 1; k < (n-i); k++) {
                if (numArray[k - 1] > numArray[k]) {
                    swapped = true;
                    temp = numArray[k-1];
                    numArray[k-1] = numArray[k];
                    numArray[k] = temp;
                }
            }
            if(!swapped)
                break;
        }
    }

    /**
     * Implementation of the counting sort algorithm.
     * Good for sorting when you know the bounds of array.
     * @param numArray The array to sort.
     * @return The sorted array.
     */
    public static int[] countingSort(int[] numArray) {
        return null;
    }

    /**
     * Implementation of the heapsort algorithm.
     * @param numArray The array to be sorted.
     * @return The sorted array.
     */
    public static int[] heapsort(int[] numArray) {
        return null;
    }

    /**
     * Execution method used for testing.
     * @param args Arguments passed in for execution.
     */
    public static void main(String args[]) {

    }
}
