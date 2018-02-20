import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Various implementations of string manipulation questions.
 * Also includes useful string comparison algorithms.
 * Author: Robert Saunders
 */
public class StringProblems {

    // finding the longest palindrome in a given string,
    // find the biggest common substring in 2 strings, "abcdef" "gbcdh" would return "bcd"
    // build a palindrome
    // Two texts are considered to "match" if they have a common substring of at least length n. Describe an algorithm to determine if two strings are matches.  
    // Write a function that takes in two binary strings and returns their sum (also a binary string).  
    // remove duplicates in a string.  

    // given an array of strings, find all the lists of anagrams present. (same as below) 
    // Given a list of strings, return a list of lists of strings, which represents the list grouping strings by whether they are anagrams of one another.  
    // Given a string write a function which prints all the subsets of the string. Now make the function to return only unique solutions.

    ///////////////////////////////////////////
    /* PERMUTATIONS OF STRING IS PALINDROME */
    /////////////////////////////////////////

    /**
     * Returns true if any permutation of a string is a palindrome.
     * Note: Key take away here is that palindrome only has 0 or 1 unpaired characters.
     * @param inputString The input string to check.
     * @return True if a permutation is a palindrome.
     */
    public static boolean anyPermutationAPalindrome(String inputString) {

        HashSet<Character> unpairedChars = new HashSet<>();

        for(char current : inputString.toCharArray()) {
            if (unpairedChars.contains(current)) {
                unpairedChars.remove(current);
            } else {
                unpairedChars.add(current);
            }
        }

        return unpairedChars.size() <= 1;
    }

    /////////////////////////////
    /* REVERSE WORDS IN-PLACE */
    ///////////////////////////

    /**
     * Reverses a group of words (sentence) separated by spaces.
     * @param inputString The string of words to be reversed.
     * @return The reversed group of words.
     */
    public static String reverseWordsInPlace(String inputString) {

        // reverse all the characters in entire sentence, this gives us the correct word order
        // then reverse the characters in each individual word
        return null;
    }

    //////////////////////////////
    /* REVERSE STRING IN-PLACE */
    ////////////////////////////

    /**
     * Reverses a string in-place and returns the reversed string.
     * Note: Strings are immutable in Java so I create a char array.
     * @param inputString The string to reverse.
     * @return The reversed string.
     */
    public static String reverseStringInPlace(String inputString) {

        char[] charsInString = inputString.toCharArray();

        int startIndex = 0;
        int endIndex = charsInString.length;

        while(startIndex < endIndex) {

            char tmp = charsInString[startIndex];
            charsInString[startIndex] = charsInString[endIndex];
            charsInString[endIndex] = tmp;

            startIndex++;
            endIndex--;
        }

        return new String(charsInString);
    }

    //////////////////////
    /* TIME CONVERSION */
    ////////////////////

    /**
     * Converts 12 hour time to 24 hour time.
     * Good practice for messing with strings.
     * @param s The twelve hour time to be converted to 24 hour time.
     * @return The twenty four hour time after conversion.
     */
    public static String timeConversion(String s) {
        java.lang.String[] units = s.split(":");
        int hours = Integer.parseInt(units[0]);
        int minutes = Integer.parseInt(units[1]);
        int seconds = Integer.parseInt(units[2].substring(0,2));
        java.lang.String AMPM = units[2].substring(2,4);

        if (AMPM.equals("PM") && hours < 12) {
            hours += 12;
        } else if (AMPM.equals("AM") && hours == 12) {
            hours = 0;
        }

        return java.lang.String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    ///////////////////////////
    /* PARENTHESIS MATCHING */
    /////////////////////////

    /**
     * Finds the matching closing parenthesis given the position of the opening parenthesis.
     * @param expression The expression to be checked for matching parenthesis.
     * @param position The position (index) of the opening parenthesis.
     * @return The position of the closing parenthesis.
     */
    public static int findMatchingParens(java.lang.String expression, int position) {
        return 1;
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
    public boolean isUniqueCharacters(java.lang.String stringToCheck) {
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
    public static int countNumTimesCharOccursInString(java.lang.String stringToCheck, char checkChar) {

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
    public static int countCharOccurence(java.lang.String stringToCheck, char checkChar) {
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
    public static Boolean isAnagramArraySort(java.lang.String string1, java.lang.String string2) {

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
    public static Boolean isAnagramCounter(java.lang.String string1, java.lang.String string2) {

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
    public static void main(java.lang.String[] args) {
        System.out.println(StringProblems.countNumTimesCharOccursInString("Hello", 'j'));
        System.out.println(StringProblems.countCharOccurence("Hello", 'e'));
        System.out.println(StringProblems.isPalindrome("racecar"));
        System.out.println(StringProblems.reverseStringInPlace("bobby"));
    }
}
