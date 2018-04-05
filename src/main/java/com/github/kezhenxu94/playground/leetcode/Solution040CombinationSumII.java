package com.github.kezhenxu94.playground.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 *
 * <pre>
 *
 * Given a collection of candidate numbers (C) and a target number (T), find
 * all unique combinations in C where the candidate numbers sums to T.
 *
 * Each number in C may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target
 * 8,
 * A solution set is:
 *
 * [
 *  [1, 7],
 *  [1, 2, 5],
 *  [2, 6],
 *  [1, 1, 6]
 * ]
 *
 * </pre>
 *
 * @author ke.zhen.xu
 */
public class Solution040CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, candidates, target, new int[target / candidates[0] + 1], 0, 0);
        return result;
    }

    private void backtracking(List<List<Integer>> result, int[] candidates, int target, int[] temp, int k, int start) {
        for (int idx = start; idx < candidates.length; idx++) {
            temp[k] = candidates[idx];
            int sum = 0;
            for (int i = 0; i <= k; i++)
                sum += temp[i];
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i <= k; i++)
                    list.add(temp[i]);
                result.add(list);
            } else if (sum < target) {
                backtracking(result, candidates, target, temp, k + 1, idx + 1);
            } else {
                break;
            }
            while (idx + 1 < candidates.length && candidates[idx + 1] == candidates[idx])
                idx++;
        }
    }
}
