/**
 * Defines the structure for node in a singly linked list.
 * Author: Robert Saunders
 */
public class SinglyLinkedListNode {
    public int value;
    public SinglyLinkedListNode next;

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
