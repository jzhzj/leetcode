package String.Complex_Number_Multiplication;

/**
 * Given two strings representing two complex numbers.
 * <p>
 * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
 * <p>
 * Example 1:
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * Example 2:
 * Input: "1+-1i", "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 * Note:
 * <p>
 * The input strings will not have extra blank.
 * The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.
 */
public class Solution {
    public String complexNumberMultiply(String a, String b) {
        String tempA = a.substring(0, a.length() - 1);
        String tempB = b.substring(0, b.length() - 1);
        String[] coefStrA = tempA.split("\\+");
        String[] coefStrB = tempB.split("\\+");
        int[] coefA = {Integer.parseInt(coefStrA[0]), Integer.parseInt(coefStrA[1])};
        int[] coefB = {Integer.parseInt(coefStrB[0]), Integer.parseInt(coefStrB[1])};
        int[] coeffients = {coefA[0] * coefB[0], coefA[1] * coefB[1], coefA[0] * coefB[1] + coefB[0] * coefA[1]};
        return (coeffients[0] - coeffients[1]) + "+" + coeffients[2] + "i";
    }
}
