package String.Student_Attendance_Record_I;

/**
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 * <p>
 * You need to return whether the student could be rewarded according to his attendance record.
 * <p>
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */
public class Solution {
    public boolean checkRecord(String s) {
        return !moreThanOneA(s) && !continuousL(s);
    }

    private boolean moreThanOneA(String s) {
        int index = s.indexOf("A");
        if (index < 0)
            return false;
        if (index == s.length() - 1)
            return false;
        return s.indexOf("A", index + 1) > index;
    }

    private boolean continuousL(String s) {
        return s.contains("LLL");
    }
}
