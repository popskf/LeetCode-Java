package com.github.kezhenxu94.playground.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 *
 * Given numRows, generate the first numRows of Pascal's triangle.
 *
 * For example, given numRows = 5, Return
 *
 * <pre>
 *
 * [
 *     [1],
 *    [1,1],
 *   [1,2,1],
 *  [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 *
 * </pre>
 *
 * @author ke.zhen.xu
 */
public class Solution118PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> rowI = new ArrayList<>();
            List<Integer> lastRow = i == 1 ? null : result.get(i - 2);
            for (int j = 1; j <= i; j++) {
                rowI.add(j == 1 || j == i ? 1 : lastRow.get(j - 2) + lastRow.get(j - 1));
            }
            result.add(rowI);
        }
        return result;
    }
}
