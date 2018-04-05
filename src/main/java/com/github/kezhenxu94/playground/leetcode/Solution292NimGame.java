package com.github.kezhenxu94.playground.leetcode;

/**
 * 292. Nim Game
 *
 * You are playing the following Nim Game with your friend:
 * There is a heap of stones on the table, each time one of
 * you take turns to remove 1 to 3 stones.
 * The one who removes the last stone will be the winner.
 * You will take the first turn to remove the stones.
 *
 * Both of you are very clever and have optimal strategies for the game.
 * rite a function to determine whether you can win the game
 * given the number of stones in the heap.
 *
 * For example, if there are 4 stones in the heap,
 * then you will never win the game: no matter 1, 2, or 3 stones you remove,
 * the last stone will always be removed by your friend.
 */
public class Solution292NimGame {

    /**
     *
     * 最直接的方法，使用递归方法
     * 当数字比较大的时候(Time Limit Exceeded)，如38。
     *
     * 使用缓存表存放中间结果，
     * 当数字更大的时候(Time Limit Exceeded)，如1348820612)。
     *
     */
    /*
     * private Map<Integer, Boolean> table = new HashMap<Integer, Boolean>();
     * public boolean canWinNim(int n) {
     * 	if (table.containsKey(n))
     * 		return table.get(n);

     * 	Boolean result = null;
     * 	if (n == 0)								// Have been removed by the counterpart in last turn, LOST
     * 		result = false;
     * 	else if (n <= 3)						// Can be removed in my turn, WIN
     * 		result = true;

     * 	if (result != null) {
     * 		table.putIfAbsent(n, result);
     * 		return result;
     * 	}

     * 	result = (table.getOrDefault(n - 2, canWinNim(n - 2)) && table.getOrDefault(n - 3, canWinNim(n - 3)) && table.getOrDefault(n - 4, canWinNim(n - 4))) ||
     * 			 (table.getOrDefault(n - 3, canWinNim(n - 3)) && table.getOrDefault(n - 4, canWinNim(n - 4)) && table.getOrDefault(n - 5, canWinNim(n - 5))) ||
     * 			 (table.getOrDefault(n - 4, canWinNim(n - 4)) && table.getOrDefault(n - 5, canWinNim(n - 5)) && table.getOrDefault(n - 6, canWinNim(n - 6)));
     * 	table.putIfAbsent(n, result);
     * 	return result;
     * }
     */

    /**
     * 无论对方取多少石子，本方总能将本回合两人取走的数量凑成4，
     * 如果由对方最先开始取石子的话，只要石子总数被4除余数为0，
     * 也就是本方取完最后的石子，那么本方就能获胜。
     *
     * 但题目要求由本方开始取石子，假设原来的石子总数被4除余数不等于0，
     * 余数为1，2，或3，本方只需要将余数的石子取走，即可满足上面的获胜条件。
     * 否则，即原来石子总数被4整除，此时无论本方怎么取，对方都可以按照
     * 以上策略获胜，本方则输。
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
