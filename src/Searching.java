/**
 * Implementation of various different searching algorithms.
 * Important to know the pros can cons of each.
 * Author: Robert Saunders
 */
public class Searching {

    public static Boolean binarySearchRecursive(int[] array, int target) {
        return true;
    };


    public static Boolean binarySearchIterative(int[] array, int target) {
        return true;
    }

    /**
     * Ice cream parlor problem.
     * @param menu
     * @param money
     * @return
     */
    public static int[] findChoices(int[] menu, int money) {
        return new int[]{ 1, 2 };
    }

     /**
     * Implementation of the binary search algorithm.
     * Good for ordered pair of numbers, continually half's array.
     * @param numbers The numbers to search within.
     * @param target The target number to find within the array.
     * @return True if the number exists in array, false otherwise.
     */
    public static Boolean binarySearch(int[] numbers, int target) {

        // set the bounds
        int floorIndex = -1;
        int ceilingIndex = numbers.length;

        // keep performing search
        // until bounds are the same
        while (floorIndex + 1 < ceilingIndex) {

            // compute the half distance
            int distance = ceilingIndex - floorIndex;
            int halfDistance = distance/2;
            int guessIndex = floorIndex + halfDistance;

            // take a guess
            int guessValue = numbers[guessIndex];

            // return true if the guess is correct
            // otherwise update the bounds accordingly
            if (guessValue == target) {
                return true;
            }
            if (guessValue > target) {
                ceilingIndex = guessIndex;
            } else {
                floorIndex = guessIndex;
            }
        }

        // return false
        return false;
    }

    //////////////
    /* TESTING */
    ////////////

    /**
     * Main execution method used for testing problems.
     * @param args Arguments passed into execution.
     */
    public static void main(String[] args) {
        System.out.println("Using binary search to find 0 in {1,2,3,4}: " + Searching.binarySearch(new int[]{1, 2, 3, 4}, 0)); // output should be false
        System.out.println("Using binary search to find 2 in {1,2,3,4}: " + Searching.binarySearch(new int[]{1,2,3,4}, 2)); // output should be true
    }
}
