package Tree.Convert_Sorted_Array_to_Binary_Search_Tree;

import Tree.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        if (nums.length == 1)
            return new TreeNode(nums[0]);
        return arrange(nums, 0, nums.length - 1);
    }

    private TreeNode arrange(int[] nums, int lo, int hi) {
        if (hi == lo)
            return new TreeNode(nums[hi]);
        if (hi - lo == 1) {
            TreeNode node = new TreeNode(nums[hi]);
            node.left = new TreeNode(nums[lo]);
            return node;
        }
        TreeNode node = new TreeNode(nums[(lo + hi) / 2]);
        node.left = arrange(nums, lo, (lo + hi) / 2 - 1);
        node.right = arrange(nums, (lo + hi) / 2 + 1, hi);
        return node;
    }
}
