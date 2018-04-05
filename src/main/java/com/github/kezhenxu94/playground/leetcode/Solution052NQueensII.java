package com.github.kezhenxu94.playground.leetcode;

import java.util.Arrays;

public class Solution052NQueensII {

    public int totalNQueens(int n) {
        char[][] temp = new char[n][n];
        for (int i = 0; i < n; i++)
            temp[i] = new char[n];
        for (int i = 0; i < n; i++)
            Arrays.fill(temp[i], '.');

        int[] result = {0};
        backtracking(result, n, temp, 0);
        return result[0];
    }

    private void backtracking(int[] result, int n, char[][] temp, int k) {
        for (int i = 0; i < n; i++) {
            temp[k][i] = 'Q';
            if (isPossible(n, temp, k, i)) {
                if (k == n - 1) {
                    result[0]++;
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