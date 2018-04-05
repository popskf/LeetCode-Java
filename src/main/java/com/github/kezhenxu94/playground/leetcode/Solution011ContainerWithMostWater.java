package com.github.kezhenxu94.playground.leetcode;

/**
 * 11. Container With Most Water
 *
 * Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two
 * endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis
 * forms a container, such that the container
 * contains the most water.
 *
 * Note: You may not slant the container.
 *
 * [Tags] Two Pointers
 *
 * @author Ke Zhenxu
 */
public class Solution011ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = height.length - 1; j > i; j--) {
                max = Math.max(max, areaBetweenIJ(height, i, j));
                int heightJ = height[j];
                while (--j >= 0 && height[j] < heightJ) ;
                ++j;
            }
            int heightI = height[i];
            while (++i < height.length && height[i] < heightI) ;
            --i;
        }
        return max;
    }

    public int maxAreaV2(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            max = Math.max(max, areaBetweenIJ(height, i, j));
            int heightI = height[i];
            int heightJ = height[j];
            if (height[i] < height[j])
                i++;
            else if (height[i] > height[j])
                j--;
            else {
                while (i + 1 < j && height[i + 1] == heightI)
                    i++;
                while (i + 1 < j && height[j - 1] == heightJ)
                    j--;
                if (i + 1 < j - 1 && height[i + 1] > height[j - 1])
                    i++;
                else
                    j--;
            }
        }
        return max;
    }

    private int areaBetweenIJ(int[] height, int i, int j) {
        return Math.min(height[i], height[j]) * (j - i);
    }
}
