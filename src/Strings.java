import java.util.Arrays;

/**
 * Various implementations of string manipulation questions.
 * Also includes useful string comparison algorithms.
 * Author: Robert Saunders
 */
public class Strings {

    /**
     * Checks if two strings are anagrams.
     * Implementation with sorting arrays and comparing.
     * @param string1 First string to compare with.
     * @param string2 Second string to compare with.
     * @return True if anagrams, otherwise false;
     */
    public Boolean isAnagramArraySort(String string1, String string2) {

        // first check if the strings match in length
        if (string1.length() != string2.length()) {
            return false;
        }

        // create the char arrays and check if they are equal
        char[] firstString = string1.toCharArray();
        char[] secondString = string2.toCharArray();
        Arrays.sort(firstString);
        Arrays.sort(secondString);

        // return the result of the equality check
        return Arrays.equals(firstString, secondString);
    }

    /**
     * Checks if two strings are anagrams.
     * Implementation with a counter array.
     * @param string1 First string to compare with.
     * @param string2 Second string to compare with.
     * @return True if anagrams, otherwise false.
     */
    public Boolean isAnagramCounter(String string1, String string2) {

        // first check if the strings match in length
        if (string1.length() != string1.length()) {
            return false;
        }

        // create space capped counter array
        // capped to size 26 because 26 in alphabet
        int[] counter = new int[26];

        // iterate through first string
        // update count at char index
        for (int i = 0; i<string1.length(); i++) {
            counter[string1.charAt(i) - 'a']++;
        }

        // iterate through the second string
        // if any count goes below zero its not an anagram
        for (int k = 0; k<string2.length(); k++) {
            counter[string2.charAt(k) - 'a']--;
            if (counter[string2.charAt(k) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    //////////////
    /* TESTING */
    ////////////

    /**
     * Main execution method to test implementation.
     * @param args Arguments passed into the execution.
     */
    public static void main(String[] args) {

    }
}
