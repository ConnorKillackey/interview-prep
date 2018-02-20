import java.util.HashMap;
import java.util.LinkedList;

/**
 * Defines the structure for node in a singly linked list.
 * Author: Robert Saunders
 */
class SinglyLinkedListNode {
    int value;
    SinglyLinkedListNode next;

    /**
     * Default constructor for a node in a singly linked list.
     * Defaults next to null and value to zero.
     */
    SinglyLinkedListNode() {
        this.value = 0;
        this.next = null;
    }

    /**
     * SinglyLinkedListNode constructor that takes a value.
     * Defaults next to be null.
     * @param value Value to be set as node value.
     */
    SinglyLinkedListNode(int value) {
        this.value = value;
        this.next = null;
    }

    /**
     * SinglyLinkedListNode constructor that
     * @param value The node value to be set.
     * @param next The next node to be set.
     */
    SinglyLinkedListNode(int value, SinglyLinkedListNode next) {
        this.value = value;
        this.next = next;
    }
}

/**
 * Implementation of a singly linked list.
 * Singly linked list only have one way traversal.
 * Author: Robert Saunders
 */
class SinglyLinkedList {


    SinglyLinkedListNode head = null; // pointer to the head of the list
    int size = 0; // counter to keep track of the size of the list

    /**
     * Constructor for linked list that sets initial head.
     * @param head The head node to be initially set.
     */
    SinglyLinkedList(SinglyLinkedListNode head) {
        this.head = head;
        this.size = 1;
    }

    /**
     * Checks if the list is empty.
     * @return True if empty.
     */
    public Boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Adds a node to the end of a linked list.
     * @param singlyLinkedListNodeToAdd The node to add to the list.
     */
    public void addNodeToTail(SinglyLinkedListNode singlyLinkedListNodeToAdd) {
        // first check if the list is empty
        // if so set the node to add as the head
        if (this.isEmpty()) {
            this.head = singlyLinkedListNodeToAdd;
            return;
        }

        // start at the head
        // traverse down the list until end
        SinglyLinkedListNode node = this.head;

        while (node.next != null) {
            node = node.next;
        }

        // set the new tail of the list
        node.next = singlyLinkedListNodeToAdd;
    }

    /**
     * Adds a node to the head of a linked list.
     * @param singlyLinkedListNodeToAdd The node to add to the list.
     */
    public void addNodeToHead(SinglyLinkedListNode singlyLinkedListNodeToAdd) {

        // check if the linked list is empty
        // set the head to be new node to add
        if (this.isEmpty()) {
            this.head = singlyLinkedListNodeToAdd;
            return;
        }

        // store the current head
        // set the new head
        // update the new heads next to be the old head
        SinglyLinkedListNode node = this.head;
        this.head = singlyLinkedListNodeToAdd;
        this.head.next = node;
    }

    /**
     * Inserts a node at the nth position in the linked list.
     * @param head The head of the linked list.
     * @param data The data to be added to the linked list.
     * @param position The position to insert the node at.
     * @return The head of the linked list.
     */
    public SinglyLinkedListNode InsertNth(SinglyLinkedListNode head, int data, int position) {

        SinglyLinkedListNode newNode = new SinglyLinkedListNode();
        newNode.value = data;
        newNode.next = head;

        if (head == null || position == 0) {
            return newNode;
        }

        SinglyLinkedListNode current = head;
        int currentPosition = 0;
        while(currentPosition != position-1) {
            current = current.next;
            currentPosition++;
        }

        SinglyLinkedListNode temp = current.next;
        current.next = newNode;
        newNode.next = temp;

        return head;
    }

    /**
     * Deletes a node in a linked list, only using the reference to the node to delete.
     * @param nodeToDelete The node to delete.
     */
    public void deleteNode(SinglyLinkedListNode nodeToDelete) {

        if (nodeToDelete == null || nodeToDelete.next == null) {
            return;
        }

        SinglyLinkedListNode nextNode = nodeToDelete.next;
        nodeToDelete.value = nextNode.value;
        nodeToDelete.next = nextNode.next;
    }

    /**
     * Deletes a node at a given position.
     * @param head The head of the linked list.
     * @param position The position to deleted the node from.
     * @return The head of the linked list.
     */
    public SinglyLinkedListNode deleteNth(SinglyLinkedListNode head, int position) {

        if (position == 0) {
            head = head.next;
            return head;
        }

        SinglyLinkedListNode current = head;
        int currentPosition = 0;

        while(currentPosition != position-1) {
            current = current.next;
            currentPosition++;
        }

        current.next = current.next.next;

        return head;
    }

    /**
     * Removes duplicates from a linked list, this method uses a buffer to keep track of values.
     * See below for alternative method that doesn't use a buffer.
     */
    public void removeDuplicatesWithBuffer() {

        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot remove duplicates from an empty list!");
        }

        HashMap<Integer, Boolean> buffer = new HashMap<>();
        SinglyLinkedListNode current = this.head;
        SinglyLinkedListNode prev = null;

        while (current != null) {
            if (buffer.containsKey(current.value)) {
                prev.next = current.next;
            }
            else {
                buffer.put(current.value, true);
                prev = current;
            }
            current = current.next;
        }
    }

    /**
     * Removes duplicates from a linked list, this method does not use a buffer.
     * Instead we use a runner to compare are nodes prior to current node.
     */
    public void removeDuplicatesWithoutBuffer() {

        if (isEmpty()) {
            throw new IllegalArgumentException("The list is empty so there can't be any duplicates!");
        }

        SinglyLinkedListNode prev = this.head;
        SinglyLinkedListNode current = prev.next;

        while (current != null) {

            SinglyLinkedListNode runner = head;

            while (runner != current) {
                if (runner.value == current.value) {
                    SinglyLinkedListNode tmp = current.next;
                    prev.next = tmp;
                    current = tmp;
                    break;
                }
                runner = runner.next;
            }

            if (runner == current) {
                prev = current;
                current = current.next;
            }
        }
    }

    /**
     * Reverses a linked list.
     */
    public void reverseList() {
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode current = this.head;
        SinglyLinkedListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        this.head = prev;
    }


    public SinglyLinkedListNode Reverse(SinglyLinkedListNode head) {

        SinglyLinkedListNode temp = null;
        SinglyLinkedListNode current = head;

        /* swap next and prev for all nodes of
         doubly linked list */
        /*
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        */
        /* Before changing head, check for the cases like empty
         list and list with only one node */
        /*
        if (temp != null) {
            head = temp.prev;
        }
        */
        return head;

    }

    int getNode(SinglyLinkedListNode head, int n) {

        SinglyLinkedListNode runner = head;
        SinglyLinkedListNode friend = head;

        for(int i = 0; i < n; i++) {
            runner = runner.next;
        }

        while(runner.next != null) {
            friend = friend.next;
            runner = runner.next;
        }

        return friend.value;
    }

    /**
     * Recursively prints a linked list in reverse.
     * @param head The head of the linked list.
     */
    public void reversePrintList(SinglyLinkedListNode head) {

        if (head == null) {
            return;
        }

        reversePrintList(head.next);
        System.out.println(head.value);
    }

    /**
     * Checks if a value is in the linked list.
     * @param value The value to search for.
     * @return True if the value is in the linked list.
     */
    public Boolean isValuePresent(int value) {

        if (this.isEmpty()) {
            return false;
        }

        SinglyLinkedListNode node = this.head;

        while (node.next != null) {
            if (node.value == value) {
                return true;
            }
            node = node.next;
        }

        return false;
    }

    /**
     * To string override for a linked list.
     * @return The string representation of a linked list.
     */
    @Override
    public String toString() {
        StringBuilder linkedListString = new StringBuilder();

        SinglyLinkedListNode node = this.head;

        while(node.next != null) {
            linkedListString.append(node.value + " -> ");
            node = node.next;
        }

        linkedListString.append(node.value);

        return linkedListString.toString();
    }

    //////////////
    /* TESTING */
    ////////////

    /**
     * Main execution method for testing.
     * @param args Arguments passed into testing.
     */
    public static void main(StringProblems[] args) {

        SinglyLinkedListNode firstSinglyLinkedListNode = new SinglyLinkedListNode(4);

        SinglyLinkedList myList = new SinglyLinkedList(firstSinglyLinkedListNode);

        SinglyLinkedListNode secondSinglyLinkedListNode = new SinglyLinkedListNode(3);

        myList.addNodeToTail(secondSinglyLinkedListNode);

        SinglyLinkedListNode newHeadNode = new SinglyLinkedListNode(1);

        myList.addNodeToHead(newHeadNode);

        System.out.println("Initial List: " + myList.toString());

        myList.reverseList();

        System.out.println("Reversed List: " + myList.toString());

        System.out.println("Is four in the list? " + myList.isValuePresent(4));
        System.out.println("Is two in the list? " + myList.isValuePresent(2));

        LinkedList<Integer> myNewList = new LinkedList<>();

        myNewList.add(1);
        myNewList.add(3);
        myNewList.add(4);

        System.out.println(myNewList.toString());
    }
}
