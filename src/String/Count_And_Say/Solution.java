package String.Count_And_Say;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * Example 1:
 *
 * Input: 1
 * Output: "1"
 * Example 2:
 *
 * Input: 4
 * Output: "1211"
 * */
public class Solution {
    public String countAndSay(int n) {
        return countAndSay("1", n);
    }

    private String countAndSay(String str, int n) {
        if (n == 1)
            return str;
        char[] chars = str.toCharArray();
        int len = chars.length;
        StringBuilder sb = new StringBuilder();
        int cur = 1;
        char curChar = chars[0];
        if (len == 1) {
            sb.append(1);
            sb.append(chars[0]);
            return countAndSay(sb.toString(), n - 1);
        }
        for (int i = 1; i < len; i++) {
            if (chars[i] == curChar) {
                cur++;
                if (i == len - 1) {
                    sb.append(cur);
                    sb.append(curChar);
                }
            } else {
                sb.append(cur);
                sb.append(curChar);
                if (i < len - 1) {
                    curChar = chars[i];
                    cur = 1;
                } else {
                    sb.append(1);
                    sb.append(chars[i]);
                }
            }
        }
        return countAndSay(sb.toString(), n - 1);
    }
}
