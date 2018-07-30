package Depth_First_Search.Increasing_Subsequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        helper(res, nums, new ArrayList<>(), 0);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums, List<Integer> current, int startIndex) {
        if (current.size() > 1)
            res.add(new ArrayList<>(current));
        Set<Integer> used = new HashSet<>();
        for (int i = startIndex, len = nums.length; i < len; i++) {
            if (used.contains(nums[i]))
                continue;
            if (current.size() == 0 || nums[i] >= current.get(current.size() - 1)) {
                current.add(nums[i]);
                used.add(nums[i]);
                helper(res, nums, current, i + 1);
                current.remove(current.size() - 1);
            }
        }
    }
}
