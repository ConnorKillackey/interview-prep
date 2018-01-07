import java.util.Arrays;
import java.util.HashMap;

/**
 * Various implementations of string manipulation questions.
 * Also includes useful string comparison algorithms.
 * Author: Robert Saunders
 */
public class Strings {

    static String timeConversion(String s) {
        String[] units = s.split(":");
        int hours = Integer.parseInt(units[0]);
        int minutes = Integer.parseInt(units[1]);
        int seconds = Integer.parseInt(units[2].substring(0,2));
        String AMPM = units[2].substring(2,4);

        if (AMPM.equals("PM") && hours < 12) {
            hours += 12;
        } else if (AMPM.equals("AM") && hours == 12) {
            hours = 0;
        }

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);

    }

    ///////////////////////////
    /* PARENTHESIS MATCHING */
    /////////////////////////

    /**
     * Finds the matching closing parenthesis given the position of the openting parenthesis.
     * @param expression The expression to be checked for matching parenthesis.
     * @param position The position (index) of the opening parenthesis.
     * @return The position of the closing parenthesis.
     */
    public static int findMatchingParens(String expression, int position) {
        return 1;
    }

    //////////////////////
    /* STRING BALANCED */
    /////////////////////

    /**
     * Checks if a string expression has balanced brackets.
     * Implemented using a stack to keep track of active brackets.
     * @param expression The expression to check.
     * @return True if balanced and false otherwise.
     */
    public static boolean isBracketBalanced(String expression) {
        // write this one
        return true;
    }

    /////////////////////////
    /* PALINDROME CHECKER */
    ///////////////////////

    /**
     * Checks if a string is a palindrome or not.
     * @param checkString The string to check.
     * @return True if is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String checkString) {
        for (int i = 0; i < checkString.length() - 1; i++) {
            int difference = checkString.length() - (i+1);
            if ((difference > 1) && (checkString.charAt(i) != checkString.charAt(difference))) {
                return false;
            }
        }

        return true;
    }

    ///////////////////////////
    /* IS UNIQUE CHARACTERS */
    /////////////////////////

    /**
     * Checks if a string has all unique characters.
     * Implementation is that of counting sort.
     * Could cross reference with every other character in array.
     * @param stringToCheck The string to check.
     * @return True if the string has all unique characters.
     */
    public boolean isUniqueCharacters(String stringToCheck) {
        // assuming string has only ASCII characters
        // create array of booleans
        boolean[] values = new boolean[256];

        // iterate through the string
        // check if char has already been added to array
        for (int i = 0; i<stringToCheck.length(); i++) {
            int curr = stringToCheck.charAt(i);
            if (values[curr]) return false;
            values[curr] = true;
        }

        return true;
    }

    ///////////////////////////
    /* CHARACTER OCCURRENCE */
    /////////////////////////

    /**
     * Counts the number of times a character appears in a string.
     * This is a bad implementation, because it counts every character, not the one we care about.
     * Although one could argue this is better, because prevents reuse later.
     * Can't get better than O(n) here because have to check every character.
     * @param stringToCheck The string to check.
     * @param checkChar The char to check occurs.
     * @return The number of times the character appears.
     */
    public static int countNumTimesCharOccursInString(String stringToCheck, char checkChar) {

        // convert the string into a character array
        // initialize a hash map to keep count of characters
        char[] charArray = stringToCheck.toCharArray();
        HashMap<Character, Integer> table = new HashMap<>();

        // iterate through each character
        // update count in table
        for (char current : charArray) {
            if (table.containsKey(current)) {
                int count = table.get(current);
                table.put(current, ++count);
            } else {
                table.put(current, 1);
            }
        }

        // return the count in the table or zero if character isn't in table
        return table.containsKey(checkChar) ? table.get(checkChar) : 0;
    }

    /**
     * Counts the number of times a character occurs in a string.
     * @param stringToCheck The string to check.
     * @param checkChar The character to check.
     * @return The count of times the character occurred in word.
     */
    public static int countCharOccurence(String stringToCheck, char checkChar) {
        //create a counter
        int counter = 0;

        // go through each character and check if equal to checkChar
        // update the counter if it is
        for (int i = 0; i < stringToCheck.length(); i++) {
            if (stringToCheck.charAt(i) == checkChar) {
                counter++;
            }
        }

        // return the counter
        return counter;
    }

    /////////////////////
    /* CHECK ANAGRAMS */
    ///////////////////

    /**
     * Checks if two strings are anagrams.
     * Implementation with sorting arrays and comparing.
     * Note anagrams are strings that have all the same characters.
     * @param string1 First string to compare with.
     * @param string2 Second string to compare with.
     * @return True if anagrams, otherwise false;
     */
    public static Boolean isAnagramArraySort(String string1, String string2) {

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
    public static Boolean isAnagramCounter(String string1, String string2) {

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
        System.out.println(Strings.countNumTimesCharOccursInString("Hello", 'j'));
        System.out.println(Strings.countCharOccurence("Hello", 'e'));
        System.out.println(Strings.isPalindrome("racecar"));
    }
}
