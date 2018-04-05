package com.github.kezhenxu94.playground.leetcode;

import org.junit.Test;

public class TestSolution376WiggleSubsequence {

    @Test
    public void testSolution376WiggleSubsequence() {
        Solution376WiggleSubsequence sol = new Solution376WiggleSubsequence();
        assert sol.wiggleMaxLength(new int[0]) == 0;
        assert sol.wiggleMaxLength(new int[]{0}) == 1;
        assert sol.wiggleMaxLength(new int[]{0, 0}) == 1;
        assert sol.wiggleMaxLength(new int[]{0, 0, 0}) == 1;
        assert sol.wiggleMaxLength(new int[]{0, 1}) == 2;
        assert sol.wiggleMaxLength(new int[]{0, 1, 0}) == 3;
        assert sol.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}) == 6;
        assert sol.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}) == 7;
        assert sol.wiggleMaxLength(new int[]{3, 3, 3, 2, 5}) == 3;
    }
}
