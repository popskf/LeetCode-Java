package com.github.kezhenxu94.playground.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N-Queens
 *
 * The n-queens puzzle is the problem of placing n
 * queens on an n×n chessboard such that no two
 * queens attack each other.
 *
 * Given an integer n, return all distinct
 * solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration
 * of the n-queens' placement, where 'Q' and '.' both
 * indicate a queen and an empty space respectively.
 *
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 *
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 *
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 *
 * @author Ke Zhenxu
 */
public class Solution051NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] temp = new char[n][n];
        for (int i = 0; i < n; i++)
            temp[i] = new char[n];
        for (int i = 0; i < n; i++)
            Arrays.fill(temp[i], '.');
        backtracking(result, n, temp, 0);
        return result;
    }

    private void backtracking(List<List<String>> result, int n, char[][] temp, int k) {
        for (int i = 0; i < n; i++) {
            temp[k][i] = 'Q';
            if (isPossible(n, temp, k, i)) {
                if (k == n - 1) {
                    List<String> list = new ArrayList<>();
                    for (char[] cs : temp)
                        list.add(new String(cs));
                    result.add(list);
                } else {
                    backtracking(result, n, temp, k + 1);
                }
            }
            temp[k][i] = '.';
        }
    }

    private boolean isPossible(int n, char[][] temp, int k, int i) {
        for (int j = 0; j < n; j++)
            if (j == k)
                continue;
            else if (temp[j][i] == 'Q')
                return false;
        for (int j = 0; j <= i; j++)
            if (j == i)
                continue;
            else if (temp[k][j] == 'Q')
                return false;
        for (int p = k - 1, q = i - 1; p >= 0 && q >= 0; p--, q--) {
            if (temp[p][q] == 'Q')
                return false;
        }
        for (int p = k - 1, q = i + 1; p >= 0 && q < n; p--, q++) {
            if (temp[p][q] == 'Q')
                return false;
        }
        return true;
    }
}
