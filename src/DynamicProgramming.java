import java.util.*;

class NodeBounds {
    int upperBound;
    int lowerBound;
    BinaryTreeNode node;

    NodeBounds(BinaryTreeNode node, int upperBound, int lowerBound) {
        this.node = node;
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
    }
}


/**
 * Cake structure for cake thief question.
 * See interview cake, "The Cake Thief" question.
 */
class CakeType {

    int value;
    int weight;

    CakeType(int value, int weight) {
        this.weight = weight;
        this.value = value;
    }
}

class InfinityException extends RuntimeException {
    public InfinityException() {
        super("Max value is infinity!");
    }
}

/**
 * Implementation of different dynamic programming problems.
 * Has recursive and tabulation implementations.
 * Author: Robert Saunders
 */
public class DynamicProgramming {

    ////////////////
    /* Fibonacci */
    //////////////

    private Map<Integer, Integer> fibMemo = new HashMap<>();

    /**
     * Memoize version of the fibonacci number finder.
     * @param n The nth fibonacci number to find.
     * @return The nth fibonacci number.
     */
    public int fibMemoize(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("n cannot be less than 0!");
        }

        if (n == 0 || n == 1) {
            return n;
        }

        if (fibMemo.containsKey(n)) {
            return fibMemo.get(n);
        }

        int result = fib(n-1) + fib(n-2);

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
     * @param n The nth fibonacci number to find.
     * @return The nth fibonacci number.
     */
    public int fibBottonUp(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("n cannot be less than 0!");
        } else if (n == 0 || n == 1) {
            return n;
        }

        int prevPrev = 0; // 0th fibonacci number
        int prev = 1; // 1st fibonacci number
        int current = 0; // the current number we are on

        for (int i = 1; i < n; i++) {
            current = prevPrev + prev;
            prevPrev = prev;
            prev = current;
        }

        return current;
    }

    /////////////////////
    /* The Cake Thief */
    ///////////////////

    /**
     * Computes the maximum value in cakes that can fit in the bag.
     * @param cakes Array of cakes to choose from.
     * @param weightCapacity The capacity of the bag.
     * @return The maximum value in cakes that could be put in the bag.
     */
    public long maxDuffelBagValue(CakeType[] cakes, int weightCapacity) {

        long[] maxValuesAtCapacities = new long[weightCapacity+1];

        for (int currentCapacity = 0; currentCapacity <= weightCapacity; currentCapacity++) {

            long maxValueForCapacity = 0;

            for (CakeType cake : cakes) {

                if (cake.weight == 0 && cake.value != 0) {
                    throw new InfinityException();
                }

                if (cake.weight < currentCapacity) {
                    long maxValueUsingCake = cake.weight + maxValuesAtCapacities[currentCapacity-cake.weight];

                    maxValueForCapacity = Math.max(maxValueForCapacity, maxValueUsingCake);
                }
            }

            maxValuesAtCapacities[currentCapacity] = maxValueForCapacity;

        }

        return maxValuesAtCapacities[weightCapacity];
    }

    ////////////////////
    /* Making Change */
    //////////////////

    /**
     * Calculates number of ways to group coins to equal given amount.
     * @param amount The amount to add the coins up to.
     * @param denominations The coin denominations available.
     * @return The number of ways the coins can be grouped together.
     */
    public static int computeCoinCollectionWays(int amount, int[] denominations) {
        return computeCoinCollectionWays(amount, denominations, 0);
    }

    /**
     *
     * @param amountLeft
     * @param denominations
     * @param currentIndex
     * @return
     */
    private static int computeCoinCollectionWays(int amountLeft, int[] denominations, int currentIndex) {
        if (amountLeft == 0) {
            return 1;
        }

        if (amountLeft < 0) {
            return 0;
        }

        if (currentIndex == denominations.length) {
            return 0;
        }

        int currentCoin = denominations[currentIndex];

        int numPossibilities = 0;
        while (amountLeft >= 0) {
            numPossibilities += computeCoinCollectionWays(amountLeft, denominations, ++currentIndex);
            amountLeft -= currentCoin;
        }

        return numPossibilities;
    }

    /**
     *
     * @param amount
     * @param denominations
     * @return
     */
    private static int computeCoinCollectionWaysBottomUp(int amount, int[] denominations) {
        int[] waysOfDoingNCents = new int[amount +1];

        waysOfDoingNCents[0] = 1; // one way to make zero

        for (int coin : denominations) {
            for (int higherAmount = coin; higherAmount <= amount; higherAmount++) {
                int higherAmountRemainder = higherAmount - coin;
                waysOfDoingNCents[higherAmount] += waysOfDoingNCents[higherAmountRemainder];
            }
        }

        return waysOfDoingNCents[amount];
    }

    ///////////////////
    /* Apple Stocks */
    /////////////////

    /**
     * Gets the max profit that could have been earned from a sorted list of stock prices.
     * @param stockPrices The stock prices, sorted by time.
     * @return The max profit that could have been earned.
     */
    public static int getMaxProfit(int[] stockPrices) {

        // first check if we can even calculate a profit
        if (stockPrices.length < 2) {
            throw new IllegalArgumentException("To calculate a profit we need at lease two stock prices.");
        }

        // initialize the min price to be first price
        // initialize max profit to be first pair
        int minPrice = stockPrices[0];
        int maxProfit = stockPrices[1] - stockPrices[0];

        // greedily iterate through each stock price
        // check potential profit against current min
        // update maxProfit if needed
        // update minPrice if needed
        for(int i = 1; i < stockPrices.length; i++) {

            int currentPrice = stockPrices[i];

            int potentialProfit = currentPrice - minPrice;

            maxProfit = Math.max(maxProfit, potentialProfit);

            minPrice = Math.min(minPrice, currentPrice);
        }

        // return the max profit
        return maxProfit;
    }

    //////////////
    /* Testing */
    ////////////

    /**
     * Main execution method used for testing problems.
     * @param args Arguments passed into execution.
     */
    public static void main(String[] args) {

        System.out.println(DynamicProgramming.computeCoinCollectionWays(4, new int[]{1, 2, 3, 4}));

        DynamicProgramming.getProductsOfAllIntsExceptAtIndex(new int[]{1, 7, 3, 4});
        DynamicProgramming.getProductsOfAllIntsExceptAtIndexGreedy(new int[]{1, 7, 3, 4});
        System.out.println(DynamicProgramming.getHighestProductOfThree(new int[]{-10, -10, 1, 3, 2}));

    }
}
