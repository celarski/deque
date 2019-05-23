/**
 * This interface defines methods for performing operations on an array
 * and linked list implementations of Double Ended Queue (Deque).
 * @param <T> Provided generic data type to store in the deque
 */
public interface Deque<T> {

    /**
     * Adds an item of type T to the front of the deque.
     * @param item an item of type T added to the front of the deque
     */
    void addFirst(T item);

    /**
     * Adds an item of type T to the back of the deque
     * @param item an item of type T added to the end of the deque
     */
    void addLast(T item);

    /**
     * Checks whether the deque is empty
     * @return true if deque is empty, false otherwise
     */
    default boolean isEmpty() {
        return (this.size() == 0);
    }

    /**
     * Returns the number of items in the deque
     * @return int >= 0; cached size of the deque stored in the instance variable "size"
     */
    int size();

    /**
     * Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, prints out a new line.
     */
    void printDeque();

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     * @return removed element of a given generic type, null if no such item exists
     */
    T removeFirst();

    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     * @return removed element of a given generic type, null if no such item exists
     */
    T removeLast();

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Uses iteration. Does not alter the deque
     * @param index int, a required index of the deque
     * @return element of a generic type found at the required index in the deque
     */
    T get(int index);
}
