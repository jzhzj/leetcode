package String.Reverse_String;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example:
 * Given s = "hello", return "olleh".
 */
public class Solution {
    public String reverseString(String s) {
        int len = s.length();
        char[] output = new char[len];
        char[] input = s.toCharArray();
        for (int i = 0; i < len; i++) {
            output[i] = input[len - 1 - i];
        }
        return new String(output);
    }
}
