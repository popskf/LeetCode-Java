package com.github.kezhenxu94.playground.leetcode;

/**
 * 190. Reverse Bits Reverse bits of a given 32 bits unsigned integer.
 *
 * For example, given input 43261596 (represented in binary as
 * 00000010100101000001111010011100), return 964176192 (represented in binary as
 * 00111001011110000010100101000000).
 *
 * Follow up: If this function is called many times, how would you optimize it?
 *
 * TODO Optimize
 *
 * @author ke.zhen.xu
 */
public class Solution190ReverseBits {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        long unsigned = 0x00000000FFFFFFFFL & n;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += unsigned % 2;
            unsigned >>= 1;
        }
        return result;
    }
}
