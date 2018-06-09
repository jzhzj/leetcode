package Dynamic_Programming.Maximum_Subarray;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int M[] = new int[nums.length];

        M[0] = nums[0];
        int max = M[0];

        for (int i = 1; i < nums.length; i++) {
            M[i] = Math.max(nums[i], M[i - 1] + nums[i]);
            max = M[i] > max ? M[i] : max;
        }
        return max;
    }
}
