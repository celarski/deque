import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {


    @Test
    public void testOffByZero() {
        CharacterComparator offByZero = new OffByN(0);
        assertTrue(offByZero.equalChars('a', 'a'));
        assertFalse(offByZero.equalChars('b', 'c'));
    }

    @Test
    public void testOffByFive() {
        CharacterComparator offByFive = new OffByN(5);
        assertTrue(offByFive.equalChars('a', 'f'));
        assertFalse(offByFive.equalChars('f', 'g'));
        assertFalse(offByFive.equalChars('a', 'a'));
    }
}
