package Dynamic_Programming.Integer_Break;

/**
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 * <p>
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * <p>
 * Note: You may assume that n is not less than 2 and not larger than 58.
 */
public class Solution {
    public int integerBreak(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        if (n == 4)
            return 4;
        if (n == 5)
            return 6;

        int q = n / 3;
        switch (n % 3) {
            case 0:
                return (int) (Math.pow(3, q));
            case 1:
                return (int) (Math.pow(3, q - 1)) * 4;
            case 2:
                return (int) (Math.pow(3, q - 1)) * 6;
        }
        return -1;
    }
}
