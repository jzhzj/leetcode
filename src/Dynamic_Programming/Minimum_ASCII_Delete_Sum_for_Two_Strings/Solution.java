package Dynamic_Programming.Minimum_ASCII_Delete_Sum_for_Two_Strings;

/**
 * Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.
 * <p>
 * Example 1:
 * Input: s1 = "sea", s2 = "eat"
 * Output: 231
 * Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
 * Deleting "t" from "eat" adds 116 to the sum.
 * At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
 * Example 2:
 * Input: s1 = "delete", s2 = "leet"
 * Output: 403
 * Explanation: Deleting "dee" from "delete" to turn the string into "let",
 * adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
 * At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
 * If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
 * Note:
 * <p>
 * 0 < s1.length, s2.length <= 1000.
 * All elements of each string will have an ASCII value in [97, 122].
 */
public class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[] str1 = s1.codePoints().toArray();
        int[] str2 = s2.codePoints().toArray();

        int[][] dp = new int[str1.length + 1][str2.length + 1];
        int sum = 0;

        for (int i = 0; i < str1.length; i++) {
            sum += str1[i];
            for (int j = 0; j < str2.length; j++) {
                if (str1[i] == str2[j])
                    dp[i + 1][j + 1] = dp[i][j] + str1[i];
                else
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        for (int i = 0; i < str2.length; i++) {
            sum += str2[i];
        }

        return sum - 2 * dp[str1.length][str2.length];
    }
}
