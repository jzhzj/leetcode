package Array.Merge_Sorted_Array;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {


        int[] buff = new int[m + n];

        int p1 = 0;
        int p2 = 0;

        if (n == 0)
            return;

        for (int i = 0; i < (m + n); i++) {
            if (p1 < m) {
                if (p2 < n) {
                    if (nums1[p1] < nums2[p2])
                        buff[i] = nums1[p1++];
                    else
                        buff[i] = nums2[p2++];
                } else {
                    buff[i] = nums1[p1++];
                }

            } else {
                buff[i] = nums2[p2++];
            }

        }
        for (int i = 0; i < (m + n); i++) {
            nums1[i] = buff[i];
        }
    }
}
