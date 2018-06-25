package Tree.Print_Binary_Tree;

import Tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Print a binary tree in an m*n 2D string array following these rules:
 *
 * The row number m should be equal to the height of the given binary tree.
 * The column number n should always be an odd number.
 * The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
 * Each unused space should contain an empty string "".
 * Print the subtrees following the same rules.
 * Example 1:
 * Input:
 *      1
 *     /
 *    2
 * Output:
 * [["", "1", ""],
 *  ["2", "", ""]]
 * Example 2:
 * Input:
 *      1
 *     / \
 *    2   3
 *     \
 *      4
 * Output:
 * [["", "", "", "1", "", "", ""],
 *  ["", "2", "", "", "", "3", ""],
 *  ["", "", "4", "", "", "", ""]]
 * Example 3:
 * Input:
 *       1
 *      / \
 *     2   5
 *    /
 *   3
 *  /
 * 4
 * Output:
 *
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 *  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 *  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 *  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 * Note: The height of binary tree is in the range of [1, 10].
 * */
public class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        String[][] res = new String[height][(1 << height) - 1];
        for (String[] row : res) {
            Arrays.fill(row, "");
        }
        fill(res, root, 0, res[0].length, 0);
        List<List<String>> ans = new LinkedList<>();
        for (String[] row : res) {
            ans.add(Arrays.asList(row));
        }
        return ans;
    }

    private void fill(String[][] res, TreeNode node, int l, int r, int height) {
        if (node == null)
            return;
        res[height][(l + r) / 2] = node.val + "";
        fill(res, node.left, l, (l + r) / 2, height + 1);
        fill(res, node.right, (l + r) / 2 + 1, r, height + 1);
    }

    private int getHeight(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(getHeight(node.right), getHeight(node.left));
    }
}
