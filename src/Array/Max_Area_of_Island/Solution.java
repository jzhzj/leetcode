package Array.Max_Area_of_Island;


/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 * <p>
 * Example 1:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ro = grid.length;
        int col = grid[0].length;
        int area = 0;
        int max = 0;


        for (int i = 0; i < ro; i++) {
            for (int j = 0; j < col; j++) {
                area = dfs(grid, ro, col, i, j, 0);
                max = Math.max(area, max);
            }
        }
        return max;
    }

    private int dfs(int[][] map, int r, int c, int i, int j, int c_area) {
        if (i < 0 || j < 0 || i >= r || j >= c || map[i][j] == 0)
            return c_area;
        map[i][j] = 0;
        c_area++;
        c_area = dfs(map, r, c, i + 1, j, c_area);
        c_area = dfs(map, r, c, i - 1, j, c_area);
        c_area = dfs(map, r, c, i, j + 1, c_area);
        c_area = dfs(map, r, c, i, j - 1, c_area);
        return c_area;
    }
}
