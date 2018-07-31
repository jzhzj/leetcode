package Union_Find.Number_of_Islands;


/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 */
public class Solution {
    int count;
    int[] id;
    int[][] distance = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        if (grid == null)
            return 0;
        int r = grid.length;
        if (r == 0)
            return 0;
        int c = grid[0].length;
        if (c == 0)
            return 0;
        id = new int[r * c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    id[i * c + j] = i * c + j;
                    count++;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    for (int[] d : distance) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < r && y >= 0 && y < c && grid[x][y] == '1') {
                            int id1 = i * c + j;
                            int id2 = x * c + y;
                            union(id2, id1);
                        }
                    }
                }
            }
        }
        return count();
    }

    private int find(int n) {
        int prev = id[n];
        if (prev != n)
            prev = find(prev);
        return prev;
    }

    private int count() {
        return count;
    }

    private void union(int n1, int n2) {
        int root1 = find(n1);
        int root2 = find(n2);
        if (root1 == root2)
            return;
        id[root1] = root2;
        count--;
    }
}
