/**
 * Implementations of various different sorting algorithms.
 * Important to know the pros and cons of each.
 * Author: Robert Saunders
 */
public class SortingProblems {

    static int[] closestNumbers(int[] arr) {
        Arrays.sort(arr);
        int lowestDifference = Integer.MAX_VALUE;
        ArrayList<Integer> pairs = new ArrayList<>();

        for(int i = 0; i < arr.length-1; i++) {
            int difference = Math.abs(arr[i+1] - arr[i]);

            if (difference < lowestDifference) {
                lowestDifference = difference;
                pairs.clear();
                pairs.add(arr[i]);
                pairs.add(arr[i+1]);
            }  else if (difference == lowestDifference) {
                pairs.add(arr[i]);
                pairs.add(arr[i+1]);
            }
        }

        int[] result = new int[pairs.size()];

        for(int i = 0; i < pairs.size(); i++) {
            result[i] = pairs.get(i);
        }

        return result;
    }

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

    static int[] countingSort(int[] arr) {

        int[] countingArray = new int[100];

        for (int num : arr) {
            countingArray[num]++;
        }

        int currentSortedIndex = 0;

        for(int num = 0; num < countingArray.length; num++) {
            int count = countingArray[num];

            for(int occurrence = 0; occurrence < count; occurrence++) {
                arr[currentSortedIndex] = num;
                currentSortedIndex++;
            }
        }

        return arr;
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

    // top scores

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
    public static void main(StringProblems args[]) {

    }
}
