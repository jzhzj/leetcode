package Tree.Longest_Univalue_Path;

import Tree.TreeNode;

/**
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 * Example 1:
 *
 * Input:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * Output:
 *
 * 2
 * Example 2:
 *
 * Input:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * Output:
 *
 * 2
 * Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 * */
public class Solution {
    int longest = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root != null)
            traverse(root);
        return longest;
    }

    private void traverse(TreeNode node) {
        if (node == null)
            return;
        longest = Math.max(longest, getLen(node.left, node.val, 0) + getLen(node.right, node.val, 0));
        traverse(node.left);
        traverse(node.right);
    }

    private int getLen(TreeNode node, int value, int len) {
        if (node == null)
            return len;
        if (node.val != value)
            return len;
        len++;
        return Math.max(getLen(node.left, value, len), getLen(node.right, value, len));
    }
}
