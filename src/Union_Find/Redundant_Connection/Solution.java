package Union_Find.Redundant_Connection;

/**
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 * <p>
 * The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
 * <p>
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.
 * <p>
 * Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.
 * <p>
 * Example 1:
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given undirected graph will be like this:
 * 1
 * / \
 * 2 - 3
 * Example 2:
 * Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * Output: [1,4]
 * Explanation: The given undirected graph will be like this:
 * 5 - 1 - 2
 * |   |
 * 4 - 3
 * Note:
 * The size of the input 2D-array will be between 3 and 1000.
 * Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 */
public class Solution {
    int[] id;
    int[] res = new int[2];

    public int[] findRedundantConnection(int[][] edges) {
        id = new int[edges.length * edges[0].length];
        for (int i = 0, len = edges.length; i < len; i++) {
            id[edges[i][0]] = edges[i][0];
            id[edges[i][1]] = edges[i][1];
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        return res;
    }

    private int find(int node) {
        while (node != id[node]) {
            node = id[id[node]];
        }
        return node;
    }

    private void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            res[0] = p;
            res[1] = q;
            return;
        }
        id[pRoot] = qRoot;
    }
}
