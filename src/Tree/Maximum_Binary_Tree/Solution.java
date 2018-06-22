package Tree.Maximum_Binary_Tree;

import Tree.TreeNode;

/**
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 *
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 *
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 * Note:
 * The size of the given array will be in the range [1,1000].
 * */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0)
            return null;
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int lo, int hi) {
        TreeNode node;
        if (hi < lo)
            return null;
        int iMax = lo;
        for (int i = lo; i <= hi; i++) {
            iMax = nums[i] > nums[iMax] ? i : iMax;
        }
        node = new TreeNode(nums[iMax]);
        node.left = construct(nums, lo, iMax - 1);
        node.right = construct(nums, iMax + 1, hi);
        return node;
    }
}
