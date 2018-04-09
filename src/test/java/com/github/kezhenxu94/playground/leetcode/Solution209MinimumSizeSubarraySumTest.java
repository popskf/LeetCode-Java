package com.github.kezhenxu94.playground.leetcode;

import org.junit.Test;

/**
 * Created by kid on 2018/4/6.
 *
 * @author kezhenxu (kezhenxu94 at 163 dot com)
 */
public class Solution209MinimumSizeSubarraySumTest {
    private Solution209MinimumSizeSubarraySum solution209MinimumSizeSubarraySum = new Solution209MinimumSizeSubarraySum();
    private Solution209MinimumSizeSubarraySum.Solution solution = solution209MinimumSizeSubarraySum.new Solution();

    @Test
    public void test0() {
        assert solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}) == 2;
        assert solution.minSubArrayLen(2, new int[]{2, 2, 2, 2, 2, 2}) == 1;
        assert solution.minSubArrayLen(20, new int[]{2, 2, 2, 2, 2, 2}) == 0;
    }
}