package Tree.Convert_BST_to_Greater_Tree;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 *
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 * */
public class Solution {
    public TreeNode convertBST(TreeNode root) {
        List<Integer> values = new LinkedList<>();
        addToList(root, values);
        Integer[] arr = values.toArray(new Integer[0]);
        changVal(root, arr);
        return root;
    }

    private void addToList(TreeNode node, List<Integer> values) {
        if (node == null)
            return;
        values.add(node.val);
        addToList(node.left, values);
        addToList(node.right, values);
    }

    private void changVal(TreeNode node, Integer[] arr) {
        if (node == null)
            return;
        int val = node.val;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > val)
                node.val += arr[i];
        }
        changVal(node.left, arr);
        changVal(node.right, arr);
    }
}
