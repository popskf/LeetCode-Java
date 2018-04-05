package com.github.kezhenxu94.playground.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note: The solution set must not contain duplicate triplets.
 *
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * [Tags] Two Pointers
 *
 * @author ke.zhen.xu
 */
public class Solution015ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int twoSum = -nums[i];
            int p1 = i + 1;
            int p2 = nums.length - 1;
            while (p1 < p2) {
                int sum = nums[p1] + nums[p2];
                if (sum == twoSum) {
                    result.add(Arrays.asList(nums[i], nums[p1], nums[p2]));
                    int prevP1 = p1;
                    while (p1 < p2 && nums[p1] == nums[prevP1])
                        p1++;
                    p2--;
                } else if (sum < twoSum) {
                    p1++;
                } else if (sum > twoSum) {
                    p2--;
                }
            }
            int prevI = i;
            while (i < nums.length && nums[i] == nums[prevI])
                i++;
            i--;
        }
        return result;
    }
}
