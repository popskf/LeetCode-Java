package com.github.kezhenxu94.playground.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 447. Number of Boomerangs
 * <p>
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 * <p>
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 * <p>
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 *
 * @author kezhenxu
 */
public class Solution447NumberOfBoomerangs {

    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        Map<Double, Integer> distanceCount = new HashMap<>();
        for (int[] point1 : points) {
            distanceCount.clear();
            for (int[] point2 : points) {
                if (point1 != point2) {
                    double distance = Math.pow((point2[0] - point1[0]), 2) + Math.pow(point2[1] - point1[1], 2);
                    distanceCount.put(distance, distanceCount.getOrDefault(distance, 0) + 1);
                }
            }
            for (Integer count : distanceCount.values()) {
                if (count > 1) {
                    result += count * (count - 1);
                }
            }
        }
        return result;
    }
}
