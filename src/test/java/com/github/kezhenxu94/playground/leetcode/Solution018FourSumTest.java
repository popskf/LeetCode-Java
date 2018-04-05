package com.github.kezhenxu94.playground.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kid on 2018/3/31.
 *
 * @author kezhenxu (kezhenxu94 at 163 dot com)
 */
public class Solution018FourSumTest {
    private Solution018FourSum solution018FourSum = new Solution018FourSum();
    private Solution018FourSum.Solution solution = solution018FourSum.new Solution();

    @Test
    public void test0() {
        List<List<Integer>> result = solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);

        assert result.size() == 3;
        assert result.stream().anyMatch(it -> it.containsAll(Arrays.asList(-1, 0, 0, 1)));
        assert result.stream().anyMatch(it -> it.containsAll(Arrays.asList(-2, -1, 1, 2)));
        assert result.stream().anyMatch(it -> it.containsAll(Arrays.asList(-2, 0, 0, 2)));

        result = solution.fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0);

        assert result.size() == 8;
        assert result.stream().anyMatch(it -> it.containsAll(Arrays.asList(-3, -2, 2, 3)));
        assert result.stream().anyMatch(it -> it.containsAll(Arrays.asList(-3, -1, 1, 3)));
        assert result.stream().anyMatch(it -> it.containsAll(Arrays.asList(-3, 0, 0, 3)));
        assert result.stream().anyMatch(it -> it.containsAll(Arrays.asList(-3, 0, 1, 2)));
        assert result.stream().anyMatch(it -> it.containsAll(Arrays.asList(-2, -1, 0, 3)));
        assert result.stream().anyMatch(it -> it.containsAll(Arrays.asList(-2, -1, 1, 2)));
        assert result.stream().anyMatch(it -> it.containsAll(Arrays.asList(-2, 0, 0, 2)));
        assert result.stream().anyMatch(it -> it.containsAll(Arrays.asList(-1, 0, 0, 1)));

        result = solution.fourSum(new int[]{2, -4, -5, -2, -3, -5, 0, 4, -2}, -14);

        assert result.size() == 3;
        assert result.stream().anyMatch(it -> it.containsAll(Arrays.asList(-5, -5, -4, 0)));
        assert result.stream().anyMatch(it -> it.containsAll(Arrays.asList(-5, -5, -2, -2)));
        assert result.stream().anyMatch(it -> it.containsAll(Arrays.asList(-5, -4, -3, -2)));
    }
}