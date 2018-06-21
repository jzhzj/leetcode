package Tree.Find_Mode_in_Binary_Search_Tree;

import Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * For example:
 * Given BST [1,null,2,2],
 *    1
 *     \
 *      2
 *     /
 *    2
 * return [2].
 *
 * Note: If a tree has more than one mode, you can return them in any order.
 *
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 * */
public class Solution {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        traverse(root, map);
        int size = map.size();
        int max = 0;
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        for (int i = 0; i < size; i++) {
            max = Math.max(max, map.get(keys[i]));
        }
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (map.get(keys[i]) == max)
                count++;
        }
        int[] res = new int[count];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (map.get(keys[i]) == max)
                res[index++] = keys[i];
        }
        return res;
    }

    private void traverse(TreeNode node, Map<Integer, Integer> map) {
        if (node == null)
            return;
        if (!map.containsKey(node.val))
            map.put(node.val, 1);
        else
            map.put(node.val, 1 + map.get(node.val));
        traverse(node.left, map);
        traverse(node.right, map);
    }
}
