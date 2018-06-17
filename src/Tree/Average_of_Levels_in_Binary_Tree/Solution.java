package Tree.Average_of_Levels_in_Binary_Tree;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

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
