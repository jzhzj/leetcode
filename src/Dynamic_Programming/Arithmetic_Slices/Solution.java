package Dynamic_Programming.Arithmetic_Slices;

/**
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 * <p>
 * For example, these are arithmetic sequence:
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic.
 * <p>
 * 1, 1, 2, 5, 7
 * <p>
 * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 * <p>
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 * <p>
 * The function should return the number of arithmetic slices in the array A.
 * <p>
 * <p>
 * Example:
 * <p>
 * A = [1, 2, 3, 4]
 * <p>
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 */
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length == 3)
            return 1;
        int count = 0;
        for (int i = 0; i < A.length - 2; i++) {
            for (int j = i + 3; j < A.length + 1; j++) {
                if (isArithSlice(A, i, j))
                    count++;
            }
        }
        return count;
    }

    private boolean isArithSlice(int[] A, int start, int end) {
        int diff = A[start + 1] - A[start];

        for (int i = start + 2; i < end; i++) {
            if (A[i] - A[i - 1] != diff)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = {1, 2, 3, 8, 9, 10};
        System.out.println(s.numberOfArithmeticSlices(A));
    }
}
