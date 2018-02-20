import java.util.*;

/**
 * Implementations of various different recursion problems.
 * Author: Robert Saunders
 */
public class RecursionProblems {


    ////////////////////////////////////////
    /* ALL PATHS FOR ROBOT IN NXN MATRIX */
    //////////////////////////////////////

    /**
     * Finds the number of paths a robot could take from top left of matrix to bottom right.
     * Note: This implementation uses recursion, the one below does not.
     * @param rows The number of rows in the matrix.
     * @param cols The number of columns in the matrix.
     * @return The number of paths the robot could take.
     */
    public static int countPathsRecursive(int rows, int cols) {

        // if either the row of column is one
        // then they are neighbors and there is one path
        if (rows == 1 || cols == 1) {
            return 1;
        }

        return countPathsRecursive(rows-1, cols) + countPathsRecursive(rows, cols-1);
    }

    /**
     * Finds the number of paths a robot could take from top left of matrix to bottom right.
     * Note: This implementation uses a table to keep track of overlapping subproblems.
     * @param rows The number of rows in the matrix.
     * @param cols The number of columns in the matrix.
     * @return The number of paths the robot could take.
     */
    public static int countPathsMemo(int rows, int cols) {

        int[][] countPaths = new int[rows][cols];

        for(int r = 0; r < rows; r++) {
            countPaths[r][0] = 1;
        }

        for(int c = 0; c < cols; c++) {
            countPaths[0][c] = 1;
        }

        for(int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                countPaths[row][col] = countPaths[row][col-1] + countPaths[row-1][col];
            }
        }

        return countPaths[rows-1][cols-1];
    }

    /////////////////////////
    /* FIBONACCI SEQUENCE */
    ///////////////////////

    /**
     * Memoize version of the fibonacci number finder.
     * @param fibMemo Memoization table for the stored values;
     * @param n The nth fibonacci number to find.
     * @return The nth fibonacci number.
     */
    public int fibMemoize(int n, HashMap<Integer, Integer> fibMemo) {

        if (n < 0) {
            throw new IllegalArgumentException("n cannot be less than 0!");
        }

        if (n == 0 || n == 1) {
            return n;
        }

        if (fibMemo.containsKey(n)) {
            return fibMemo.get(n);
        }

        int result = fibMemoize(n-1, fibMemo) + fibMemoize(n-2, fibMemo);

        fibMemo.put(n, result);

        return result;
    }

    /**
     * Non memoize version of the fibonacci number finder.
     * @param n The nth fibonacci number to find.
     * @return The nth fibonacci number.
     */
    public int fib(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("n cannot be less than 0!");
        }

        if (n == 1 || n == 0) {
            return n;
        }

        return fib(n-1) + fib(n-2);
    }

    /**
     * Bottom up implementation of the fibonacci number finder.
     * Note: This is not the recursive solution, just a bottom up version.
     * @param n The nth fibonacci number to find.
     * @return The nth fibonacci number.
     */
    public int fibBottonUp(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("n cannot be less than 0!");
        }

        if (n == 0 || n == 1) {
            return n;
        }

        int prevPrev = 0;
        int prev = 1;
        int current = 0;

        for (int i = 1; i < n; i++) {
            current = prevPrev + prev;
            prevPrev = prev;
            prev = current;
        }

        return current;
    }

    /////////////////////////////////
    /* ALL PERMUTATIONS OF STRING */
    ///////////////////////////////

    /**
     * Computes all permutations of an input string.
     * @param inputString The input string to get permutations from.
     * @return The permutations of the input string.
     */
    public static Set<String> getPerms(String inputString) {

        if (inputString.length() <= 1) {
            return new HashSet<>(Arrays.asList(inputString));
        }

        String allCharactersExceptLast = inputString.substring(0, inputString.length()-1);
        char lastCharacter = inputString.charAt(inputString.length());

        Set<String> permutationsOfAllButLastCharacter = getPerms(allCharactersExceptLast);

        Set<String> permutations = new HashSet<>();
        for(String permutationExcludingLastCharacter : permutationsOfAllButLastCharacter) {
            for(int position = 0; position <= allCharactersExceptLast.length(); position++) {
                String permutation = permutationExcludingLastCharacter.substring(0, position) + lastCharacter + permutationExcludingLastCharacter.substring(position);
                permutations.add(permutation);
            }
        }
        return permutations;
    }

    //////////////
    /* TESTING */
    ////////////

    /**
     * Main execution method, primarily used for testing.
     * @param args The arguments passed into testing.
     */
    public static void main(StringProblems[] args) {

        // test getting the permutations of an input string
        Set<String> permutations = getPerms("c");
        // print the permutations out
        System.out.println("The permutations of 'c' are:");
        System.out.print(permutations);

        // test getting the permutations of a larger input string
        Set<String> permutationsTwo = getPerms("cats");
        // print the permutations out
        System.out.println("The permutations of 'cats' are:");
        System.out.print(permutationsTwo);

    }
}
