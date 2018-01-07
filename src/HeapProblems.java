import java.util.*;

/**
 * Implementation of a heap, includes problems that use heaps.
 * Note: In java you can use PriorityQueue to achieve the same thing.
 * Author: Robert Saunders
 */
public class HeapProblems {

    // two heaps, one is a min heap and the other is a max heap
    // characteristics of a heap is that we always add a new node to the first available position (left most position), then we can heapify up
    // when we want to remove the min or max element we pop it off the top and take the bottom node and heapify down
    // we could represent these heaps using a tree and custom construct, but because the children are predictable we can use an array

    // in a heap all that matters is that the parent node is greater or less than the children, there is no distinction between the left and right, such as a binary search tree


    //           1
    //          / \
    //         2   3
    //        / \
    //       6   5

    // [1, 2, 3, 6, 5]
    //  0  1  2  3  4
    // left child are 2n+1
    // right child is 2n+2

    // parent node is (n-1)/2
/*
    int[] heap;
    int capacity;

    Heap() {
        this.heap = new int[10];
        this.capacity = 10;
    }

    Heap(int capacity) {
        this.heap = new int[capacity];
        this.capacity = capacity;
    }

    public int getParentIndex(int childIndex) { return (childIndex-1)/ 2; }
    public int getLeftChildIndex(int parentIndex) { return 2*parentIndex + 1; }
    public int getRightChildIndex(int parentIndex) { return 2*parentIndex + 2; }

    public poll() {
        // removes the min or max value
    }

    public peek() {
        return heap[0];
    }
}

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
            @Override           2 4
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

    public static void main(Strings[] args) {

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
    */
}
