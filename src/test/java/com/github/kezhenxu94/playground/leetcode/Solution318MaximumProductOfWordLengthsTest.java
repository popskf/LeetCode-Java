package com.github.kezhenxu94.playground.leetcode;

import org.junit.Test;

/**
 * Created by kid on 2018/4/21.
 *
 * @author kezhenxu (kezhenxu94 at 163 dot com)
 */
public class Solution318MaximumProductOfWordLengthsTest {

    private final Solution318MaximumProductOfWordLengths solution318MaximumProductOfWordLengths = new Solution318MaximumProductOfWordLengths();
    private final Solution318MaximumProductOfWordLengths.Solution solution = solution318MaximumProductOfWordLengths.new Solution();

    @Test
    public void test0() {
        assert solution.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}) == 16;
        assert solution.maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}) == 4;
        assert solution.maxProduct(new String[]{"a", "aa", "aaa", "aaaa"}) == 0;

        assert solution.maxProduct(new String[]{"abc", "adef", "amno", "apqrs"}) == 0;
    }
}