package com.github.kezhenxu94.playground.leetcode;

/**
 * 191. Number of 1 Bits
 *
 * Write a function that takes an unsigned integer and returns the number of ’1'
 * bits it has (also known as the Hamming weight).
 *
 * For example, the 32-bit integer ’11' has binary representation
 * 00000000000000000000000000001011, so the function should return 3.
 *
 * @author Ke Zhenxu
 */
public class Solution191NumberOf1Bits {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        long longN = 0x00000000FFFFFFFFL & n;
        int result = 0;
        for (int i = 0; i < 32; i++)
            result += (longN >> i) % 2;
        return result;
    }

    /**
     * @param n
     * @return
     * @see Solution231PowerOfTwo
     */
    public int hammingWeightV2(int n) {
        int result = 0;
        while (n != 0) {
            result++;
            n &= (n - 1);
        }
        return result;
    }
}
