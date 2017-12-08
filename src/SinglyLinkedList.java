import java.util.LinkedList;

/**
 * Implementation of a singly linked list.
 * Singly linked list only have one way traversal.
 * Author: Robert Saunders
 */
public class SinglyLinkedList {


    public SinglyLinkedListNode head = null; // pointer to the head of the list
    public int size = 0; // counter to keep track of the size of the list

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
        if (this.isEmpty()) { // first check if the list is empty
            this.head = singlyLinkedListNodeToAdd; // set the head to be the new node if is empty
            return;
        }
        SinglyLinkedListNode node = this.head; // start at the head
        while (node.next != null) { // traverse list until last node
            node = node.next;
        }
        node.next = singlyLinkedListNodeToAdd; // set the last node to be the new node
    }

    /**
     * Adds a node to the head of a linked list.
     * @param singlyLinkedListNodeToAdd The node to add to the list.
     */
    public void addNodeToHead(SinglyLinkedListNode singlyLinkedListNodeToAdd) {
        if (this.isEmpty()) { // first check if the list is empty
            this.head = singlyLinkedListNodeToAdd; // set the new node to be the head
            return;
        }

        SinglyLinkedListNode node = this.head; // store the current head

        this.head = singlyLinkedListNodeToAdd; // set the new head
        this.head.next = node; // update the new heads next to be the old head
    }

    /**
     * Reverses a linked list.
     */
    public void reverseList() {
        SinglyLinkedListNode prev = null; // create a pointer to prev node for reference
        SinglyLinkedListNode current = this.head; // set the current node to head
        SinglyLinkedListNode next = null; // create a point to next node for reference

        while (current != null) {
            next = current.next; // first update the next node
            current.next = prev; // make the current nodes next be the new previous, i.e. swap order
            prev = current; // update the previous
            current = next; // update the current
        }
        this.head = prev; // set head to be the prev
    }

    /**
     * Checks if a value is in the linked list.
     * @param value The value to search for.
     * @return True if the value is in the linked list.
     */
    public Boolean isValuePresent(int value) {
        if (this.isEmpty()) { // first check if the list is empty
            return false; // return false if it is empty
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

        while(node.next != null) { // go node by node appending them to the string until last one

            linkedListString.append(node.value + " -> ");

            node = node.next; // move to the next node
        }

        linkedListString.append(node.value); // add the last node to the string

        return linkedListString.toString();
    }

    /**
     * Main execution method for testing.
     * @param args Arguments passed into testing.
     */
    public static void main(String[] args) {

        SinglyLinkedListNode firstSinglyLinkedListNode = new SinglyLinkedListNode(4); // first create a node to start list

        SinglyLinkedList myList = new SinglyLinkedList(firstSinglyLinkedListNode);

        SinglyLinkedListNode secondSinglyLinkedListNode = new SinglyLinkedListNode(3); // create a second node to add to the list

        myList.addNodeToTail(secondSinglyLinkedListNode); // add the second node to the tail of this list

        SinglyLinkedListNode newHeadNode = new SinglyLinkedListNode(1);

        myList.addNodeToHead(newHeadNode);

        System.out.println("Initial List: " + myList.toString());

        myList.reverseList();

        System.out.println("Reversed List: " + myList.toString());

        System.out.println("Is four in the list? " + myList.isValuePresent(4));

        System.out.println("Is two in the list? " + myList.isValuePresent(2));


        LinkedList<Integer> myNewList = new LinkedList<>(); // create a linked list using the built in structure

        myNewList.add(1); // add some values into the linked list
        myNewList.add(3);
        myNewList.add(4);

        System.out.println(myNewList.toString()); // print the new linked list
    }
}
