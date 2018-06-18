package Tree.Binary_Tree_Level_Order_Traversal_II;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        int level = countLevels(root);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < level; i++) {
            result.add(new LinkedList<>());
        }
        traverse(root, result, level);
        return result;
    }

    private void traverse(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null)
            return;
        result.get(level - 1).add(node.val);
        traverse(node.left, result, level - 1);
        traverse(node.right, result, level - 1);
    }

    private int countLevels(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(countLevels(node.left), countLevels(node.right)) + 1;
    }
}
