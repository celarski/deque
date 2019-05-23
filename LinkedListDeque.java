/**
 * A class representing an implementation of double-ended queue (deque).
 * Uses a circular sentinel node tracking the first and the last element
 * of the data structure.
 * @param <T> generic type of stored data
 */
public class LinkedListDeque<T> implements Deque<T> {

    /** A class representing a single node in the deque data structure */
    private class Node {
        Node previous;
        T item;
        Node next;

        private Node(Node p, T i, Node n) {
            previous = p;
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    /**
     * Constructor creating an empty LinkedListDeque with only a circular sentinel node pointing at itself
     */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.previous = sentinel;
        size = 0;
    }

    /**
     * Constructor creating a LinkedListDeque with one element in it that sentinel.next
     * and sentinel.previous point at
     * @param item item of a generic type to be stored as the first element
     */
    public LinkedListDeque(T item) {
        sentinel = new Node(null, null, null);
        sentinel.next = new Node(sentinel, item, sentinel);
        sentinel.previous = sentinel.next;
        size = 1;
    }

    /**
     * {@inheritDoc}
     * @param item an item of type T added to the front of the deque
     */
    @Override
    public void addFirst(T item) {
        // if the list is empty
        if (size == 0) {
            sentinel.next = new Node(sentinel, item, sentinel);
            sentinel.previous = sentinel.next;
            size++;
        } else {
            // if the list has at least one element in it
            Node temp = sentinel.next;
            sentinel.next = new Node(sentinel, item, temp);
            temp.previous = sentinel.next;
            size++;
        }
    }

    /**
     * {@inheritDoc}
     * @param item an item of type T added to the end of the deque
     */
    @Override
    public void addLast(T item) {
        if (size == 0) {
            sentinel.next = new Node(sentinel, item, sentinel);
            sentinel.previous = sentinel.next;
            size++;
        } else {
            Node temp = sentinel.previous;
            sentinel.previous = new Node(temp, item, sentinel);
            temp.next = sentinel.previous;
            size++;
        }
    }

    /**
     * {@inheritDoc}
     * @return int, cached size of the deque stored in the instance variable "size"
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printDeque() {
        Node p = sentinel.next;
        while (p.next != sentinel) {
            System.out.print(p.item + ", ");
            p = p.next;
        }
        System.out.print(p.item);
        System.out.println();
    }

    /**
     * {@inheritDoc}
     * @return removed element of a given generic type, null if no such item exists
     */
    @Override
    public T removeFirst() {
        if (size == 0)
            return null;
        else if (size == 1) {
            Node temp = sentinel.next;
            sentinel. next = sentinel;
            sentinel.previous = sentinel;
            size = 0;
            return temp.item;
        } else {
            Node temp = sentinel.next;
            sentinel.next = temp.next;
            size--;
            return temp.item;
        }
    }

    /**
     * {@inheritDoc}
     * @return removed element of a given generic type, null if no such item exists
     */
    @Override
    public T removeLast() {
        if (size == 0)
            return null;
        else if (size == 1) {
            Node temp = sentinel.next;
            sentinel. next = null;
            sentinel.previous = null;
            size = 0;
            return temp.item;
        } else {
            Node temp = sentinel.previous;
            temp.previous.next = sentinel;
            sentinel.previous = temp.previous;
            size--;
            return temp.item;
        }
    }

    /**
     * {@inheritDoc}
     * @param index int, a required index of the deque
     * @return element of a generic type found at the required index in the deque
     */
    @Override
    public T get(int index) {
        if (size == 0 || index > size - 1)
            return null;
        int start = 0;
        Node p = sentinel.next;
        while (start != index) {
            p = p.next;
            start++;
        }
        return p.item;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Uses recursion. Does not alter the deque
     * @param index int, a required index of the deque
     * @return element of a generic type found at the required index in the deque
     */
    public T getRecursive(int index) {
        return recursiveHelper(sentinel.next, index);
    }

    /**
     * Recursively traverses each node of the LinkedListDeque to find particular value
     * @param n Node, starting node
     * @param index int, starting index
     * @return element of a generic type found at the required index in the deque
     */
    private T recursiveHelper(Node n, int index) {
        if (size == 0 || index > size + 1)
            return null;
        else if (index == 0)
            return n.item;
        else
            return recursiveHelper(n.next, index -1);
    }

    /**
     * Creates a deep copy of other
     * @param other object to be copied
     */
    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.previous = sentinel;
        size = 0;

        for (int i = 0; i < other.size(); i++) {
            addLast((T) other.get(i));
        }
    }
}
