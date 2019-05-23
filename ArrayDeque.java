/**
 * A class representing an circular array implementation of double-ended queue.
 * If the front pointer is at position zero invoking addFirst() method loops the pointer
 * back around to the end of the array. Similarly if the end pointer is at the last position
 * invoking addLast() method loops the pointer to position zero. Starting length of the array is 8,
 * if calling addFirst() or addLast() method requires resizing the new length is set to double the previous one.
 * Usage ratio of the array (size/array.length) is calculated with every call to removeFirst()
 * and removeLast(), if it falls beneath 0.25 array is resized to half its current length.
 * @param <T> generic type of stored data
 */
public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst = 4;
    private int nextLast = 5;
    private static final int RFACTOR = 2;
    private static final int STARTING_SIZE = 8;

    /**
     * Constructor creating an empty ArrayDeque
     */
    public ArrayDeque() {
        items = (T[]) new Object[STARTING_SIZE];
        size = 0;
    }

    /**
     * Constructor creating an ArrayDeque with one element in it
     * @param x item of a generic type to be stored as the first element
     */
    public ArrayDeque(T x) {
        items = (T[]) new Object[STARTING_SIZE];
        items[nextFirst] = x;
        nextFirst = moveBackwards(nextFirst);
        size = 1;
    }

    /**
     * Moves a pointer one position to the left
     * @param thisFirst int, index of an array
     * @return int, index of an array one place to the left
     */
    private int moveBackwards(int thisFirst) {
        if (thisFirst - 1 < 0)
            thisFirst = items.length - 1;
        else
            thisFirst--;
        return thisFirst;
    }

    /**
     * Moves a pointer one position to the right
     * @param thisLast int, index of an array
     * @return int, index of an array one place to the right
     */
    private int moveForward(int thisLast) {
        if (thisLast + 1 > items.length - 1)
            thisLast = 0;
        else
            thisLast++;
        return thisLast;
    }

    /**
     * Checks whether adding next element to the array conceives a necessity of expanding the array
     * After the size of the array exceeds its length calls expandArray() function
     * @see #expandArray()
     */
    private void checkForExpand() {
        if (size + 1 > items.length)
            expandArray();
    }

    /**
     * Calculates the array usage ratio, if the ratio of elements stored in the array to its capacity
     * drops below 0.25 shrinks the array by resizing it to a half of its current length. Executes
     * only for arrays of length smaller than 16.
     * @see #shrinkArray()
     */
    private void checkForShrink() {
        double usageRatio = (double) size / items.length;
        if (items.length > 16 && usageRatio < 0.25)
            shrinkArray();
    }

    /**
     * Performs an operation of resizing the array by:
     * 1. creating a new array of a capacity equal to the size of the current array multiplied
     *    by a factor equal to RFACTOR
     * 2. calculating the starting index of a new array
     * 3. copying the part of the previous array from the first element to the end of array length
     * 4. copying the part of the previous array from the 0th index up to the last element
     * 5. reassigning the variable to the resized array
     * 6. updating the pointers for next first and last values to be inserted
     * @see #moveBackwards(int), #moveForward(int)
     */
    private void expandArray() {

        // create a new array and calculate a new starting index
        T[] newArray = (T[]) new Object[size * RFACTOR];
        int newStartingIndex = newArray.length / 4;
        int oldArrayLength = items.length;

        int indexFirstValue = moveForward(nextFirst);
        // copy the part from items[nextFirst + 1] to items.length
        System.arraycopy(items, indexFirstValue, newArray, newStartingIndex, oldArrayLength - indexFirstValue);
        // copy the part from items[0] to items[nextLast - 1]
        System.arraycopy(items, 0, newArray, newStartingIndex + (oldArrayLength - indexFirstValue), indexFirstValue);

        // update nextFirst and nextLast
        items = newArray;
        nextFirst = newStartingIndex - 1;
        nextLast = newStartingIndex + oldArrayLength;
    }

    /**
     * Performs an operation of shrinking an array by:
     * 1. creating a new array of a capacity equal to the length of the current array divided by 2
     * 2. calculating the starting index of a new array
     * 3. copying the shrank array into the new array
     * 4. reassigning the variable to the resized array
     * 5. updating the pointers for next first and last values to be inserted
     * @see #moveForward(int)
     */
    private void shrinkArray() {

        // create a new array and calculate a new starting index
        T[] newArray = (T[]) new Object[items.length / 2];
        int newStartingIndex = newArray.length / 4;

        System.arraycopy(items, moveForward(nextFirst), newArray, newStartingIndex, size);

        items = newArray;
        nextFirst = newStartingIndex - 1;
        nextLast = newStartingIndex + size;
    }

    /**
     * {@inheritDoc}
     * @param item an item of type T added to the front of the deque
     */
    @Override
    public void addFirst(T item) {
        checkForExpand();
        items[nextFirst] = item;
        size++;
        nextFirst = moveBackwards(nextFirst);
    }

    /**
     * {@inheritDoc}
     * @param item an item of type T added to the end of the deque
     */
    @Override
    public void addLast(T item) {
        checkForExpand();
        items[nextLast] = item;
        size++;
        nextLast = moveForward(nextLast);
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
        int follower = moveForward(nextFirst);
        while (follower != nextLast) {
            System.out.print(items[follower] + " ");
            if (follower + 1 > items.length - 1)
                follower = 0;
            else
                follower++;
        }
        System.out.println();
    }

    /**
     * {@inheritDoc}
     * @return removed element of a given generic type, null if no such item exists
     */
    @Override
    public T removeFirst() {
        // copy removed value into placeholder and free the space at removed index
        T valuePlaceholder = items[moveForward(nextFirst)];
        items[moveForward(nextFirst)] = null;

        // move nextFirst forward
        nextFirst = moveForward(nextFirst);
        size--;

        // check for shrinkArray
        checkForShrink();

        return valuePlaceholder;
    }

    /**
     * {@inheritDoc}
     * @return removed element of a given generic type, null if no such item exists
     */
    @Override
    public T removeLast() {
        // copy removed value into placeholder and free the space at removed index
        T valuePlaceholder = items[moveBackwards(nextLast)];
        items[moveBackwards(nextLast)] = null;

        // move nextFirst forward
        nextLast = moveBackwards(nextLast);
        size--;

        // check for shrinkArray
        checkForShrink();

        return valuePlaceholder;
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
        else if (moveForward(nextFirst) + index > items.length)
            return items[(index + moveForward(nextFirst)) % items.length];
        return items[moveForward(nextFirst) + index];
    }

    /**
     * Creates a deep copy of other
     * @param other object to be copied
     */
    public ArrayDeque(ArrayDeque other) {
        items = (T[]) new Object[other.size()];
        size = 0;

        for (int i = 0; i < other.size(); i++)
            addLast((T) other.get(i));
    }

}
