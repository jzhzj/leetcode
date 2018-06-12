package Dynamic_Programming.Is_Subsequence;

/**
 * Given a string s and a string t, check if s is subsequence of t.
 * <p>
 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * <p>
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * Return true.
 * <p>
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * Return false.
 * <p>
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (t.equals("") && !s.equals(""))
            return false;
        if (s.equals(""))
            return true;
        if (s.length() > t.length())
            return false;

        char[] sChar = s.toCharArray();
        int[] indices = new int[s.length()];

        indices[0] = t.indexOf(sChar[0]);
        if (indices[0] == -1)
            return false;

        for (int i = 1; i < sChar.length; i++) {
            indices[i] = t.indexOf(sChar[i], indices[i - 1] + 1);
            if (indices[i] < 0)
                return false;
        }
        return true;
    }
}
