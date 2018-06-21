package Tree.Path_Sum_III;

import Tree.TreeNode;

/**
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 * */
public class Solution {
    int path = 0;

    public int pathSum(TreeNode root, int sum) {
        traverse(root, sum);
        return path;
    }

    private void traverse(TreeNode node, int sum) {
        if (node == null)
            return;
        path += findPath(node, sum, 0);
        traverse(node.left, sum);
        traverse(node.right, sum);
    }

    private int findPath(TreeNode node, int sum, int current) {
        if (node == null)
            return 0;
        current += node.val;
        if (current == sum)
            return 1 + findPath(node.left, sum, current) + findPath(node.right, sum, current);
        return findPath(node.left, sum, current) + findPath(node.right, sum, current);
    }
}
