package Breadth_First_Search.Find_Largest_Value_in_Each_Tree_Row;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        List<List<Integer>> levels = new ArrayList<>();
        TreeNode lastNode = root;
        TreeNode nlastNode = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            level.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                nlastNode = node.left;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nlastNode = node.right;
            }
            if (node == lastNode) {
                lastNode = nlastNode;
                levels.add(new ArrayList<>(level));
                level.clear();
            }
        }
        for (List<Integer> list : levels) {
            int max = Integer.MIN_VALUE;
            for (Integer i : list) {
                max = Math.max(max, i);
            }
            res.add(max);
        }
        return res;
    }
}