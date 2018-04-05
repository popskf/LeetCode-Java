package com.github.kezhenxu94.playground.leetcode;

import org.junit.Test;

public class TestSolution300LongestIncreasingSubsequence {

    @Test
    public void test() {
        Solution300LongestIncreasingSubsequence sol = new Solution300LongestIncreasingSubsequence();
        assert sol.lengthOfLIS(new int[0]) == 0;
        assert sol.lengthOfLIS(new int[]{1}) == 1;
        assert sol.lengthOfLIS(new int[]{1, 2}) == 2;
        assert sol.lengthOfLIS(new int[]{1, 3, 5, 7, 2, 4, 6, 8}) == 5;
    }
}
