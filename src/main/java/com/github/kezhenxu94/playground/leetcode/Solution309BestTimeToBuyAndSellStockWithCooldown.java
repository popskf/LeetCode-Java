package com.github.kezhenxu94.playground.leetcode;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 *
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times) with the following restrictions:
 *
 * You may not engage in multiple transactions at the same time (ie, you must
 * sell the stock before you buy again). After you sell your stock, you cannot
 * buy stock on next day. (ie, cooldown 1 day)
 *
 * Example:
 *
 * prices = [1, 2, 3, 0, 2] maxProfit = 3
 *
 * transactions = [buy, sell, cooldown, buy, sell]
 *
 * TODO Optimize
 *
 * @author ke.zhen.xu
 */
public class Solution309BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1)
            return 0;

        int[] dp = new int[prices.length];
        dp[0] = 0;
        dp[1] = prices[1] - prices[0];
        dp[1] = dp[1] > 0 ? dp[1] : 0;
        for (int i = 2; i < prices.length; i++) {
            dp[i] = dp[i - 1];
            for (int j = i; j >= -1; j--) {
                if (j == i) {
                    dp[i] = Math.max(dp[i], dp[j - 1]);
                } else if (j > 0) {
                    dp[i] = Math.max(dp[i], dp[j - 1] + prices[i] - prices[j + 1]);
                } else {
                    dp[i] = Math.max(dp[i], prices[i] - prices[j + 1]);
                }
            }
        }
        return dp[prices.length - 1];
    }
}
