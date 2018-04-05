package com.github.kezhenxu94.playground.leetcode;

import java.util.Arrays;

/**
 * 79. Word Search
 *
 * <pre>
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 *
 * For example,
 * Given board =
 *
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 *
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 *
 * </pre>
 *
 * @author ke.zhen.xu
 */
public class Solution079WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board.length * board[0].length < word.length())
            return false;
        boolean[][] visited = new boolean[board.length][board.length];
        for (int i = 0; i < visited.length; i++)
            visited[i] = new boolean[board[i].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    for (int k = 0; k < visited.length; k++)
                        Arrays.fill(visited[k], false);
                    visited[i][j] = true;
                    if (backtracking(visited, board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtracking(boolean[][] visited, char[][] board, String word, int i, int j, int k) {
        if (k == word.length() - 1)
            return true;
        if (i - 1 >= 0 && !visited[i - 1][j] && board[i - 1][j] == word.charAt(k + 1)) {
            visited[i - 1][j] = true;
            if (backtracking(visited, board, word, i - 1, j, k + 1))
                return true;
            visited[i - 1][j] = false;
        }
        if (i + 1 < board.length && !visited[i + 1][j] && board[i + 1][j] == word.charAt(k + 1)) {
            visited[i + 1][j] = true;
            if (backtracking(visited, board, word, i + 1, j, k + 1))
                return true;
            visited[i + 1][j] = false;
        }
        if (j - 1 >= 0 && !visited[i][j - 1] && board[i][j - 1] == word.charAt(k + 1)) {
            visited[i][j - 1] = true;
            if (backtracking(visited, board, word, i, j - 1, k + 1))
                return true;
            visited[i][j - 1] = false;
        }
        if (j + 1 < board[i].length && !visited[i][j + 1] && board[i][j + 1] == word.charAt(k + 1)) {
            visited[i][j + 1] = true;
            ;
            if (backtracking(visited, board, word, i, j + 1, k + 1))
                return true;
            visited[i][j + 1] = false;
            ;
        }
        return false;
    }
}
