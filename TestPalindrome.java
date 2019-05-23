import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {

    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();
    static CharacterComparator offByFive = new OffByN(5);

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("racecar"));
        assertFalse(palindrome.isPalindrome("lecture"));
    }

    @Test
    public void testEmptyStringIsPalindrome() {
        assertTrue(palindrome.isPalindrome(""));
    }

    @Test
    public void testOneCharacterIsPalindrome() {
        assertTrue(palindrome.isPalindrome("i"));
    }

    @Test
    public void testOffByOneIsPalindrome() {
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertFalse(palindrome.isPalindrome("lecture", offByOne));
    }

    @Test
    public void testOneCharacterOffByOneIsPalindrome() {
        assertTrue(palindrome.isPalindrome("i", offByOne));
    }

    @Test
    public void testEmptyStringOffByOneIsPalindrome() {
        assertTrue(palindrome.isPalindrome("", offByOne));
    }

    @Test
    public void testOffByFiveIsPalindrome() {
        assertFalse(palindrome.isPalindrome("car", offByFive));
        assertTrue(palindrome.isPalindrome("cdafih", offByFive));
    }
}
