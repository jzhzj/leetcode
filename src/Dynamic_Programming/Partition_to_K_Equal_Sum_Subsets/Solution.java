package Dynamic_Programming.Partition_to_K_Equal_Sum_Subsets;

import java.util.Arrays;

/**
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 * <p>
 * Example 1:
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 * Note:
 * <p>
 * 1 <= k <= len(nums) <= 16.
 * 0 < nums[i] < 10000.
 */
public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0)
            return false;
        int target = sum / k;
        int index = nums.length - 1;
        while (index >= 0 && nums[index] == target) {
            index--;
            k--;
        }
        return search(new int[k], index, nums, target);
    }

    private boolean search(int[] groups, int index, int[] nums, int target) {
        if (index < 0)
            return true;
        int v = nums[index--];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                if (search(groups, index, nums, target))
                    return true;
                groups[i] -= v;
            }
            if (groups[i] == 0)
                break;
        }
        return false;
    }
}
