/**
 * Implementations of greedy algorithms.
 * See comments above implementations for question.
 */
public class Greedy {

    ///////////////////////////////
    /* Highest Product of Three */
    /////////////////////////////

    /**
     * Gets the highest product from integers in the input array.
     * Note: this implementation does not account for negative numbers.
     * @param nums The group of input integers.
     * @return The highest product of three numbers in the array.
     */
    public static int getHighestProductOfThree(int[] nums) {

        // there must be at least three integers in input array
        if (nums.length < 3) {
            throw new IllegalArgumentException("There needs to be at least three numbers in the input array!");
        }

        // initialize trackers to track three largest numbers
        // set to negative infinity because that isn't a value in array
        int first, second, third;
        first = second = third = Integer.MIN_VALUE;

        // iterate through the numbers
        // update flags to indicate largest numbers
        for(int current : nums) {
            if (current > first) {
                third = second;
                second = first;
                first = current;
            } else if (current > second) {
                third = second;
                second = current;
            } else if (current > third) {
                third = current;
            }
        }

        // return the product of the three largest values
        return first * second * third;
    }

    /**
     * Gets the highest product from integers in the input array.
     * Note: This is a better approach versus above solution because accounts for negative numbers.
     * @param nums The group of input integers.
     * @return The highest product of three numbers in the array.
     */
    public static int getHighestProductOfThreeGreedy(int[] nums) {

        if (nums.length < 3) {
            throw new IllegalArgumentException("There needs to be at least three numbers in the input array!");
        }

        int highest = Math.max(nums[0], nums[1]);
        int lowest = Math.min(nums[0], nums[1]);

        int highestProductOf2 = nums[0] * nums[1];
        int lowestProductOf2 = nums[0] * nums[1];

        int highestProductOf3 = nums[0] * nums[1] * nums[2];

        for(int i = 2; i < nums.length; i++) {

            int current = nums[i];

            highestProductOf3 = Math.max(Math.max(current * highestProductOf2, highestProductOf3), current * lowestProductOf2);

            highestProductOf2 = Math.max(Math.max(current * highest, highestProductOf2), current * lowest);

            lowestProductOf2 = Math.min(Math.min(current * highest, lowestProductOf2), current * lowest);

            highest = Math.max(current, highest);

            lowest = Math.min(current, lowest);
        }

        return highestProductOf3;
    }

    ///////////////////////////////////
    /* Product of All Other Numbers */
    /////////////////////////////////

    /**
     * Finds product of every integer at the given index excluding the index value from calculation.
     * Note, this is the brute force implementation.
     * @param nums The numbers to find the products of.
     * @return An array with the products.
     */
    public static int[] getProductsOfAllIntsExceptAtIndex(int[] nums) {

        // catch edge case
        if (nums.length < 2) {
            throw new IllegalArgumentException("Need at least two numbers in input array!");
        }

        // initialize array of products
        // equal to length of input array
        int[] products = new int[nums.length];

        // iterate through array calculating product for each
        for (int i = 0; i < nums.length; i++) {

            // initialize product to be one
            int product = 1;

            // calculate product of all other numbers in array
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }

            // add the product to the products array
            products[i] = product;

        }

        // return products
        return products;
    }

    /**
     * Finds product of every integer at the given index excluding the index value from calculation.
     * Note: This is an improved version of algorithm above, using a greedy approach.
     * @param nums The numbers to find the products of.
     * @return An array with the products.
     */
    public static int[] getProductsOfAllIntsExceptAtIndexGreedy(int[] nums) {

        // create array to hold products
        // flag to keep track of product
        int[] productsOfAllIntsExceptIndex = new int[nums.length];
        int productSoFar = 1;

        // find the products before the index
        for (int i = 0; i < nums.length; i++) {
            productsOfAllIntsExceptIndex[i] = productSoFar;
            productSoFar *= nums[i];
        }

        // find the products after the index
        // reset the product so far flag
        productSoFar = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            productsOfAllIntsExceptIndex[j] *= productSoFar;
            productSoFar *= nums[j];
        }

        // return the array of products
        return productsOfAllIntsExceptIndex;
    }


    //////////////
    /* Testing */
    ////////////

    public static void main(String[] args) {

    }
}
