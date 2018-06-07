package Array.Move_Zeroes;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int[] newNums = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                newNums[index++] = nums[i];
        }
        for (; index < nums.length; index++) {
            newNums[index] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }
    }
}
