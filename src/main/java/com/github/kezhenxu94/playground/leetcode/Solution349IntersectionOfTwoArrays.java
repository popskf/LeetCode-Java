package com.github.kezhenxu94.playground.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. Intersection of Two Arrays
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 *
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 * TODO Optimization
 */
public class Solution349IntersectionOfTwoArrays {

    /**
     * m = array1.length
     * n = array2.length
     *
     * T = O(m x n)
     */
    public int[] intersection(int[] array1, int[] array2) {
        Set<Integer> result = new HashSet<Integer>();
        for (int e1 : array1)
            for (int e2 : array2)
                if (e1 == e2)
                    result.add(e1);
        int[] r = new int[result.size()];
        int i = 0;
        for (int e : result)
            r[i++] = e;
        return r;
    }

}
