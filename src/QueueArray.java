/**
 * Implementation of a queue using an array.
 * Good for when you know the capacity of queue.
 * Author: Robert Saunders
 */
public class QueueArray {

    private int capacity;
    private int[] queue;
    private int front, size = 0;
    private int rear = -1;

    /**
     * Basic constructor for the queue.
     * @param capacity The capacity of the queue.
     */
    QueueArray(int capacity) {
        this.capacity = capacity;
        this.queue = new int[this.capacity];
    }

    /**
     * Checks if the queue is empty or not.
     * @return True if empty, false otherwise.
     */
    public Boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Checks if the queue is full or not.
     * @return True is full, false otherwise.
     */
    public Boolean isFull() {
        return this.size == this.capacity;
    }

    /**
     * Pops the first element off of the queue.
     * @return The first element in the queue.
     */
    public int dequeue() {

        // first check if the queue is empty
        // can't take anything from an empty queue
        if (isEmpty()) {
            throw new IllegalStateException("The queue is empty, can't dequeue!");
        }

        // get the value currently at the front
        int value = this.queue[front];

        // update where the front is in the queue
        // if the front is last element in queue set front to be zero index
        // if the front isnt, just move the next element queue, the new front
        if (front == capacity-1) {
            front = 0;
        } else {
            front++;
        }

        // update the size of the queue
        size--;

        // return the front
        return value;
    }

    /**
     * Pushes an element to the end of the queue.
     * @param value The value to be pushed onto the queue.
     */
    public void enqueue(int value) {

        // check if the queue is full
        // can't add anything if full
        if (isFull()) {
            throw new IllegalStateException("The queue is full, can't add anything!");
        }

        // create the new pointer to rear of list
        // if current rear is end of array set new rear to be zero
        // otherwise move to next available position
        if (rear == capacity-1) {
            rear = 0;
        } else {
            rear++;
        }

        // insert the value into the queue
        // update the size as well
        this.queue[rear] = value;
        size++;
    }

    /**
     * Looks at the first element in the queue but doesn't remove it.
     * @return The first element in the queue.
     */
    public int front() {
        return this.queue[this.front];
    }

    /**
     * Returns the last element in the queue but doesn't remove it.
     * @return The last element in the queue.
     */
    public int rear() {
        return this.queue[this.rear];
    }

    //////////////
    /* TESTING */
    ////////////

    /**
     * Main execution method used for testing problems.
     * @param args Arguments passed into execution.
     */
    public static void main(String[] args) {

        // create a queue
        QueueArray myQueue = new QueueArray(4);

        // add some elements into the queue
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);

        // pluck first element off of queue
        int value = myQueue.dequeue();

        myQueue.enqueue(5);

        // pluck some more off
        int value2 = myQueue.dequeue();
        int value3 = myQueue.dequeue();
        int value4 = myQueue.dequeue();

        // check out the last element
        // front and rear should be same (5)
        int value5 = myQueue.front();
        int value6 = myQueue.rear();
    }
}


class MyQueue<T> {

    private Stack<T> newestItemsOnTop = new Stack<>();
    private Stack<T> oldestItemsOnTop = new Stack<>();

    public void enqueue(T item) {
        newestItemsOnTop.push(item);
    }

    public void moveItems() {
        if (oldestItemsOnTop.isEmpty()) {
            while (!newestItemsOnTop.isEmpty()) {
                oldestItemsOnTop.push(newestItemsOnTop.pop());
            }
        }
    }

    public T dequeue() {
        moveItems();
        return oldestItemsOnTop.pop();
    }

    public T peek() {
        moveItems();
        return oldestItemsOnTop.peek();
    }
}

public class Solution {

    public static void main(String[] args) {

        // create a new queue using my implementation
        MyQueue<Integer> queue = new MyQueue<>();

        // create a reader to read the user input
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // read the number of queries the user wishes to make
        int numQueries;
        try {
            numQueries = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            return;
        }

        // read all queries the user makes
        for (int i = 0; i < numQueries; i++) {

            String line;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                return;
            }

            String[] values = line.split("\\s+");

            int choice = Integer.parseInt(values[0]);

            if (choice == 1) {
                int data = Integer.parseInt(values[1]);
                queue.enqueue(data);
            } else {
                if (choice == 2) {
                    queue.dequeue();
                } else {
                    System.out.println(queue.peek());
                }
            }
        }
    }
}
