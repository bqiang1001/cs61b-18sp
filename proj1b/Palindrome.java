public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> ans = new LinkedListDeque<Character>();
        int n = word.length();

        for (int i = 0; i < n; i++) {
            ans.addLast(word.charAt(i));
        }
        return ans;
    }

    public boolean isPalindrome(String word) {
        int lo = 0, hi = word.length() - 1;
        while (lo < hi && word.charAt(lo) == word.charAt(hi)) {
            lo++;
            hi--;
        }
        return lo >= hi;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        int lo = 0, hi = word.length() - 1;
        while (lo < hi && cc.equalChars(word.charAt(lo), word.charAt(hi))) {
            lo++;
            hi--;
        }
        return lo >= hi;
    }
}
