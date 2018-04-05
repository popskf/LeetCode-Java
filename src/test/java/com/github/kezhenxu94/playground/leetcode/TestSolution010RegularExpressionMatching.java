package com.github.kezhenxu94.playground.leetcode;

import org.junit.Ignore;
import org.junit.Test;

public class TestSolution010RegularExpressionMatching {

    @Test
    @Ignore
    public void test() {
        Solution010RegularExpressionMatching sol = new Solution010RegularExpressionMatching();
        assert sol.isMatch("", "") == true;
        assert sol.isMatch("a", "a") == true;
        assert sol.isMatch("a", "ab") == false;
        assert sol.isMatch("ab", "a") == false;
        assert sol.isMatch("ab", "ab") == true;
        assert sol.isMatch("a", ".") == true;
        assert sol.isMatch("a", ".*") == true;
        assert sol.isMatch("ab", ".*") == true;
        assert sol.isMatch("aab", "c*a*b") == true;
        assert sol.isMatch("a.*asdfasdfababc", "a.*abc") == true;
        assert sol.isMatch("abcd", "d*") == false;
    }
}
