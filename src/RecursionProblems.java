import java.util.*;

/**
 * Implementations of various different recursion problems.
 * Author: Robert Saunders
 */
public class RecursionProblems {

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
