package com.github.kezhenxu94.playground.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum III
 *
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination
 * should be a unique set of numbers.
 *
 *
 * Example 1:
 *
 * Input: k = 3, n = 7
 *
 * Output:
 *
 * [[1,2,4]]
 *
 * Example 2:
 *
 * Input: k = 3, n = 9
 *
 * Output:
 *
 * [[1,2,6], [1,3,5], [2,3,4]]
 *
 * @author Ke Zhenxu
 */
public class Solution216CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        int[] temp = new int[k];
        backtracking(result, temp, 0, k, n, 1);
        return result;
    }

    private void backtracking(List<List<Integer>> result, int[] temp, int trackK, int k, int n, int startPoint) {
        for (int i = startPoint; i <= 9; i++) {
            temp[trackK] = i;
            if (isPossible(temp, trackK, k, n, false)) {
                if (trackK == k - 1) {
                    if (isPossible(temp, trackK, k, n, true)) {
                        add(result, temp);
                    }
                } else {
                    backtracking(result, temp, trackK + 1, k, n, i + 1);
                }
            }
        }
    }

    private void add(List<List<Integer>> result, int[] temp) {
        List<Integer> list = new ArrayList<>();
        for (int n : temp)
            list.add(n);
        result.add(list);
    }

    private boolean isPossible(int[] temp, int trackK, int k, int n, boolean strict) {
        int sum = 0;
        for (int i = 0; i <= trackK; i++)
            sum += temp[i];
        if (strict)
            return sum == n;
        return sum <= n;
    }
}
