package com.github.kezhenxu94.playground.leetcode;

import org.junit.Test;

public class TestSolution013RomanToInteger {

    @Test
    public void testSolution013RomanToInteger() {
        Solution013RomanToInteger sol = new Solution013RomanToInteger();
        assert sol.romanToInt("I") == 1;
        assert sol.romanToInt("III") == 3;
        assert sol.romanToInt("XCV") == 95;
        assert sol.romanToInt("XCVIII") == 98;
        assert sol.romanToInt("XCIX") == 99;
    }
}
