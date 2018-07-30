package Breadth_First_Search.Binary_Tree_Zigzag_Level_Order_Traversal;

import Tree.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode lastNode = root;
        TreeNode nLastNode = root;
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
                lastNode = nLastNode;
                list.clear();
            }
        }
        for (int i = 0, size = res.size(); i < size; i++) {
            if (i % 2 != 0)
                Collections.reverse(res.get(i));
        }
        return res;
    }
}
