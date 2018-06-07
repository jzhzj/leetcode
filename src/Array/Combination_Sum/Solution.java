package Array.Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        getResult(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    private void getResult(int[] candidates, int target, int start, List<List<Integer>> result, List<Integer> current) {
        if(target < 0)
            return;
        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = start; i < candidates.length && candidates[i] <= target; i++) {
            current.add(candidates[i]);
            getResult(candidates, target - candidates[i], i, result, current);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,3,6,7};
        System.out.println(s.combinationSum(nums, 7));
    }

}
