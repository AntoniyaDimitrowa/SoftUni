import java.util.LinkedList;
import java.util.NoSuchElementException;

public class DoublyLinkedList {

    class ListNode {
        int element;
        ListNode next;
        ListNode prev;

        public ListNode(int element) {
            this.element = element;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    //void addFirst(int element) – adds an element at the beginning of the collection
    public void addFirst(int element) {
        ListNode newNode = new ListNode(element);
        if(this.size == 0) {
            this.head = this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.size++;
    }

    //void addLast(int element) – adds an element at the end of the collection
    public void addLast(int element) {
        ListNode newNode = new ListNode(element);
        if(this.size == 0) {
            this.head = this.tail = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    //int get(int index) - Returns the element at the specified position in this list
    public int get(int index) {
        checkIndex(index);

        if(index <= this.size /2) {
            ListNode currNode = this.head;
            for (int i = 0; i < index; i++) {
                currNode = currNode.next;
            }
            return currNode.element;
        } else {
            ListNode currNode = this.tail;
            for (int i = this.size - 1; i > index; i--) {
                currNode = currNode.prev;
            }
            return currNode.element;
        }
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Index: %d is out of bounds for size %d", index, this.size));
        }
    }


    //int removeFirst() – removes the element at the beginning of the collection
    public int removeFirst() {
        checkEmpty();
        int firstElement = this.head.element;

        if(this.size == 1) {
            this.head = null;
            this.tail = null;
            this.size--;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        this.size--;
        return firstElement;
    }

    private void checkEmpty() {
        if(this.size == 0) {
            throw new NoSuchElementException("List is empty!")
        }
    }
    //int removeLast() – removes the element at the end of the collection
    public int removeLast() {
        checkEmpty();
        int element = this.tail.element;

        if(this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        this.size--;
        return element;
    }
    //void forEach() – goes through the collection and executes a given action
    public void forEach() {

    }
    //int[] toArray() – returns the collection as an array
    public int[] toArray() {

    }

}
