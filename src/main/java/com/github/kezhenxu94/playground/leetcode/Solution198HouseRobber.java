package com.github.kezhenxu94.playground.leetcode;

import java.util.Arrays;

/**
 * 198. House Robber
 *
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 *
 * [Tags] Dynamic Programming
 *
 * @author ke.zhen.xu
 */
public class Solution198HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] cacheProfit = new int[nums.length];
        Arrays.fill(cacheProfit, -1);
        return maxProfitToIndex(nums, cacheProfit, nums.length - 1);
    }

    /**
     * This method returns the max profit if I rob the first index houses
     * (nums[0...index]).
     */
    private int maxProfitToIndex(int[] nums, int[] cache, int index) {
        if (index == 0) {
            cache[index] = nums[0];
            return cache[0];
        }
        if (index == 1) {
            cache[index] = Math.max(nums[0], nums[1]);
            return cache[1];
        }
        if (cache[index] < 0)
            cache[index] = Math.max(nums[index] + maxProfitToIndex(nums, cache, index - 2),
                    maxProfitToIndex(nums, cache, index - 1));
        return cache[index];
    }
}
