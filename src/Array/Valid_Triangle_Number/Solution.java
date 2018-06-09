package Array.Valid_Triangle_Number;

import java.util.Arrays;

/**
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
 * Example 1:
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * Note:
 * The length of the given array won't exceed 1000.
 * The integers in the given array are in the range of [0, 1000].
 */
public class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int[] triplet = new int[2];
        int count = 0;
        if (nums.length < 3)
            return 0;
        for (int i = 0; i < nums.length - 2; i++) {
            triplet[0] = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                triplet[1] = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    if (triplet[0] + triplet[1] <= nums[k])
                        continue;
                    else
                        count++;

                }
            }
        }
        return count;
    }

}
