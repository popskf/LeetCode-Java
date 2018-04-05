package com.github.kezhenxu94.playground.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 401. Binary Watch
 *
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and
 * the 6 LEDs on the bottom represent the minutes (0-59).
 *
 * Each LED represents a zero or one, with the least significant bit on the
 * right.
 *
 * Given a non-negative integer n which represents the number of LEDs that are
 * currently on, return all possible times the watch could represent.
 *
 * Example:
 *
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08",
 * "0:16", "0:32"]
 *
 * Note:
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not
 * valid, it should be "1:00".
 * The minute must be consist of two digits and may contain a
 * leading zero, for example "10:2" is not valid, it should be
 * "10:02".
 *
 * [Tags] BackTracking
 *
 * TODO Optimize
 *
 * @author ke.zhen.xu
 */
public class Solution401BinaryWatch {

    private int[] leds = new int[10];
    private List<String> result = new ArrayList<>();
    private int num;

    public List<String> readBinaryWatch(int num) {
        this.result.clear();
        this.num = num;
        backtracking(0);
        return result;
    }

    // k means the kth led to be determined
    public void backtracking(int k) {
        for (int j = 0; j < 2; j++) {
            leds[k] = j;
            if (legal(leds, k, false)) {
                if (k == 9) {
                    int[] hhmm = decodeLEDS(leds, k);
                    if (legal(leds, k, true))
                        result.add(String.format("%d:%02d", hhmm[0], hhmm[1]));
                } else {
                    backtracking(k + 1);
                }
            }
        }
    }

    // decode the LED sequence to human readable time format
    public int[] decodeLEDS(int[] leds, int k) {
        int[] hhmm = new int[]{0, 0};
        for (int i = 0; i <= Math.min(3, k); i++)
            hhmm[0] += (leds[i] << (3 - i));
        for (int i = 4; i <= Math.min(9, k); i++)
            hhmm[1] += (leds[i] << (9 - i));
        return hhmm;
    }

    // check that whether the LEDS are legal for time representation
    public boolean legal(int[] leds, int k, boolean strict) {    // if strict, the count of led on must exactly be num
        int countsOn = 0;
        for (int i = 0; i <= k; i++)
            countsOn += leds[i];
        if (countsOn > num)
            return false;
        int[] hhmm = decodeLEDS(leds, k);
        if (strict)
            return countsOn == num && hhmm[0] < 13 && hhmm[1] < 60;
        return hhmm[0] < 12 && hhmm[1] < 60;
    }
}
