package com.github.kezhenxu94.playground.leetcode;

/**
 * <pre>
 *
 * 130. Surrounded Regions
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * For example,
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * </pre>
 *
 * TODU unfinished
 *
 * @author kezhenxu
 */
public class Solution130SurroundedRegions {

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean[][] escapable = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            escapable[0][i] = board[0][i] == 'O';
            escapable[board.length - 1][i] = board[board.length - 1][i] == 'O';
            escapable[i][0] = board[i][0] == 'O';
            escapable[i][board.length - 1] = board[i][board.length - 1] == 'O';
        }
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[i].length - 1; j++) {
                if (board[i][j] == board[i - 1][j])
                    escapable[i][j] |= escapable[i - 1][j];
                if (board[i][j] == board[i][j - 1])
                    escapable[i][j] |= escapable[i][j - 1];
            }
        }
    }

    enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    ;

    private boolean escape(char[][] board, boolean[][] visited, int i, int j, Direction dir) {
        visited[i][j] = true;
        if (i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1)
            return true;
        boolean canEscape = false;
        if (dir != Direction.DOWN && !visited[i - 1][j] && board[i - 1][j] == 'O') {
            canEscape |= escape(board, visited, i - 1, j, Direction.DOWN);
        }
        if (dir != Direction.UP && !visited[i + 1][j] && board[i + 1][j] == 'O') {
            canEscape |= escape(board, visited, i + 1, j, Direction.UP);
        }
        if (dir != Direction.LEFT && !visited[i][j - 1] && board[i][j - 1] == 'O') {
            canEscape |= escape(board, visited, i, j - 1, Direction.LEFT);
        }
        if (dir != Direction.RIGHT && !visited[i][j + 1] && board[i][j + 1] == 'O') {
            canEscape |= escape(board, visited, i, j + 1, Direction.RIGHT);
        }
        if (!canEscape)
            board[i][j] = 'X';
        return canEscape;
    }
}
