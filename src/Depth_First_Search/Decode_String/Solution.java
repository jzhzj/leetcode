package Depth_First_Search.Decode_String;

import java.util.Stack;

/**
 * Given an encoded string, return it's decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * <p>
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * <p>
 * Examples:
 * <p>
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = s.length(); i < len; i++) {
            char c = s.charAt(i);
            if (c == ']') {
                while (stack.peek() != '[')
                    sb.append(stack.pop());
                String word = sb.toString();
                sb.setLength(0);
                stack.pop();
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9')
                    sb.append(stack.pop());
                pushToStack(stack, word, Integer.parseInt(sb.reverse().toString()));
                sb.setLength(0);
            } else
                stack.push(c);
        }
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    private void pushToStack(Stack<Character> stack, String word, int coefficient) {
        for (int i = 0; i < coefficient; i++) {
            for (int j = word.length() - 1; j >= 0; j--) {
                stack.push(word.charAt(j));
            }
        }
    }
}
