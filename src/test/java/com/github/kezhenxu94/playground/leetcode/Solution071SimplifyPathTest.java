package com.github.kezhenxu94.playground.leetcode;

import org.junit.Test;

/**
 * Created by kid on 2018/4/25.
 *
 * @author kezhenxu (kezhenxu94 at 163 dot com)
 */
public class Solution071SimplifyPathTest {
    private Solution071SimplifyPath solution071SimplifyPath = new Solution071SimplifyPath();
    private Solution071SimplifyPath.Solution solution = solution071SimplifyPath.new Solution();

    @Test
    public void test0() {
        assert solution.simplifyPath("/../../").equals("/");
        assert solution.simplifyPath("/a/b//c/../d").equals("/a/b/d");
        assert solution.simplifyPath("/a/b//c/./d").equals("/a/b/c/d");
    }
}