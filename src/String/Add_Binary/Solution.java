package String.Add_Binary;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int lenA = a.length();
        int lenB = b.length();
        int carry = 0;
        for (int i = 0; i < Math.max(lenA, lenB); i++) {
            int digitA = 0;
            int digitB = 0;
            if (lenA - i > 0) {
                digitA = Integer.parseInt(a.substring(lenA - 1 - i, lenA - i));
            }
            if (lenB - i > 0) {
                digitB = Integer.parseInt(b.substring(lenB - 1 - i, lenB - i));
            }
            switch (digitA + digitB + carry) {
                case 0:
                    sb.append(0);
                    break;
                case 1:
                    sb.append(1);
                    carry = 0;
                    break;
                case 2:
                    sb.append(0);
                    carry = 1;
                    break;
                case 3:
                    sb.append(1);
                    carry = 1;
                    break;
            }
        }
        if (carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}
