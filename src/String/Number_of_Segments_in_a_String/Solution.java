package String.Number_of_Segments_in_a_String;

/**
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * <p>
 * Please note that the string does not contain any non-printable characters.
 * <p>
 * Example:
 * <p>
 * Input: "Hello, my name is John"
 * Output: 5
 */
public class Solution {
    public int countSegments(String s) {
        if (s.length() == 0)
            return 0;
        String[] strings = s.split("[ ]+");
        int count = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(""))
                continue;
            count++;
        }
        return count;
    }
}
