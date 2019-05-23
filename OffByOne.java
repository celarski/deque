/** A class using CharacterComparator to check whether the letters are away from each other
 * in the alphabet by one place (e.g. 'a' and 'b')
 */
public class OffByOne implements CharacterComparator {

    /**
     * {@inheritDoc}
     * @param x char, uppercase letter, lowercase letter  or symbol from the ASCII table
     * @param y char, uppercase letter, lowercase letter  or symbol from the ASCII table
     * @return true if characters x and y are equal by the rules of the implementing class, false otherwise
     */
    @Override
    public boolean equalChars(char x, char y) {
        return (Math.abs(x - y) == 1);
    }

}
