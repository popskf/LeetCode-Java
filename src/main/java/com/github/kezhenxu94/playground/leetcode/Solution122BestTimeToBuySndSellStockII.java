package com.github.kezhenxu94.playground.leetcode;

/**
 * 122. Best Time to Buy and Sell Stock II
 *
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again).
 *
 * TODO Optimize
 *
 * [Tags] Dynamic Programming
 *
 * @author ke.zhen.xu
 */
public class Solution122BestTimeToBuySndSellStockII {

    // Time Limit Exceeded
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1)
            return 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        dp[1] = prices[1] - prices[0];
        dp[1] = dp[1] > 0 ? dp[1] : 0;
        for (int i = 2; i < prices.length; i++) {
            dp[i] = dp[i - 1];
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = Math.max(dp[i], dp[j] + prices[i] - prices[j]);
            }
            while (i + 1 < prices.length && prices[i] == prices[i + 1]) {
                dp[i + 1] = dp[i];
                i++;
            }
        }
        return dp[prices.length - 1];
    }
}
