package Array.Unique_Paths;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * Example 1:
 * <p>
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 * <p>
 * Input: m = 7, n = 3
 * Output: 28
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1)
            return 1;
        if (n == 1)
            return 1;
        // a is the greater one of m and n;
        int a = m > n ? m : n;
        // b is the less one of m and n;
        int b = m > n ? n : m;

        return (int) (getFactorial(a + b - 2, a - 1) / getFactorial(b - 1));
    }

    private long getFactorial(int x) {
        long result = 1;
        for (int i = 0; i < x; i++) {
            result *= (i + 1);
        }
        return result;
    }

    private long getFactorial(int x, int y) {
        long result = 1;
        for (int i = x; i > y; i--) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePaths(36, 7));
    }
}
