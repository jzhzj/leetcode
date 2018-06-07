package Array.Find_All_Numbers_Disappeared_in_an_Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * <p>
 * Example:
 * <p>
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [5,6]
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        boolean[] flags = new boolean[len];

        for (int i = 0; i < len; i++) {
            flags[nums[i] - 1] = true;
        }
        List<Integer> list = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            if (!flags[i])
                list.add(i + 1);
        }
        return list;
    }
}
