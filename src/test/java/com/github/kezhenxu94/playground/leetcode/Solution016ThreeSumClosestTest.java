package com.github.kezhenxu94.playground.leetcode;

import org.junit.Test;

/**
 * Created by kid on 2018/3/31.
 *
 * @author kezhenxu (kezhenxu94 at 163 dot com)
 */
public class Solution016ThreeSumClosestTest {
    private Solution016ThreeSumClosest solution016ThreeSumClosest = new Solution016ThreeSumClosest();
    private Solution016ThreeSumClosest.Solution solution = solution016ThreeSumClosest.new Solution();

    @Test
    public void test0() {
        assert solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1) == 2;
        assert solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 2) == 2;
        assert solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 3) == 2;

        assert solution.threeSumClosest(new int[]{-1, -2, -3, 4, 5}, 0) == 0;

        assert solution.threeSumClosest(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82) == 82;

        assert solution.threeSumClosest(new int[]{
                25, -12, 2, 66, -8, 67, 67, -93, -97, -68, -49, -24, 49, 90, 31,
                87, -1, 14, 50, -25, 69, -91, -23, 82, -43, 96, 80, 43, 4, -87,
                40, 24, -71, -10, -16, 78, -60, -20, -84, 69, 84, 84, 16, -23,
                -25, 88, 15, 72, -82, -72, -16, 49, 50, 26, 3, 26, -92, 82, -69,
                60, -81, 24, -25, -47, -77, -37, -33, 69, 21, -50, 56, -43, 18,
                -87, 96, 47, 59, 37, 100, 23, -34, -69, -12, -83, -65, 91, 75,
                100, 24, 80, 64, -27, -31, 39, -46, -73, 88, -13, -10, 67, 95,
                27, 91, -61, -44, 67, 0, -29, -57, -61, -62, 83, -6, 82, -58,
                -58, -5, -87, -44, 9, -20, -28, 3, 17, 57, -63, 78, 34, 7, -68,
                30, -49, 77, -97, 15, -42, -49, -22, -60, 78, 84, 35, 19}, 250) == 250;

        assert solution.threeSumClosest(new int[]{0, 2, 1, -3}, 1) == 0;

        assert solution.threeSumClosest(new int[]{1, 2, 3, 4, 5}, 8) == 8;
        assert solution.threeSumClosest(new int[]{1, 2, 3, 4, 5}, 9) == 9;
        assert solution.threeSumClosest(new int[]{1, 2, 3, 4, 5}, 10) == 10;
        assert solution.threeSumClosest(new int[]{1, 2, 3, 4, 5}, 11) == 11;
        assert solution.threeSumClosest(new int[]{1, 2, 3, 4, 5}, 12) == 12;
    }
}