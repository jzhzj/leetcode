package Tree.Balanced_Binary_Tree;

import Tree.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 * */
public class Solution {
    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        ckeckSubtree(root);
        return flag;
    }

    private int ckeckSubtree(TreeNode node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        int hightL = ckeckSubtree(node.left);
        int hightR = ckeckSubtree(node.right);
        if (Math.abs(hightL - hightR) > 1)
            flag = false;
        return Math.max(hightL, hightR) + 1;
    }
}
