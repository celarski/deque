/** A class using CharacterComparator to check whether the letters are away from each other
 * in the alphabet by provided number (e.g. 'a' and 'f' are 5 places away from each other)
 */
public class OffByN implements CharacterComparator {
    private int letterDifference;

    /**
     * Constructor creating an object with difference between letters set to a particular number
     * @param n int, describes how many places characters are away from each other
     */
    public OffByN(int n) {
        letterDifference = n;
    }

    /**
     * {@inheritDoc}
     * @param x char, uppercase letter, lowercase letter  or symbol from the ASCII table
     * @param y char, uppercase letter, lowercase letter  or symbol from the ASCII table
     * @return true if characters x and y are equal by the rules of the implementing class, false otherwise
     */
    @Override
    public boolean equalChars(char x, char y) {
        return (Math.abs(x - y) == letterDifference);
    }
}
