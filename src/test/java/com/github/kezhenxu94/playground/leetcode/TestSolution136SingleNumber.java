package com.github.kezhenxu94.playground.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 136. Single Number
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class TestSolution136SingleNumber {

    @Test
    public void test() {
        Solution136SingleNumber sol = new Solution136SingleNumber();
        int[] array = new int[]{1, 2, 3, 1, 2, 4, 4, 3, 6};
        int singleNum = sol.singleNumber(array);
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("single number " + singleNum);
    }
}
