
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

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

    ////////////////////////////////
    /* MINIMUM SIZE SUBARRAY SUM */ //////////////////////////////
    /* CONTINUOUS SEQUENCE SUM */
    ////////////////////////////
    //////////////////////////////

    /**
     * Calculates the smallest subarray whos sum is greater than given sum.
     * This is the bad implementation, see below for better implementation.
     * @param numArray The array of numbers to find subarray in.
     * @param sum The sum that needs to be met by subarray.
     * @return The subarray as an integer array.
     */
    public static int smallestSubWithSum(int[] numArray, int sum) {

        int minLength = numArray.length + 1;

        for (int start = 0; start < numArray.length; start++) {
            int currentSum = numArray[start];

            if (currentSum >= sum) {
                return 1;
            }

            for (int end = start+1; end < numArray.length; end++) {

                currentSum += numArray[end];

                if (currentSum > sum && (end - start + 1) < minLength) {
                    minLength = (end - start + 1);
                }
            }
        }

        return minLength;
    }

    /**
     * Calculates the smallest subarray who's sum is greater than given sum.
     * This is the better implementation.
     * @param numArray The array of numbers to find subarray in.
     * @param sum The sum that needs to be met by subarray.
     * @return The subarray as an integer array.
     */
    public static int smallestSubWithSumBetter(int[] numArray, int sum) {

        int minLength = numArray.length + 1;
        int currentSum = 0;

        int start = 0, end = 0;

        while(end < numArray.length) {

            while(currentSum <= sum && end < numArray.length) {
                currentSum += numArray[end++];
            }

            while(currentSum > sum && start < numArray.length) {

                if ((end - start + 1) < minLength) {
                    minLength = (end - start + 1);
                }

                currentSum -= numArray[start++];
            }
        }

        return minLength;
    }

    ///////////////////////////////
    /* MAXIMUM VALUE SUBARRAY PROBLEM */
    /////////////////////////////

    public static int kandane(int[] numArray) {
        int current_max, global_max;
        current_max = global_max = numArray[0];

        for (int i = 1; i < numArray.length; i++) {
            current_max = Math.max(numArray[i], current_max + numArray[i]);

            if (current_max > global_max) {
                global_max = current_max;
            }
        }

        return global_max;
    }

    /////////////////////////////
    /* WINDOW SLIDING PROBLEM */
    ///////////////////////////

    /**
     * Calculates the largest sum of k consecutive numbers in an array.
     * @param numArray The array to look through.
     * @param k The number of consecutive numbers.
     * @return The maximum sum of k consecutive numbers.
     */
    public static int largestSumConsecutive(int[] numArray, int k) {

        int n = numArray.length;

        if (k > n) {
            throw new IllegalArgumentException("Not enough elements in array!");
        }

        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += numArray[i];
        }

        int windowSum = maxSum;
        for (int j = k; j < n; j++) {
            windowSum += numArray[j] - numArray[j-k];
            maxSum = Math.max(windowSum, maxSum);
        }

        return maxSum;
    }

    /////////////////////////////////////
    /* LONGEST INCREASING SUBSEQUENCE */
    ///////////////////////////////////

    //  3, 4, -1, 0, 6, 2, 3
    // temp array
    // n^2
    public static int lis(int arr[],int n) {
        int lis[] = new int[n];
        int i,j,max = 0;

          /* Initialize LIS values for all indexes */
        for ( i = 0; i < n; i++ )
            lis[i] = 1;

           /* Compute optimized LIS values in bottom up manner */
        for ( i = 1; i < n; i++ )
            for ( j = 0; j < i; j++ )
                if ( arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

           /* Pick maximum of all LIS values */
        for ( i = 0; i < n; i++ )
            if ( max < lis[i] )
                max = lis[i];

        return max;
    }

    /////////////////////////////////
    /* LONGEST COMMON SUBSEQUENCE */
    ///////////////////////////////

    int lcs( char *X, char *Y, int m, int n ) {
        if (m == 0 || n == 0)
            return 0;
        if (X[m-1] == Y[n-1])
            return 1 + lcs(X, Y, m-1, n-1);
        else
            return max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
    }

    //////////////////
    /* COUNT PAIRS */
    ////////////////

    // can also compute all pairs and see
    int getPairsCount(int arr[], int n, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Store counts of all elements in map m
        for (int i=0; i<n; i++)
            map.put(arr[i], 1);

        int twice_count = 0;

        // iterate through each element and increment the
        // count (Notice that every pair is counted twice)
        for (int i=0; i<n; i++)
        {
            twice_count += map[sum-arr[i]];

            // if (arr[i], arr[i]) pair satisfies the condition,
            // then we need to ensure that the count is
            // decreased by one such that the (arr[i], arr[i])
            // pair is not considered
            if (sum-arr[i] == arr[i])
                twice_count--;
        }

        // return the half of twice_count
        return twice_count/2;
    }

    // hash map, frequency counter

    ////////////////////
    /* SHUFFLE ARRAY */
    //////////////////

    static void randomize( int arr[], int n)
    {
        // Creating a object for Random class
        Random r = new Random();

        // Start from the last element and swap one by one. We don't
        // need to run for the first element that's why i > 0
        for (int i = n-1; i > 0; i--) {

            // Pick a random index from 0 to i
            int j = r.nextInt(i);

            // Swap arr[i] with the element at random index
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        // Prints the random array
        System.out.println(Arrays.toString(arr));
    }

    ////////////////////////
    /* MIN AND MAX ARRAY */
    //////////////////////



    /////////////////
    /* QUADRUPLES */
    ///////////////

    boolean findPairs(int arr[])
    {
        // Create an empty Hash to store mapping from sum to
        // pair indexes
        HashMap<Integer,pair> map = new HashMap<Integer,pair>();
        int n=arr.length;

        // Traverse through all possible pairs of arr[]
        for (int i=0; i<n; ++i)
        {
            for (int j=i+1; j<n; ++j)
            {
                // If sum of current pair is not in hash,
                // then store it and continue to next pair
                int sum = arr[i]+arr[j];
                if (!map.containsKey(sum))
                    map.put(sum,new pair(i,j));

                else // Else (Sum already present in hash)
                {
                    // Find previous pair
                    pair p = map.get(sum);

                    // Since array elements are distinct, we don't
                    // need to check if any element is common among pairs
                    System.out.println("("+arr[p.first]+", "+arr[p.second]+
                            ") and ("+arr[i]+", "+arr[j]+")");
                    return true;
                }
            }
        }
        return false;
    }

    /////////////////////
    /* SPARSE VECTORS */
    ///////////////////

    // store value and index

    /////////////////////////
    /* SUBSET SUM PROBLEM */
    ///////////////////////

    // NP Complete (no know polynomial time)
    public static boolean isSubsetSum(int set[], int n, int sum) {
        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;

        // If last element is greater than sum, then ignore it
        if (set[n-1] > sum)
            return isSubsetSum(set, n-1, sum);

       /* else, check if sum can be obtained by any of the following
          (a) including the last element
          (b) excluding the last element   */
        return isSubsetSum(set, n-1, sum) ||
                isSubsetSum(set, n-1, sum-set[n-1]);
    }

    // pusedopolynomial time, O(sum*n)
    static boolean isSubsetSumTwo(int set[], int n, int sum)  {
        // The value of subset[i][j] will be true if there
        // is a subset of set[0..j-1] with sum equal to i
        boolean subset[][] = new boolean[sum+1][n+1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        // If sum is not 0 and set is empty, then answer is false
        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

        // Fill the subset table in botton up manner
        for (int i = 1; i <= sum; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                subset[i][j] = subset[i][j-1];
                if (i >= set[j-1])
                    subset[i][j] = subset[i][j] ||
                            subset[i - set[j-1]][j-1];
            }
        }

        /* // uncomment this code to print table
         for (int i = 0; i <= sum; i++)
         {
           for (int j = 0; j <= n; j++)
              System.out.println (subset[i][j]);
         } */

        return subset[sum][n];
    }

    /////////////////////////////////
    /* MOVE ZEROS TO END OF ARRAY */
    ///////////////////////////////

    public static void pushZerosToEnd(int arr[], int n) {
        int count = 0;  // Count of non-zero elements

        // Traverse the array. If element encountered is
        // non-zero, then replace the element at index 'count'
        // with this element
        for (int i = 0; i < n; i++)
            if (arr[i] != 0)
                arr[count++] = arr[i]; // here count is
        // incremented

        // Now all non-zero elements have been shifted to
        // front and 'count' is set as index of first 0.
        // Make all elements 0 from count to end.
        while (count < n)
            arr[count++] = 0;
    }

    ///////////////////
    /* MERGE ARRAYS */
    /////////////////

    public static void mergeArrays(int[] arr1, int[] arr2, int n1, int n2, int[] arr3) {
        int i = 0, j = 0, k = 0;

        // Traverse both array
        while (i<n1 && j <n2)
        {
            // Check if current element of first
            // array is smaller than current element
            // of second array. If yes, store first
            // array element and increment first array
            // index. Otherwise do same with second array
            if (arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }

        // Store remaining elements of first array
        while (i < n1)
            arr3[k++] = arr1[i++];

        // Store remaining elements of second array
        while (j < n2)
            arr3[k++] = arr2[j++];
    }

    //////////////
    /* TESTING */
    ////////////

    /**
     * Main execution method, used for testing.
     * @param args The arguments passed into execution.
     */
    public static void main(String[] args) {
        int[] array = { 2, 4, 1, 7};
        int[] triplet = ArrayProblems.goodTripletSum(array, 7);
        int[] triplet2 = ArrayProblems.naiveTripletSum(array, 7);
    }
}
