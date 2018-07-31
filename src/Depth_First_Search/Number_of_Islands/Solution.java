package Depth_First_Search.Number_of_Islands;

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
    int r;
    int c;

    public int numIslands(char[][] grid) {
        r = grid.length;
        if (r == 0)
            return 0;
        c = grid[0].length;
        if (c == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                dfs(grid, i, j);
                count++;
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i >= 0 && j >= 0 && i < r && j < c && grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }
}
