package com.github.kezhenxu94.playground.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 * There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.
 * <p>
 * An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.
 * <p>
 * Example:
 * <p>
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
 *
 * TODU unfinished
 *
 * @author kezhenxu
 */
public class Solution452MinimumNumberOfArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        if (points.length < 2)
            return points.length;
        int min = points[0][0];
        int max = points[0][1];
        for (int[] point : points) {
            if (point[0] < min)
                min = point[0];
            if (point[1] > max)
                max = point[1];
        }
        int[] count = new int[max - min + 1];
        for (int[] point : points) {
            for (int i = point[0]; i <= point[1]; i++) {
                count[i - min]++;
            }
        }
        int maxCood = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] > count[maxCood]) {
                maxCood = i;
            }
        }
        maxCood += min;
        List<int[]> remaining = new ArrayList<>();
        for (int[] point : points) {
            if (maxCood >= point[0] && maxCood <= point[1]) {
                continue;
            }
            remaining.add(point);
        }
        if (remaining.isEmpty())
            return 1;
        return 1 + findMinArrowShots(remaining.toArray(new int[0][0]));
    }
}
