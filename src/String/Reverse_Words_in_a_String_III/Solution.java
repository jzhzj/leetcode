package String.Reverse_Words_in_a_String_III;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int iMax = words.length;
        for (int i = 0; ; i++) {
            sb.append(reverse(words[i]));
            if (i == iMax - 1)
                return sb.toString();
            sb.append(" ");
        }
    }

    private String reverse(String s) {
        int len = s.length();
        char[] output = new char[len];
        char[] input = s.toCharArray();
        for (int i = 0; i < len; i++) {
            output[i] = input[len - 1 - i];
        }
        return new String(output);
    }
}
