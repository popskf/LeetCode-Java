package com.github.kezhenxu94.playground.leetcode;

import org.junit.Test;

public class TestSolution322CoinChange {

    @Test
    public void test() {
        Solution322CoinChange sol = new Solution322CoinChange();
        int[] coins = {1, 2, 5};
        assert sol.coinChange(coins, 0) == 0;
        assert sol.coinChange(coins, 1) == 1;
        assert sol.coinChange(coins, 2) == 1;
        assert sol.coinChange(coins, 3) == 2;
        assert sol.coinChange(coins, 4) == 2;
        assert sol.coinChange(coins, 5) == 1;
        assert sol.coinChange(coins, 6) == 2;
        assert sol.coinChange(coins, 7) == 2;
        assert sol.coinChange(coins, 8) == 3;
        assert sol.coinChange(coins, 9) == 3;
        assert sol.coinChange(coins, 10) == 2;
        assert sol.coinChange(coins, 11) == 3;

        assert sol.coinChange(new int[]{1}, 0) == 0;
        assert sol.coinChange(new int[]{2}, 3) == -1;
    }
}
