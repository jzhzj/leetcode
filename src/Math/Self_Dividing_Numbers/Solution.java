package Math.Self_Dividing_Numbers;

import java.util.LinkedList;
import java.util.List;

/**
 * A self-dividing number is a number that is divisible by every digit it contains.
 * <p>
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * <p>
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * <p>
 * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 * <p>
 * Example 1:
 * Input:
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * Note:
 * <p>
 * The boundaries of each input argument are 1 <= left <= right <= 10000.
 */
public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (isSDN(i))
                result.add(i);
        }
        return result;
    }

    private boolean isSDN(int i) {
        String num = i + "";
        for (int j = 0; j < num.length(); j++) {
            int digit = Integer.parseInt(num.substring(j, j + 1));
            if (digit == 0 || i % digit != 0)
                return false;
        }
        return true;
    }
}
