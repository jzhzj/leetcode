package Dynamic_Programming.Guess_Number_Higher_or_Lower_II;

/**
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * <p>
 * However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
 * <p>
 * Example:
 * <p>
 * n = 10, I pick 8.
 * <p>
 * First round:  You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 * <p>
 * Game over. 8 is the number I picked.
 * <p>
 * You end up paying $5 + $7 + $9 = $21.
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 */
public class Solution {
    public int getMoneyAmount(int n) {
        int[][] matrix = new int[n + 1][n + 1];
        return pay(matrix, 1, n);
    }

    public int pay(int[][] dp, int lo, int hi) {
        if (lo >= hi) {
            return 0;
        }
        if (dp[lo][hi] != 0) {
            return dp[lo][hi];
        }
        int ans = Integer.MAX_VALUE;
        for (int m = lo; m <= hi; m++) {
            int test = m + Math.max(pay(dp, lo, m - 1), pay(dp, m + 1, hi));
            if (test < ans) {
                ans = test;
            }
        }
        dp[lo][hi] = ans;
        return ans;
    }
}


