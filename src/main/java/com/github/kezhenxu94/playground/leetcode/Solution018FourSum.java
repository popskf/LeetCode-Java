package com.github.kezhenxu94.playground.leetcode;

import java.util.*;

/**
 * <pre>
 *
 * 18. 4Sum
 *
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note: The solution set must not contain duplicate quadruplets.
 *
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *  [-1,  0, 0, 1],
 *  [-2, -1, 1, 2],
 *  [-2,  0, 0, 2]
 * ]
 *
 * </pre>
 * <p>
 * [Tags] Two Pointers
 * <p>
 *
 * @author Ke Zhenxu
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Solution018FourSum {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            return v2(nums, target);
        }

        private List<List<Integer>> v2(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length - 3; i++) {
                for (int j = nums.length - 1; j > i; j--) {
                    int remaining = target - nums[i] - nums[j];
                    int k = i + 1, l = j - 1;
                    while (k < l) {
                        int s = nums[k] + nums[l];
                        if (s == remaining) {
                            List<Integer> e = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(e);
                            if (result.stream().noneMatch(e::equals)) {
                                result.add(e);
                            }
                        }
                        if (s > remaining) {
                            l--;
                        } else {
                            k++;
                        }
                    }
                }
            }
            return result;
        }

        private List<List<Integer>> v1(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            backtracking(result, new int[4], nums, 0, target, new BitSet());
            return result;
        }

        private void backtracking(List<List<Integer>> result, int[] s, int[] nums, int k, int target, BitSet chosen) {
            int lastChosen = chosen.previousSetBit(chosen.size());
            for (int i = lastChosen < 0 ? 0 : lastChosen + 1; i < nums.length; ) {
                if (chosen.get(i)) {
                    i++;
                    continue;
                }
                s[k] = nums[i];
                chosen.set(i);
                if (isPossibleSolution(s, k, target, false)) {
                    if (k == 3) {
                        if (isPossibleSolution(s, k, target, true)) {
                            add(result, s);
                        }
                    } else {
                        backtracking(result, s, nums, k + 1, target, BitSet.valueOf(chosen.toByteArray()));
                    }
                } else {
                    break;
                }
                chosen.clear(i);
                i++;
                while (i < nums.length && nums[i] == nums[i - 1]) // avoid
                    // duplicates
                    i++;
            }
        }

        private void add(List<List<Integer>> result, int[] s) {
            List<Integer> list = new ArrayList<>();
            for (int n : s)
                list.add(n);
            result.add(list);
        }

        private boolean isPossibleSolution(int[] s, int k, int target, boolean strict) {
            int sum = 0;
            for (int i = 0; i <= k; i++)
                sum += s[i];
            if (strict)
                return sum == target;
            if (target >= 0)
                return sum <= target;
            return true;
        }
    }
}
