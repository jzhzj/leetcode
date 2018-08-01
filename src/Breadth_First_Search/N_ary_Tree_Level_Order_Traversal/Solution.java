package Breadth_First_Search.N_ary_Tree_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Node lastNode = root;
        Node nlastNode = root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> line = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            line.add(node.val);
            for (Node child : node.children) {
                queue.offer(child);
                nlastNode = child;
            }

            if (node == lastNode) {
                res.add(new ArrayList<>(line));
                line.clear();
                lastNode = nlastNode;
            }
        }
        return res;
    }
}
