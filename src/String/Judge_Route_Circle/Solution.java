package String.Judge_Route_Circle;

/**
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
 * <p>
 * The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
 * <p>
 * Example 1:
 * Input: "UD"
 * Output: true
 * Example 2:
 * Input: "LL"
 * Output: false
 */
public class Solution {
    public boolean judgeCircle(String moves) {
        int L = 0;
        int R = 0;
        int U = 0;
        int D = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    U++;
                    break;
                case 'D':
                    D++;
                    break;
                case 'L':
                    L++;
                    break;
                case 'R':
                    R++;
                    break;
                default:
                    return false;
            }
        }

        return L == R && U == D;
    }
}
