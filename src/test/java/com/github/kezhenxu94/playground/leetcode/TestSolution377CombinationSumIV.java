package com.github.kezhenxu94.playground.leetcode;

import org.junit.Test;

public class TestSolution377CombinationSumIV {

    @Test
    public void test() {
        Solution377CombinationSumIV sol = new Solution377CombinationSumIV();
        assert sol.combinationSum4(new int[]{1, 2, 3}, 4) == 7;
        assert sol.combinationSum4(new int[]{1}, 5) == 1;
        assert sol.combinationSum4(new int[]{1, 2}, 5) == 8;
        assert sol.combinationSum4(new int[]{9}, 5) == 0;
    }
}
