package Array.Maximum_Length_of_Repeated_Subarray;

/**
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 * <p>
 * Example 1:
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation:
 * The repeated subarray with maximum length is [3, 2, 1].
 * Note:
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
public class Solution {
    public int findLength(int[] A, int[] B) {
        int a = A.length;
        int b = B.length;

        // Dynamic Programming
        // L[i][j] represent the max length of subarray that end at A[i] and B[j]
        int[][] L = new int[a][b];
        int max = 0;

        // Initiate L[i][j]
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                L[i][j] = A[i] == B[j] ? 1 : 0;
            }
        }

        // Get the result
        for (int i = 1; i < a; i++) {
            for (int j = 1; j < b; j++) {
                L[i][j] = A[i] == B[j] ? L[i - 1][j - 1] + 1 : 0;
                max = Math.max(max, L[i][j]);
            }
        }
        return max;
    }
}
