package Array.Beautiful_Arrangement_II;

/**
 * Given two integers n and k, you need to construct a list which contains n different positive integers ranging from 1 to n and obeys the following requirement:
 * Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
 * <p>
 * If there are multiple answers, print any of them.
 * <p>
 * Example 1:
 * Input: n = 3, k = 1
 * Output: [1, 2, 3]
 * Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3, and the [1, 1] has exactly 1 distinct integer: 1.
 * Example 2:
 * Input: n = 3, k = 2
 * Output: [1, 3, 2]
 * Explanation: The [1, 3, 2] has three different positive integers ranging from 1 to 3, and the [2, 1] has exactly 2 distinct integers: 1 and 2.
 * Note:
 * The n and k are in the range 1 <= k < n <= 104.
 */
public class Solution {
    public int[] constructArray(int n, int k) {
        int dif = k;
        int[] arr = new int[n];
        arr[0] = 1;
        boolean[] flag = new boolean[n + 1];
        flag[1] = true;
        int i;
        for (i = 1; i < n; i++) {
            int temp1 = arr[i - 1] + dif;
            int temp2 = arr[i - 1] - dif;
            int temp = 0;

            if (temp2 > 0 && !flag[temp2]) {
                temp = temp2;
                flag[temp2] = true;
            } else {
                temp = temp1;
                flag[temp1] = true;
            }
            arr[i] = temp;
            dif--;
            if (dif == 0)
                break;
        }
        i++;
        for (; i < n; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (!flag[j]) {
                    arr[i] = j;
                    flag[j] = true;
                    break;
                }
            }
        }
        return arr;
    }
}
