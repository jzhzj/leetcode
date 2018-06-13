package String.Rotated_Digits;

/**
 * X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.
 * <p>
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.
 * <p>
 * Now given a positive number N, how many numbers X from 1 to N are good?
 * <p>
 * Example:
 * Input: 10
 * Output: 4
 * Explanation:
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 * Note:
 * <p>
 * N  will be in range [1, 10000].
 */
public class Solution {
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 0; i <= N; i++) {
            if (isGood(i))
                count++;
        }
        return count;
    }

    private boolean isGood(int number) {
        String num = number + "";
        StringBuilder sb = new StringBuilder();
        String[] digits = num.split("");

        for (int i = 0; i < num.length(); i++) {
            if (digits[i].equals("3") || digits[i].equals("4") || digits[i].equals("7"))
                return false;
            switch (digits[i]) {
                case "2":
                    sb.append("5");
                    break;
                case "5":
                    sb.append("2");
                    break;
                case "6":
                    sb.append("9");
                    break;
                case "9":
                    sb.append("6");
                    break;
                default:
                    sb.append(digits[i]);
                    break;
            }
        }
        return Integer.parseInt(sb.toString()) != number;
    }
}
