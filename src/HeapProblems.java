import java.util.*;

/**
 * Implementation of a heap, includes problems that use heaps.
 * Note: In java you can use PriorityQueue to achieve the same thing.
 * Author: Robert Saunders
 */
class HeapProblems {

    private static void addToHeap(int num, PriorityQueue<Integer> lowers, PriorityQueue<Integer> biggers) {
        if (lowers.size() == 0 || num < lowers.peek()) {
            lowers.add(num);
        } else {
            biggers.add(num);
        }
    }

    private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> biggers) {
        PriorityQueue<Integer> biggerHeap = (biggers.size() > lowers.size()) ? biggers : lowers;
        PriorityQueue<Integer> smallerHeap = (biggers.size() > lowers.size()) ? lowers : biggers;

        if ((biggerHeap.size() - smallerHeap.size()) > 1) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> biggers) {
        PriorityQueue<Integer> biggerHeap = (biggers.size() > lowers.size()) ? biggers : lowers;
        PriorityQueue<Integer> smallerHeap = (biggers.size() > lowers.size()) ? lowers : biggers;

        if (biggerHeap.size() == smallerHeap.size()) {
            return ((double)biggerHeap.peek() + smallerHeap.peek())/2;
        } else {
            return biggerHeap.peek();
        }
    }


    private static double[] getMedians(int[] numbers) {
        PriorityQueue<Integer> biggers = new PriorityQueue<Integer>();
        PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer one, Integer two) {
                return two - one;
            }
        });

        double[] medians = new double[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            addToHeap(numbers[i], lowers, biggers);
            rebalance(lowers, biggers);
            double median = getMedian(lowers, biggers);
            medians[i] = median;
        }

        return medians;
    }

    //////////////
    /* TESTING */
    ////////////

    /**
     * Main execution method, used for testing.
     * @param args The arguments passed into execution.
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        double[] finalMedians = getMedians(a);

        for (double median : finalMedians) {
            System.out.println(median);
        }
    }
}
