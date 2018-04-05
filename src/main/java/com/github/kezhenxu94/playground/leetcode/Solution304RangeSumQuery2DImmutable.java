package com.github.kezhenxu94.playground.leetcode;

/**
 * <pre>
 *
 * 304. Range Sum Query 2D - Immutable
 *
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle
 * defined by its upper left corner (row1, col1) and lower right corner (row2,
 * col2).
 *
 * Example:
 *
 * Given matrix =
 * [
 * 	[3, 0, 1, 4, 2],
 *  [5, 6, 3, 2, 1],
 *  [1, 2, 0, 1, 5],
 *  [4, 1, 0, 1, 7],
 *  [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *
 * Note:
 *
 * You may assume that the matrix does not change. There are many calls to
 * sumRegion function. You may assume that row1 ≤ row2 and col1 ≤ col2.
 *
 * </pre>
 *
 * [Tags] Dynamic Programming
 *
 * @author ke.zhen.xu
 */
public class Solution304RangeSumQuery2DImmutable {

    class NumMatrix {
        private int[][] cache;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0)
                return;
            cache = new int[matrix.length][matrix[0].length];
            cache[0][0] = matrix[0][0];
            for (int i = 1; i < matrix.length; i++)
                cache[i][0] = cache[i - 1][0] + matrix[i][0];
            for (int i = 1; i < matrix[0].length; i++)
                cache[0][i] = cache[0][i - 1] + matrix[0][i];

            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[i].length; j++) {
                    cache[i][j] = cache[i - 1][j] + cache[i][j - 1] - cache[i - 1][j - 1] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (cache == null)
                return 0;
            int result = cache[row2][col2];
            if (row1 - 1 >= 0)
                result -= cache[row1 - 1][col2];
            if (col1 - 1 >= 0)
                result -= cache[row2][col1 - 1];
            if (row1 - 1 >= 0 && col1 - 1 >= 0)
                result += cache[row1 - 1][col1 - 1];
            return result;
        }
    }
}
