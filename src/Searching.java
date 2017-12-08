/**
 * Implementation of various different searching algorithms.
 * Author: Robert Saunders
 */
public class Searching {

    //////////////////////////
    /* Find in Ordered Set */
    ////////////////////////

    public static Boolean binarySearch(int[] numbers, int target) {

        int floorIndex = -1;
        int ceilingIndex = numbers.length;

        while (floorIndex + 1 < ceilingIndex) {
            int distance = ceilingIndex - floorIndex;
            int halfDistance = distance/2;
            int guessIndex = floorIndex + halfDistance;

            int guessValue = numbers[guessIndex];

            if (guessValue == target) {
                return true;
            }

            if (guessValue > target) {
                ceilingIndex = guessIndex;
            } else {
                floorIndex = guessIndex;
            }
        }

        return false;
    }
}
