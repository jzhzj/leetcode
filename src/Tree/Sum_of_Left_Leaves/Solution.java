package Tree.Sum_of_Left_Leaves;

import Tree.TreeNode;

/**
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 * */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;
        return sum(root);
    }

    private int sum(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;
        if (root.left == null)
            return sum(root.right);
        if (root.right == null)
            return sum(root.left) + (root.left.left == null && root.left.right == null ? root.left.val : 0);
        return sum(root.left) + (root.left.left == null && root.left.right == null ? root.left.val : 0) + sum(root.right);
    }
}
