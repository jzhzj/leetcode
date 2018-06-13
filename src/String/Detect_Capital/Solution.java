package String.Detect_Capital;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * <p>
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * <p>
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * Example 1:
 * Input: "USA"
 * Output: True
 * Example 2:
 * Input: "FlaG"
 * Output: False
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
public class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1)
            return true;
        boolean[] result = checkEachLetter(word);
        if (result[0]) {
            if (result[1]) {
                for (int i = 2; i < result.length; i++) {
                    if (!result[i])
                        return false;
                }
                return true;
            } else {
                for (int i = 2; i < result.length; i++) {
                    if (result[i])
                        return false;
                }
                return true;
            }
        } else {
            for (int i = 1; i < result.length; i++) {
                if (result[i])
                    return false;
            }
            return true;
        }
    }

    private boolean[] checkEachLetter(String word) {
        char[] chars = word.toCharArray();
        int len = chars.length;
        boolean[] result = new boolean[len];
        for (int i = 0; i < len; i++) {
            result[i] = chars[i] < 97;
        }
        return result;
    }
}
