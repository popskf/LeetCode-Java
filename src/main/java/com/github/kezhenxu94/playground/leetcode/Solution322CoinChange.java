package com.github.kezhenxu94.playground.leetcode;

import java.util.Arrays;

/**
 * <pre>
 *
 * 322. Coin Change
 *
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 *
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 *
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 *
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 *
 * </pre>
 *
 * TODO Optimize
 *
 * [Tags] Dynamic Programming
 *
 * @author ke.zhen.xu
 */
public class Solution322CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] numToAmount = new int[amount + 1];
        Arrays.fill(numToAmount, Integer.MAX_VALUE);
        numToAmount[0] = 0;

        return coinChangeHelper(numToAmount, coins, amount);
    }

    /**
     * Bottom-Top solution
     *
     * @param numToAmount list of minimum number of coins needed to make up amount 1, 2,
     *                    3, etc.
     * @param coins       coin list
     * @param amount      final amount we want to solve
     * @return minimum count to make up the amount, -1 no way to make up the
     * amount using the coin list
     */
    private int coinChangeHelper(int[] numToAmount, int[] coins, int amount) {
        for (int j = 1; j <= amount; j++)
            for (int i = coins.length - 1; i >= 0; i--)
                if (coins[i] <= j && numToAmount[j - coins[i]] != Integer.MAX_VALUE)
                    numToAmount[j] = Math.min(numToAmount[j], 1 + numToAmount[j - coins[i]]);

        if (numToAmount[amount] == Integer.MAX_VALUE)
            return -1;
        return numToAmount[amount];
    }
}
