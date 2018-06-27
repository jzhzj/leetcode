package Dynamic_Programming.Partition_Equal_Subset_Sum;

import java.util.Arrays;

/**
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * <p>
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * Example 1:
 * <p>
 * Input: [1, 5, 11, 5]
 * <p>
 * Output: true
 * <p>
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 * <p>
 * Input: [1, 2, 3, 5]
 * <p>
 * Output: false
 * <p>
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0)
            return false;
        return canPartition(nums, nums.length - 1, sum / 2, 0);
    }

    private boolean canPartition(int[] nums, int index, int target, int current) {
        if (index < 0)
            return false;
        if (current + nums[index] > target)
            return false;
        if (current + nums[index] == target)
            return true;
        else
            return canPartition(nums, index - 1, target, current + nums[index]) || canPartition(nums, index - 1, target, current);
    }
}
