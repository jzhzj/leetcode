package Depth_First_Search.All_Nodes_Distance_K_in_Binary_Tree;

import Tree.TreeNode;

import java.util.*;

/**
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 * <p>
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * <p>
 * Output: [7,4,1]
 * <p>
 * Explanation:
 * The nodes that are a distance 2 from the target node (with value 5)
 * have values 7, 4, and 1.
 * <p>
 * <p>
 * <p>
 * Note that the inputs "root" and "target" are actually TreeNodes.
 * The descriptions of the inputs above are just serializations of these objects.
 * <p>
 * <p>
 * Note:
 * <p>
 * The given tree is non-empty.
 * Each node in the tree has unique values 0 <= node.val <= 500.
 * The target node is a node in the tree.
 * 0 <= K <= 1000.
 */
class Solution {
    private Map<TreeNode, List<TreeNode>> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if (root == null || K < 0)
            return res;
        buildMap(root, null);
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        visited.add(target);
        queue.offer(target);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (K == 0) {
                for (TreeNode node : queue) {
                    res.add(node.val);
                }
                return res;
            }
            for (int i = 0; i < size; i++) {
                for (TreeNode node : map.get(queue.poll())) {
                    if (!visited.contains(node)) {
                        queue.offer(node);
                        visited.add(node);
                    }
                }
            }
            K--;
        }
        return res;
    }

    private void buildMap(TreeNode node, TreeNode parent) {
        if (node == null)
            return;
        if (!map.containsKey(node)) {
            map.put(node, new ArrayList<>());
            if (parent != null) {
                map.get(node).add(parent);
                map.get(parent).add(node);
            }
            buildMap(node.left, node);
            buildMap(node.right, node);
        }
    }
}
