package Tree.Binary_Tree_Preorder_Traversal;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,2,3]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        traverse(root, list);
        return list;
    }

    private void traverse(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        list.add(node.val);
        traverse(node.left, list);
        traverse(node.right, list);
    }
}
