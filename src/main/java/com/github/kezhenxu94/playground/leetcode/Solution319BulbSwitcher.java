package com.github.kezhenxu94.playground.leetcode;

import java.util.BitSet;

/**
 * <pre>
 *
 * 319. Bulb Switcher
 *
 * There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
 *
 * Example:
 *
 * Given n = 3.
 *
 * At first, the three bulbs are [off, off, off].
 * After first round, the three bulbs are [on, on, on].
 * After second round, the three bulbs are [on, off, on].
 * After third round, the three bulbs are [on, off, off].
 *
 * So you should return 1, because there is only one bulb is on.
 *
 *
 * </pre>
 *
 * TODU unfinished
 *
 * @author Ke Zhenxu
 */
public class Solution319BulbSwitcher {

    // brute-force
    // Time Limited Exceeded
    public int bulbSwitch(int n) {
        BitSet bs = new BitSet(n + 1);
        for (int i = 1; i <= n; i++)
            for (int j = i; j <= n; j += i)
                bs.flip(j);
        int result = 0;
        for (int i = 1; i <= n; i++)
            result += bs.get(i) ? 1 : 0;
        return result;
    }
}
