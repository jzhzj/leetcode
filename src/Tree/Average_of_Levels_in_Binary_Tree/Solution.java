package Tree.Average_of_Levels_in_Binary_Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * Note:
 * The range of node's value is in the range of 32-bit signed integer.
 * */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<TreeNode> level = new LinkedList<>();
        level.add(root);
        List<Double> result = new LinkedList<>();
        result.add((double) root.val);
        while (true) {
            List<TreeNode> prevLevel = new LinkedList<>(level);
            level.clear();
            int size = prevLevel.size();
            for (int i = 0; i < size; i++) {
                TreeNode remove = ((LinkedList<TreeNode>) prevLevel).remove();
                if (remove.left != null)
                    level.add(remove.left);
                if (remove.right != null)
                    level.add(remove.right);
            }
            if (level.isEmpty())
                break;
            result.add(avg(level));
        }
        return result;
    }

    private double avg(List<TreeNode> level) {
        int size = level.size();
        long sum = 0;
        for (TreeNode node : level) {
            sum += node.val;
        }
        return (double) sum / size;
    }
}
