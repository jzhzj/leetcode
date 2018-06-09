package Dynamic_Programming.Palindromic_Substrings;


/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 * <p>
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 * <p>
 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * Note:
 * The input string length won't exceed 1000.
 */
public class Solution {
    public int countSubstrings(String s) {
        if (s == null)
            return 0;
        if (s.length() == 1)
            return 1;
        int count = s.length();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j < s.length() + 1; j++) {
                if (isPalindromic(s.substring(i, j)))
                    count++;
            }
        }
        return count;
    }

    private boolean isPalindromic(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length() / 2; i++) {
            if (chars[i] != chars[str.length() - 1 - i])
                return false;
        }
        return true;
    }
}
