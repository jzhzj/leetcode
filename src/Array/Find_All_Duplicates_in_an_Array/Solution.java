package Array.Find_All_Duplicates_in_an_Array;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 *
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [2,3]
 * */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len + 1];

        for (int i = 0; i < len; i++) {
            arr[nums[i]]++;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= len; i++) {
            if (arr[i] == 2)
                list.add(i);
        }
        return list;
    }
}
