package String.First_Unique_Character_in_a_String;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class Solution {
    public int firstUniqChar(String s) {
        int len = s.length();
        if (len == 0)
            return -1;
        if (len == 1)
            return 0;
        int[] alphabet = new int[26];
        for (char c : s.toCharArray()) {
            alphabet[c - 'a']++;
        }

        int minIndex = len;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == 1)
                minIndex = Math.min(minIndex, s.indexOf(i + 'a'));
        }
        return minIndex == len ? -1 : minIndex;
    }
}
