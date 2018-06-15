package String.Most_Common_Word;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 * <p>
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
 * <p>
 * Example:
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= paragraph.length <= 1000.
 * 1 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * Different words in paragraph are always separated by a space.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation symbols.
 */
public class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
            if (!words[i].matches("\\b[a-zA-Z]+\\b")) {
                int len = words[i].length();
                words[i] = words[i].substring(0, len - 1);
            }
        }

        int max = 0;
        String maxStr = null;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            Integer occurrence = map.get(word);
            if (occurrence == null) {
                map.put(word, 1);
                occurrence = 1;
            } else
                map.put(word, ++occurrence);
            boolean flag = true;
            for (String ban : banned) {
                if (word.equals(ban))
                    flag = false;
            }
            if (flag)
                if (occurrence > max) {
                    max = occurrence;
                    maxStr = word;
                }
        }
        return maxStr;
    }
}
