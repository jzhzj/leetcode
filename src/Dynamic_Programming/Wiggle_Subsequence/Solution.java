package Dynamic_Programming.Wiggle_Subsequence;


/**
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.
 * <p>
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.
 * <p>
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.
 * <p>
 * Examples:
 * Input: [1,7,4,9,2,5]
 * Output: 6
 * The entire sequence is a wiggle sequence.
 * <p>
 * Input: [1,17,5,10,13,15,10,5,16,8]
 * Output: 7
 * There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
 * <p>
 * Input: [1,2,3,4,5,6,7,8,9]
 * Output: 2
 * Follow up:
 * Can you do it in O(n) time?
 * <p>
 * Credits:
 * Special thanks to @agave and @StefanPochmann for adding this problem and creating all test cases.
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int[][] dp = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = 0;
        }
        int iMax = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j][1] <= 0) {
                    if (dp[j][0] + 1 > dp[i][0]) {
                        dp[i][0] = Math.max(dp[j][0] + 1, dp[i][0]);
                        dp[i][1] = 1;
                    }
                } else if (nums[i] < nums[j] && dp[j][1] >= 0) {
                    if (dp[j][0] + 1 > dp[i][0]) {
                        dp[i][0] = Math.max(dp[j][0] + 1, dp[i][0]);
                        dp[i][1] = -1;
                    }
                }
            }
            iMax = Math.max(iMax, dp[i][0]);
        }
        return iMax;
    }
}
