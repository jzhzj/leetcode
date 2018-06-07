package Array.Combination_Sum_III;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * <p>
 * Note:
 * <p>
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 * <p>
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        getResult(result, new ArrayList<>(), candidates, 0, n, k);
        return result;
    }

    private void getResult(List<List<Integer>> result, List<Integer> current, int[] candidates, int start, int target, int k) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            if (current.size() == k)
                result.add(new ArrayList<>(current));
            else
                return;
        }

        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            current.add(candidates[i]);
            getResult(result, current, candidates, i + 1, target - candidates[i], k);
            current.remove(current.size() - 1);
        }
    }
}
