package Array.Subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (len > 0)
            getResult(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void getResult(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        if (start <= nums.length) {
            if (!result.contains(current))
                result.add(new ArrayList<>(current));
        }
        if (start > nums.length)
            return;

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            getResult(result, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
