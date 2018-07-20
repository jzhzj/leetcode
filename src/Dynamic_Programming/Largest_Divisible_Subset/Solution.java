package Dynamic_Programming.Largest_Divisible_Subset;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 * <p>
 * If there are multiple solutions, return any subset is fine.
 * <p>
 * Example 1:
 * <p>
 * nums: [1,2,3]
 * <p>
 * Result: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 * <p>
 * nums: [1,2,4,8]
 * <p>
 * Result: [1,2,4,8]
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);

        int dp[] = new int[nums.length]; //记录从0~i包括nums[i]的最大subset的size
        int pre[] = new int[nums.length];//记录到当前元素最大size的前一位数的下标
        int maxIdx = -1, max = -1;

        for (int i = 0; i < nums.length; i++) { //初始化
            dp[i] = 1;
            pre[i] = -1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;//
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {//找到最大的子集size 和它最后元素的下标
            if (dp[i] > max) {
                max = dp[i];
                maxIdx = i;
            }
        }

        for (int i = maxIdx; i >= 0;) { //回溯解集
            res.addFirst(nums[i]);
            i = pre[i];
        }
        return res;
    }
}
