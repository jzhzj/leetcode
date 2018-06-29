package String.Repeated_Substring_Pattern;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * Example 1:
 * Input: "abab"
 * <p>
 * Output: True
 * <p>
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 * Input: "aba"
 * <p>
 * Output: False
 * Example 3:
 * Input: "abcabcabcabc"
 * <p>
 * Output: True
 * <p>
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            String pattern = s.substring(0, i);
            if (isRepeated(s, pattern))
                return true;
        }
        return false;
    }

    private boolean isRepeated(String s, String pattern) {
        int step = pattern.length();
        if (s.length() % step != 0)
            return false;
        String substring = s;
        for (int i = 1; i < s.length() / step; i++) {
            substring = substring.substring(step, substring.length());
            if (!substring.startsWith(pattern))
                return false;
        }
        return true;
    }
}
