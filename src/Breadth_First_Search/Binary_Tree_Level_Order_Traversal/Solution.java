package Breadth_First_Search.Binary_Tree_Level_Order_Traversal;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode lastNode = root;
        TreeNode nLastNode = root;
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                nLastNode = node.left;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nLastNode = node.right;
            }
            if (node == lastNode) {
                res.add(new ArrayList<>(list));
                list.clear();
                lastNode = nLastNode;
            }
        }
        return res;
    }
}
