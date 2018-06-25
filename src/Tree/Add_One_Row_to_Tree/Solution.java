package Tree.Add_One_Row_to_Tree;

import Tree.TreeNode;

public class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        addRow(root, v, d);
        return root;
    }

    private void addRow(TreeNode node, int v, int d) {
        if (node == null)
            return;
        if (d == 2) {
            TreeNode tmp = node.left;
            node.left = new TreeNode(v);
            node.left.left = tmp;

            tmp = node.right;
            node.right = new TreeNode(v);
            node.right.right = tmp;
            return;
        }
        addRow(node.left, v, d - 1);
        addRow(node.right, v, d - 1);
    }
}
