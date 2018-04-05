package com.github.kezhenxu94.playground.leetcode;

/**
 * <pre>
 *
 * 375. Guess Number Higher or Lower II
 *
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 *
 * However, when you guess a particular number x, and you guess wrong,
 * you pay $x. You win the game when you guess the number I picked.
 *
 * Example:
 *
 * n = 10, I pick 8.
 *
 * First round:  You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 *
 * Game over. 8 is the number I picked.
 *
 * You end up paying $5 + $7 + $9 = $21.
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 *
 * </pre>
 *
 * @author Ke Zhenxu
 */
public class Solution375GuessNumberHigherOrLowerII {

    // TODO Unfinished version
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < dp.length; i++)
            dp[i] = new int[n + 1];

        for (int i = 1; i < n; i++) {
            dp[i][i + 1] = i;
        }

        for (int i = n; i > 1; i--) {
            for (int j = i - 1; j > 1; j--) {
                for (int k = j; k < i; k++) {
                    dp[j][i] = Math.min(dp[j][i] == 0 ? Integer.MAX_VALUE : dp[j][i], k + dp[k + 1][i]);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            result = Math.min(result, i + dp[1][i - 1] + dp[i + 1][n]);
            System.out.printf("%d-%d=%d, %d-%d=%d\n", 1, i - 1, dp[1][i - 1], i + 1, n, dp[i + 1][n]);
        }

        return result;
    }

    public int getMoneyAmountTopDown(int n) {
        Integer[][] memo = new Integer[n + 1][n + 1];
        return getMoneyAmountTopDownHelper(memo, 1, n);
    }

    public int getMoneyAmountTopDownHelper(Integer[][] memo, int from, int to) {
        if (memo[from][to] != null)
            return memo[from][to];

        if (from == to) {
            memo[from][to] = 0;
            return memo[from][to];
        }
        if (from + 1 == to) {
            memo[from][to] = from;
            return memo[from][to];
        }
        if (from + 2 == to) {
            memo[from][to] = from + 1;
            return memo[from][to];
        }

        for (int i = from + 1; i < to; i++)
            memo[from][to] = Math.min(memo[from][to] == null ? Integer.MAX_VALUE : memo[from][to],
                    i + Math.max(getMoneyAmountTopDownHelper(memo, from, i - 1), getMoneyAmountTopDownHelper(memo, i + 1, to)));
        return memo[from][to];
    }
}
