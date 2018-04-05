package com.github.kezhenxu94.playground.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum
 *
 * Given a set of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 *
 * [
 * [7],
 * [2, 2, 3]
 * ]
 *
 * @author ke.zhen.xu
 */
public class Solution039CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                backtracking(result, candidates, target, temp, k + 1, idx);
            } else {
                break;
            }
        }
    }
}
