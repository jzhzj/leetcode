package Dynamic_Programming.Counting_Bits;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * <p>
 * Follow up:
 * <p>
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
public class Solution {
    public int[] countBits(int num) {
        if (num == 0) {
            int A[] = {0};
            return A;
        }
        if (num == 1) {
            int A[] = {0, 1};
            return A;
        }

        int[] A = new int[num + 1];
        A[0] = 0;
        A[1] = 1;
        for (int i = 2; i < num + 1; i++) {
            if (i % 2 == 0)
                A[i] = A[i / 2];
            else
                A[i] = A[i / 2] + 1;
        }
        return A;
    }
}
