package Depth_First_Search.Minesweeper;

/**
 * Let's play the minesweeper game (Wikipedia, online game)!
 * <p>
 * You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.
 * <p>
 * Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:
 * <p>
 * If a mine ('M') is revealed, then the game is over - change it to 'X'.
 * If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
 * If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
 * Return the board when no more squares will be revealed.
 * Example 1:
 * Input:
 * <p>
 * [['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'M', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E']]
 * <p>
 * Click : [3,0]
 * <p>
 * Output:
 * <p>
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'M', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 * <p>
 * Explanation:
 * <p>
 * Example 2:
 * Input:
 * <p>
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'M', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 * <p>
 * Click : [1,2]
 * <p>
 * Output:
 * <p>
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'X', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 * <p>
 * Explanation:
 * <p>
 * Note:
 * The range of the input matrix's height and width is [1,50].
 * The click position will only be an unrevealed square ('M' or 'E'), which also means the input board contains at least one clickable square.
 * The input board won't be a stage when game is over (some mines have been revealed).
 * For simplicity, not mentioned rules should be ignored in this problem. For example, you don't need to reveal all the unrevealed mines when the game is over, consider any cases that you will win the game or flag any squares.
 */
public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        transaction(board, click);
        return board;
    }

    private void transaction(char[][] board, int[] coordinates) {
        int r = coordinates[0];
        int c = coordinates[1];
        char button = board[r][c];
        switch (button) {
            case 'M':
                board[r][c] = 'X';
                break;
            case 'E':
                int count = 0;
                for (int i = -1; i < 2; i++) {
                    if (r + i < 0 || r + i >= board.length)
                        continue;
                    for (int j = -1; j < 2; j++) {
                        if (c + j < 0 || c + j >= board[0].length)
                            continue;
                        if (i == 0 && j == 0)
                            continue;
                        if (board[r + i][c + j] == 'M') {
                            count++;
                        }
                    }
                }
                if (count == 0) {
                    board[r][c] = 'B';
                    for (int i = -1; i < 2; i++) {
                        if (r + i < 0 || r + i >= board.length)
                            continue;
                        for (int j = -1; j < 2; j++) {
                            if (c + j < 0 || c + j >= board[0].length)
                                continue;
                            if (i == 0 && j == 0)
                                continue;
                            int[] near = {r + i, c + j};
                            transaction(board, near);
                        }
                    }
                }
                else {
                    board[r][c] = (char) (count + 48);
                }
                break;
            default:
        }
    }
}
