import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("A"));
        assertFalse(palindrome.isPalindrome("Aa"));
        assertTrue(palindrome.isPalindrome("AbA"));
        assertTrue(palindrome.isPalindrome("AbbA"));

        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("AB", cc));
        assertTrue(palindrome.isPalindrome("A", cc));
        assertTrue(palindrome.isPalindrome("AbB", cc));
        assertTrue(palindrome.isPalindrome("", cc));
        assertFalse(palindrome.isPalindrome("AA", cc));
        assertFalse(palindrome.isPalindrome("AxA", cc));
    }
    }



    @Test
    public void testOffByN() {
        OffByN offBy5 = new OffByN(5);
        assertTrue(offBy5.equalChars('a', 'f'));  // true
        assertTrue(offBy5.equalChars('f', 'a'));  // true
        assertFalse(offBy5.equalChars('f', 'h'));  // false
    }
}
