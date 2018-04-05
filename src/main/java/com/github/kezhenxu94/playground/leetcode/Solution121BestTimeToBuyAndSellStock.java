package com.github.kezhenxu94.playground.leetcode;

/**
 * 121. Best Time to Buy and Sell Stock
 *
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 *
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 *
 * Example 1:
 *
 * Input: [7, 1, 5, 3, 6, 4] Output: 5
 *
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger
 * than buying price)
 *
 * Example 2:
 *
 * Input: [7, 6, 4, 3, 1] Output: 0
 *
 * In this case, no transaction is done, i.e. max profit = 0.
 *
 * @author ke.zhen.xu
 */
public class Solution121BestTimeToBuyAndSellStock {

    /**
     * Violent solution
     * Time Limit Exceeded
     *
     * TODO Optimize
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            int maxSell = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > maxSell) {
                    maxSell = prices[j];
                }
            }
            if (maxProfit < maxSell - prices[i])
                maxProfit = maxSell - prices[i];
        }
        return maxProfit;
    }

}
