package Depth_First_Search.Friend_Circle;


/**
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
 * <p>
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.
 * <p>
 * Example 1:
 * Input:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 * Example 2:
 * Input:
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 * so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 * Note:
 * N is in range [1,200].
 * M[i][i] = 1 for all students.
 * If M[i][j] = 1, then M[j][i] = 1.
 */

/*
 * Union Find
 */
public class Solution {
    private int count;
    private int[] id;

    public int findCircleNum(int[][] M) {
        count = M.length;
        id = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            id[i] = i;
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1)
                    union(i, j);
            }
        }
        return count();
    }

    private int count() {
        return count;
    }

    private int find(int n) {
        return id[n];
    }

    private void union(int n, int m) {
        int nID = find(n);
        int mID = find(m);
        if (nID == mID)
            return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == nID)
                id[i] = mID;
        }
        count--;
    }
}
