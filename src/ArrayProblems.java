import java.util.Arrays;

/**
 * Implementation of various different array problems.
 * Author: Robert Saunders
 */
public class ArrayProblems {

    ////////////////
    /* THREE SUM */
    //////////////

    /**
     * Naive implementation of the triplet sum question.
     * @param numArray The array of numbers to search for a triplet.
     * @param sum The sum to find a triplet for.
     * @return The triplet as an array.
     */
    public static int[] naiveTripletSum(int[] numArray, int sum) {

        if (numArray.length == 0) {
            throw new IllegalArgumentException("Need some elements in the array!");
        }

        int[] triplet = new int[3];

        for (int i = 0; i < numArray.length - 2; i++) {
            for (int j = i+1; j < numArray.length - 1; j++) {
                for (int k = j+1; k < numArray.length; k++) {
                    if (numArray[i] + numArray[j] + numArray[k] == sum) {
                        triplet[0] = numArray[i];
                        triplet[1] = numArray[j];
                        triplet[2] = numArray[k];
                        return triplet;
                    }
                }
            }
        }

        return null;
    }

    /**
     * A better implementation of the triplet sum problem.
     * @param numArray The array of numbers to search for a triplet.
     * @param target The target to find a triplet for.
     * @return The triplet as an array.
     */
    public static int[] goodTripletSum(int[] numArray, int target) {

        int[] triplet = new int[3];

        Arrays.sort(numArray);

        int left, right;

        for (int i = 0; i < numArray.length-2; i++) {

            left = i + 1;
            right = numArray.length-1;

            while(left < right) {
                int sum = numArray[i] + numArray[left] + numArray[right];
                if (sum == target) {
                    triplet[0] = numArray[i];
                    triplet[1] = numArray[left];
                    triplet[2] = numArray[right];
                    break;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return triplet;
    }


    // fisher yates shuffle (get a random element to put at that index)

    // window sliding problem, largest sum of n consecutive numbers

    // longest common subsequence

    // smallest subarray with sum greater than given input

    // merging two sorted arrays

    // min and max of unsorted array

    // quadruples

    // longest sequence of increasing numbers

    // finding maximum subarray sum (similar to Kadane's Algorithm) with the constraint that two numbers in the array that form the max sum cannot be next to each other.

    // minimum size subarray sum

    // Given a sorted array, write a program to decide if two elements sum up to a third.  

    // Given an array of positive ints and an integer K, determine if a subsequence in the array sums to K. Solve in linear time.  

    // contiguous subsets

    // *continuous sequence* of A that sums up to exactly T

    // Given a list of integers and a target number, list all pairs that sum up to that number

    // Given an array of integers, write an in-place function to bring all the non-zero elements to the left of the array keeping the original order.

    // Boggle game - given a board of letters (2d array) and a word (string), return whether the word exists in the board. From each letter you can move in all directions (including diagonals), but you cannot use the same letter twice.


    public static void main(String[] args) {
        int[] array = { 2, 4, 1, 7};
        int[] triplet = ArrayProblems.goodTripletSum(array, 7);
        int[] triplet2 = ArrayProblems.naiveTripletSum(array, 7);

    }
}
