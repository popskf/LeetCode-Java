package com.github.kezhenxu94.playground.leetcode;

/**
 * 374. Guess Number Higher or Lower
 *
 * <pre>
 *
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I'll tell you whether the number is higher or
 * lower.
 *
 * You call a pre-defined API guess(int num) which returns 3 possible results
 * (-1, 1, or 0):
 *
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 *
 * Example:
 *
 * n = 10, I pick 6.
 *
 * Return 6.
 *
 * </pre>
 *
 * @author ke.zhen.xu
 */
public class Solution374GuessNumberHigherOrLower extends GuessGame {
    /*
     * The guess API is defined in the parent class GuessGame.
     *
     * @param num, your guess
     *
     * @return -1 if my number is lower, 1 if my number is higher, otherwise
     * return 0 int guess(int num);
     */
    public int guessNumber(int n) {
        int lower = 1;
        int upper = n;
        int guessResult = 0;
        int myGuess;
        // FIXME !!! Overflow
        while ((guessResult = guess((myGuess = upper - (upper - lower) / 2))) != 0) {
            if (guessResult > 0)
                lower = myGuess + 1;
            else
                upper = myGuess - 1;
        }
        return myGuess;
    }

}

class GuessGame {
    public int guess(int n) {
        return 0;
    }
}