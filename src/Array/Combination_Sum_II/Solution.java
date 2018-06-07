package Array.Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        getResult(candidates, result, new ArrayList<>(), 0, target);
        return result;
    }

    private void getResult(int[] candidates, List<List<Integer>> result, List<Integer> current, int start, int target) {
        if (target < 0)
            return;
        if (target == 0) {
            boolean flag = false;
            for (List list : result) {
                if (list.equals(current))
                    flag = true;
            }
            if (flag)
                return;
            else
                result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            current.add(candidates[i]);
            getResult(candidates, result, current, i + 1, target - candidates[i]);
            current.remove(current.size() - 1);
        }
    }
}
