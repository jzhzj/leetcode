package String.Reverse_Vowels_of_a_String;

import java.util.Stack;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p>
 * Example 1:
 * Given s = "hello", return "holle".
 * <p>
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * <p>
 * Note:
 * The vowels does not include the letter "y".
 */
public class Solution {
    public String reverseVowels(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i, i + 1);
            if (c.equalsIgnoreCase("a") || c.equalsIgnoreCase("e") ||
                    c.equalsIgnoreCase("i") || c.equalsIgnoreCase("o") ||
                    c.equalsIgnoreCase("u")) {
                stack.push(c.charAt(0));
            }
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char v = chars[i];
            switch (v) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    chars[i] = stack.pop();
                    break;
                default:
            }
        }
        return new String(chars);
    }
}
