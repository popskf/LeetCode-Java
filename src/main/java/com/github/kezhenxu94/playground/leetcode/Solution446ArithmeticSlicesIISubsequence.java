package com.github.kezhenxu94.playground.leetcode;

/**
 * 446. Arithmetic Slices II - Subsequence
 * <p>
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between
 * any two consecutive elements is the same.
 * <p>
 * For example, these are arithmetic sequences:
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic.
 * <p>
 * 1, 1, 2, 5, 7
 * <p>
 * A zero-indexed array A consisting of N numbers is given. A subsequence slice of that array is any sequence of
 * integers (P0, P1, ..., Pk) such that 0 ≤ P0 < P1 < ... < Pk < N.
 * <p>
 * A subsequence slice (P0, P1, ..., Pk) of array A is called arithmetic if the sequence A[P0], A[P1], ..., A[Pk-1],
 * A[Pk] is arithmetic. In particular, this means that k ≥ 2.
 * <p>
 * The function should return the number of arithmetic subsequence slices in the array A.
 * <p>
 * The input contains N integers. Every integer is in the range of -231 and 231-1 and 0 ≤ N ≤ 1000. The output is
 * guaranteed to be less than 231-1.
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: [2, 4, 6, 8, 10]
 * <p>
 * Output: 7
 * <p>
 * Explanation:
 * All arithmetic subsequence slices are:
 * [2,4,6]
 * [4,6,8]
 * [6,8,10]
 * [2,4,6,8]
 * [4,6,8,10]
 * [2,4,6,8,10]
 * [2,6,10]
 *
 * TODU unfinished
 *
 * @author kezhenxu
 */
public class Solution446ArithmeticSlicesIISubsequence {

    public int numberOfArithmeticSlices(int[] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                result += backtracking(A, j, A[j] - A[i]);
            }
        }
        return result;
    }

    private int backtracking(int[] A, int lastIdx, long differ) {
        int result = 0;
        for (int i = lastIdx + 1; i < A.length; i++) {
            if (A[i] - A[lastIdx] == differ) {
                result += 1 + backtracking(A, i, differ);
            }
        }
        return result;
    }
}
