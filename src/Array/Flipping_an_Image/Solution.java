package Array.Flipping_an_Image;

/**
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 * <p>
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * <p>
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 * Example 2:
 * <p>
 * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Notes:
 * <p>
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 */
public class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int len = A.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                swap(A[i], j, len - j - 1);
            }

        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                A[i][j] = A[i][j] ^ 1;
            }
        }
        return A;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
        int[][] map = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        map = s.flipAndInvertImage(map);
        for (int i = 0; i < map.length; i++) {
            for (Integer x: map[i]) {
                System.out.print(x + ", ");
            }
            System.out.print("       ");
        }
    }
}
