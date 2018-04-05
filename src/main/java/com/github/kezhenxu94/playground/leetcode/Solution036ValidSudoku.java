package com.github.kezhenxu94.playground.leetcode;

import java.util.BitSet;

/**
 * 36. Valid Sudoku
 *
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *
 * http://sudoku.com.au/TheRules.aspx
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable.
 * Only the filled cells need to be validated.
 *
 * @author Ke Zhenxu
 */
public class Solution036ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        BitSet row = new BitSet();
        BitSet col = new BitSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (row.get(board[i][j]))
                        return false;
                    row.set(board[i][j]);
                }
                if (board[j][i] != '.') {
                    if (col.get(board[j][i]))
                        return false;
                    col.set(board[j][i]);
                }
            }
            row.clear();
            col.clear();
        }
        for (int i = 0; i < 9; i += 3)
            for (int j = 0; j < 9; j += 3)
                if (!isValidSudoku(board, i, j, i + 3, j + 3))
                    return false;
        return true;
    }

    public boolean isValidSudoku(char[][] board, int leftUpRow, int leftUpCol, int rightDownRow, int rightDownCol) {
        BitSet bits = new BitSet();
        for (int i = leftUpRow; i < rightDownRow; i++)
            for (int j = leftUpCol; j < rightDownCol; j++)
                if (board[i][j] != '.')
                    if (bits.get(board[i][j]))
                        return false;
                    else
                        bits.set(board[i][j]);
        return true;
    }
}
