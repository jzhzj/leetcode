package Tree.Most_Frequent_Subtree_Sum;

import Tree.TreeNode;

import java.util.*;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 *
 * Examples 1
 * Input:
 *
 *   5
 *  /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 *
 *   5
 *  /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 * */
public class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        getSum(root, map);
        List<Integer> list = new LinkedList<>();
        int max = 0;
        Set<Integer> keys = map.keySet();
        for (int i : keys) {
            max = Math.max(max, map.get(i));
        }
        for (int i : keys) {
            if (map.get(i) == max)
                list.add(i);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public int getSum(TreeNode node, Map<Integer, Integer> map) {
        if (node == null)
            return 0;
        int left = getSum(node.left, map);
        int right = getSum(node.right, map);
        int sum = left + right + node.val;
        if (!map.containsKey(sum)) {
            map.put(sum, 1);
        } else {
            map.put(sum, map.get(sum) + 1);
        }
        return sum;
    }
}
