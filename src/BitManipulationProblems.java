import java.util.Scanner;

/**
 * Implementation of different bit manipulation problems.
 * Author: Robert Saunders
 */
public class BitManipulationProblems {

    /**
     * Determines the unique integer in a list of pairs.
     * @param a The list of numbers that have one unique non pair number.
     * @return The unique number in the list.
     */
    public static int lonelyInteger(int[] a) {
        int result = 0;
        for (int num : a) {
            result ^= num;
        }
        return result;
    }

    //////////////
    /* TESTING */
    ////////////

    /**
     * Main execution method, used for testing.
     * @param args The arguments passed into execution.
     */
    public static void main(StringProblems[] args) {

        Scanner scan = new Scanner(System.in);
        int numElements = scan.nextInt();
        int[] numbers = new int[numElements];

        for (int i = 0; i < numElements; i++) {
            numbers[i] = scan.nextInt();
        }

        System.out.println("The unique number in the array is: " + lonelyInteger(numbers));
    }
}
