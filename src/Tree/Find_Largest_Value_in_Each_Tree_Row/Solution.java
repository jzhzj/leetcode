package Tree.Find_Largest_Value_in_Each_Tree_Row;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * You need to find the largest value in each row of a binary tree.
 *
 * Example:
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * Output: [1, 3, 9]
 * */
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<List<Integer>> levels = new LinkedList<>();
        traverse(root, 1, levels);
        List<Integer> result = new LinkedList<>();
        for (List<Integer> level : levels) {
            int max = Integer.MIN_VALUE;
            for (int i : level) {
                max = Math.max(max, i);
            }
            result.add(max);
        }
        return result;
    }

    private void traverse(TreeNode node, int depth, List<List<Integer>> levels) {
        if (node == null)
            return;
        if (levels.size() < depth)
            levels.add(new LinkedList<>());
        levels.get(depth - 1).add(node.val);
        traverse(node.left, depth + 1, levels);
        traverse(node.right, depth + 1, levels);
    }
}
