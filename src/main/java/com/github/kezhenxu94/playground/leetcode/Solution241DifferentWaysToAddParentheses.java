package com.github.kezhenxu94.playground.leetcode;

import java.util.List;

/**
 * <pre>
 *
 * 241. Different Ways to Add Parentheses
 *
 * Given a string of numbers and operators, return all possible results from
 * computing all the different possible ways to group numbers and operators.
 * The valid operators are +, - and *.
 *
 *
 * Example 1
 * Input: "2-1-1".
 *
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 *
 *
 * Example 2
 * Input: "2*3-4*5"
 *
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 *
 * </pre>
 *
 * TODU unfinished
 *
 * @author ke.zhen.xu
 */
public class Solution241DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        int operator = 0;
        int result = 0;
        while ((operator = Math.min(input.indexOf('+', operator),
                Math.min(input.indexOf('-', operator), input.indexOf('*', operator)))) >= 0) {

        }
        return null;
    }

    private int compute(String input) {
        int firstOperator = Math.min(input.indexOf('+'), Math.min(input.indexOf('-'), input.indexOf('*')));
        if (firstOperator < 0)
            return Integer.valueOf(input);
        int num = Integer.valueOf(input.substring(0, firstOperator));
        switch (input.charAt(firstOperator)) {
            case '+':
                return num + compute(input.substring(firstOperator));
            case '-':
                return num - compute(input.substring(firstOperator));
            case '*':
                return num * compute(input.substring(firstOperator));
        }
        return 0;
    }
}
