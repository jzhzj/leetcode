package Array.Product_of_Array_Except_Self;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] output = new int[len];
        int left = 1;
        int right = 1;

        for (int i = 0; i < len; i++) {
            output[i] = left;
            left = left * nums[i];
        }

        for (int i = len - 1; i >= 0; i--) {
            output[i] = output[i] * right;
            right = right * nums[i];
        }
        return output;
    }
}
