/** This interface defines a method for determining equality of characters. */
public interface CharacterComparator {
    /**
     * Checks whether the characters are equal by the rules of the implementing class.
     * @param x char, uppercase letter, lowercase letter  or symbol from the ASCII table
     * @param y char, uppercase letter, lowercase letter  or symbol from the ASCII table
     * @return true if characters are equal by the rules of the implementing class, false otherwise
     */
    boolean equalChars(char x, char y);
}
