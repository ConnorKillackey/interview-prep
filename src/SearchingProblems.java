/**
 * Implementation of various different searching algorithms.
 * Important to know the pros can cons of each.
 * Author: Robert Saunders
 */
public class SearchingProblems {

    public static Boolean binarySearchRecursive(int[] array, int target) {
        return true;
    };


    public static Boolean binarySearchIterative(int[] array, int target) {
        return true;
    }


    private static int indexOf(int[] menu, int value, int excludeIndex) {
        for(int i = 1; i <= menu.length; i++) {
            if (value == menu[i-1] && i != excludeIndex) {
                return i;
            }
        }
        return -1;
    }

    private static int[] getIndicesFromValues(int[] menu, int value1, int value2) {
        int index1 = indexOf(menu, value1, -1);
        int index2 = indexOf(menu, value2, index1);
        int[] indices = {Math.min(index1, index2), Math.max(index1, index2)};
        return indices;
    }

    public static int[] icecreamParlor(int money, int[] menu) {
        int[] sortedMenu = menu.clone();
        Arrays.sort(sortedMenu);

        for (int i = 0; i < sortedMenu.length; i++) {
            int complement = money - sortedMenu[i];

            int location = Arrays.binarySearch(sortedMenu, i+1, sortedMenu.length, complement);
            if (location >= 0 && location < sortedMenu.length && sortedMenu[location] == complement) {
                int[] indices = getIndicesFromValues(menu, sortedMenu[i], complement);
                return indices;
            }
        }

        return null;
    }

    public static void main(StringProblems[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int[] result = icecreamParlor(m, arr);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");


        }
        in.close();
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
    public static void main(StringProblems[] args) {
        System.out.println("Using binary search to find 0 in {1,2,3,4}: " + SearchingProblems.binarySearch(new int[]{1, 2, 3, 4}, 0)); // output should be false
        System.out.println("Using binary search to find 2 in {1,2,3,4}: " + SearchingProblems.binarySearch(new int[]{1,2,3,4}, 2)); // output should be true
    }
}
