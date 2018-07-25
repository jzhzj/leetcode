package Depth_First_Search.Binary_Tree_Right_Side_View;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * */
/*
 * 二叉树层序遍历 / BFS / Binary tree level-order traversal
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        traverse(queue, root, res);
        return res;
    }

    private void traverse(Queue<TreeNode> queue, TreeNode root, List<Integer> res) {
        TreeNode lastNode = root;
        TreeNode nLastNode = root;
        TreeNode cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
                nLastNode = cur.left;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                nLastNode = cur.right;
            }
            if (cur == lastNode) {
                lastNode = nLastNode;
                res.add(cur.val);
            }
        }
    }
}
