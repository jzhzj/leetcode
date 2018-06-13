package Dynamic_Programming.Delete_and_Earn;

import java.util.Arrays;

/**
 * Given an array nums of integers, you can perform operations on the array.
 * <p>
 * In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.
 * <p>
 * You start with 0 points. Return the maximum number of points you can earn by applying such operations.
 * <p>
 * Example 1:
 * Input: nums = [3, 4, 2]
 * Output: 6
 * Explanation:
 * Delete 4 to earn 4 points, consequently 3 is also deleted.
 * Then, delete 2 to earn 2 points. 6 total points are earned.
 * Example 2:
 * Input: nums = [2, 2, 3, 3, 3, 4]
 * Output: 9
 * Explanation:
 * Delete 3 to earn 3 points, deleting both 2's and the 4.
 * Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
 * 9 total points are earned.
 * Note:
 * <p>
 * The length of nums is at most 20000.
 * Each element nums[i] is an integer in the range [1, 10000].
 */
public class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        Arrays.sort(nums);
        for (int num : nums) {
            count[num]++;
        }

        int using = 0;
        int avoid = 0;
        int m = 0;
        int prev = -1;
        for (int i = 1; i < 10001; i++) {
            if (count[i] > 0) {
                m = Math.max(using, avoid);
                if (i - 1 != prev) {
                    using = i * count[i] + m;
                    avoid = m;
                } else {
                    using = i * count[i] + avoid;
                    avoid = m;
                }
                prev = i;
            }
        }
        return Math.max(using, avoid);
    }
}
