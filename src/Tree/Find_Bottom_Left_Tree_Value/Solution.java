package Tree.Find_Bottom_Left_Tree_Value;

import Tree.TreeNode;

/**
 * Given a binary tree, find the leftmost value in the last row of the tree.
 *
 * Example 1:
 * Input:
 *
 *     2
 *    / \
 *   1   3
 *
 * Output:
 * 1
 * Example 2:
 * Input:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * Output:
 * 7
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 * */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int depth = getDepth(root, 1);
        return getNode(root, depth).val;
    }

    private int getDepth(TreeNode node, int depth) {
        if (node == null)
            return --depth;
        return Math.max(getDepth(node.left, depth + 1),getDepth(node.right, depth + 1));
    }

    private TreeNode getNode(TreeNode node, int depth) {
        if (node == null)
            return null;
        if (depth == 1)
            return node;
        TreeNode left = getNode(node.left, depth - 1);
        TreeNode right = getNode(node.right, depth - 1);
        if (left == null && right == null)
            return null;
        return left == null ? right : left;
    }
}
