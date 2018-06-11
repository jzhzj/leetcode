package Dynamic_Programming.Count_Numbers_with_Unique_Digits;

/**
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * <p>
 * Example:
 * Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 * <p>
 * Credits:
 * Special thanks to @memoryless for adding this problem and creating all test cases.
 */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 10;
        int[] dp = new int[10];
        dp[0] = 1;
        dp[1] = 10;

        for (int i = 2; i < 10; i++) {
            int temp = 9;
            for (int j = 9; j > 10 - i; j--) {
                temp *= j;
            }
            dp[i] = dp[i - 1] + temp;
        }
        return n > 9 ? dp[9] : dp[n];
    }
}
