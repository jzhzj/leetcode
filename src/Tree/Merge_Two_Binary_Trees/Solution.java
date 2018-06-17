package Tree.Merge_Two_Binary_Trees;

import Tree.TreeNode;

public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;
        int val1 = t1 == null ? 0 : t1.val;
        int val2 = t2 == null ? 0 : t2.val;

        TreeNode newRoot = new TreeNode(val1 + val2);
        newRoot.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        newRoot.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

        return newRoot;
    }
}
