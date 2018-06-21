package Tree.Minimum_Depth_of_Binary_Tree;

import Tree.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 * */
public class Solution {
    int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        traverse(root, 1);
        return min;
    }

    private void traverse(TreeNode node, int depth) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            min = Math.min(min, depth);
        }
        traverse(node.left, depth + 1);
        traverse(node.right, depth + 1);
    }
}
