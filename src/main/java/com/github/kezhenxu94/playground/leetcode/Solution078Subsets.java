package com.github.kezhenxu94.playground.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 *
 * Given a set of distinct integers, nums, return all possible subsets.
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * For example, If nums = [1,2,3], a solution is:
 *
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 *
 * @author ke.zhen.xu
 */
public class Solution078Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, new boolean[nums.length], nums, 0);
        return result;
    }

    private static boolean[] choices = {true, false};

    public void backtracking(List<List<Integer>> result, boolean[] temp, int[] nums, int k) {
        for (boolean choice : choices) {
            temp[k] = choice;
            if (k == nums.length - 1) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j <= k; j++)
                    if (temp[j])
                        list.add(nums[j]);
                result.add(list);
            } else if (k + 1 < nums.length)
                backtracking(result, temp, nums, k + 1);
        }
    }
}
