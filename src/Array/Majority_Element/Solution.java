package Array.Majority_Element;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            Integer v = map.get(nums[i]);
            if (v == null)
                v = 0;
            v++;
            map.put(nums[i], v);
        }

        Set<Integer> keys = map.keySet();
        int max = 0;
        int num = 0;
        for (Integer k : keys) {
            if (map.get(k) > max)
                num = k;
            max = Math.max(max, map.get(k));
        }
        return num;
    }
}
