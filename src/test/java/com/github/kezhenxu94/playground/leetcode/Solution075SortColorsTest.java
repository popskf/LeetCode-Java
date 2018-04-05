package com.github.kezhenxu94.playground.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by kid on 2018/4/4.
 *
 * @author kezhenxu (kezhenxu94 at 163 dot com)
 */
public class Solution075SortColorsTest {
    private Solution075SortColors solution075SortColors = new Solution075SortColors();
    private Solution075SortColors.Solution solution = solution075SortColors.new Solution();

    private Random random = new Random();

    @Test
    public void test0() {
        int[] ints = new int[]{
                2, 1, 1, 0, 1, 2, 0
        };

        int[] sorted = Arrays.copyOf(ints, ints.length);
        Arrays.sort(sorted);

        solution.sortColors(ints);

        Assert.assertArrayEquals(ints, sorted);
    }

    @Test
    public void test1() {
        for (int i = 0; i < 100; i++) {
            int[] ints = random.ints(100, 0, 3).toArray();
            int[] sorted = Arrays.copyOf(ints, ints.length);
            Arrays.sort(sorted);

            solution.sortColors(ints);

            Assert.assertArrayEquals(Arrays.toString(ints), ints, sorted);
        }
    }
}