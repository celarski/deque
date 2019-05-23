import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testLowercaseOffByOne() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertFalse(offByOne.equalChars('c', 'c'));
        assertFalse(offByOne.equalChars('z', 'a'));
    }

    @Test
    public void testUppercaseOffByOne() {
        assertTrue(offByOne.equalChars('A', 'B'));
        assertFalse(offByOne.equalChars('C', 'C'));
        assertFalse(offByOne.equalChars('Z', 'A'));
    }

}
