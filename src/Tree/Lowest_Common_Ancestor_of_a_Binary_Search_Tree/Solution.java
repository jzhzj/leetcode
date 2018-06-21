package Tree.Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *         _______6______
 *        /              \
 *     ___2__          ___8__
 *    /      \        /      \
 *    0      _4       7       9
 *          /  \
 *          3   5
 * Example 1:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself
 *              according to the LCA definition.
 * Note:
 *
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the BST.
 * */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        List<TreeNode> pathP = findPath(root, p.val, new LinkedList<>());
        List<TreeNode> pathQ = findPath(root, q.val, new LinkedList<>());
        int size = Math.min(pathP.size(), pathQ.size());
        TreeNode common = root;
        for (int i = 0; i < size; i++) {
            if (pathP.get(i).val != pathQ.get(i).val)
                break;
            common = pathP.get(i);
        }
        return common;
    }

    private List<TreeNode> findPath(TreeNode node, int target, List<TreeNode> path) {
        if (node == null)
            return null;
        path.add(node);
        if (node.val == target)
            return path;
        List<TreeNode> result = findPath(node.left, target, new LinkedList<>(path));
        if (result != null)
            return result;
        result = findPath(node.right, target, new LinkedList<>(path));
        return result;
    }
}
