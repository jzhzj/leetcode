package String.Goat_Latin;

/**
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 * <p>
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 * <p>
 * The rules of Goat Latin are as follows:
 * <p>
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 * <p>
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 * <p>
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * Return the final sentence representing the conversion from S to Goat Latin.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * Example 2:
 * <p>
 * Input: "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 * <p>
 * <p>
 * Notes:
 * <p>
 * S contains only uppercase, lowercase and spaces. Exactly one space between each word.
 * 1 <= S.length <= 150.
 */
public class Solution {
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        StringBuilder sb = new StringBuilder();
        int iMax = words.length;

        for (int i = 0; ; i++) {
            sb.append(transform(words[i], i + 1));
            if (i == iMax - 1)
                return sb.toString();
            sb.append(" ");
        }
    }

    private String transform(String word, int index) {
        String lowerWord = word.toLowerCase();
        StringBuilder sb = new StringBuilder();
        if (lowerWord.startsWith("a") || lowerWord.startsWith("e") || lowerWord.startsWith("i") ||
                lowerWord.startsWith("o") || lowerWord.startsWith("u")) {
            sb.append(word);
        } else {
            int len = word.length();
            sb.append(word.substring(1, len));
            sb.append(word.substring(0, 1));
        }
        sb.append("ma");
        for (int i = 0; i < index; i++) {
            sb.append("a");
        }
        return sb.toString();
    }
}
