package Tree.Binary_Tree_Paths;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 * */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        traverse(root, "", result);
        return result;
    }

    private void traverse(TreeNode node, String path, List<String> result) {
        if (node == null)
            return;
        if (node.left == null && node.right == null)
            result.add(path + node.val);
        path = path + node.val + "->";
        traverse(node.left, path, result);
        traverse(node.right, path, result);
    }
}
