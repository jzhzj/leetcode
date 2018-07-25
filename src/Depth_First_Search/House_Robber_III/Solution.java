package Depth_First_Search.House_Robber_III;

import Tree.TreeNode;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 * Example 1:
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 * Credits:
 * Special thanks to @dietpepsi for adding this problem and creating all test cases.
 * */
public class Solution {
    public int rob(TreeNode root) {
        int[] res = traverse(root);
        return Math.max(res[0], res[1]);
    }

    private int[] traverse(TreeNode node) {
        if (node == null)
            return new int[2];
        int[] left = traverse(node.left);
        int[] right = traverse(node.right);
        int excl = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int incl = left[0] + right[0] + node.val;
        return new int[]{excl, incl};
    }
}
