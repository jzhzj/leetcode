package Dynamic_Programming.Target_Sum;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * <p>
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 * <p>
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * Note:
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 */

/**
 * brute force
 * */
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return findAns(nums, 0, nums.length - 1, S);
    }

    private int findAns(int[] nums, int start, int end, int target) {
        if (end == start) {
            if (nums[start] == 0 && nums[start] == target)
                return 2;
            else if (nums[start] == Math.abs(target))
                return 1;
            else
                return 0;
        }

        int a = findAns(nums, start, end - 1, target - nums[end]);
        int b = findAns(nums, start, end - 1, target + nums[end]);
        return a + b;

    }
}
