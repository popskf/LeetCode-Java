package com.github.kezhenxu94.playground.leetcode;

/**
 * 65. Valid Number
 *
 * Validate if a given string is numeric.
 *
 * Some examples:
 *
 * "0" => true
 *
 * " 0.1 " => true
 *
 * "abc" => false
 *
 * "1 a" => false
 *
 * "2e10" => true
 *
 * Note: It is intended for the problem statement to be ambiguous. You should
 * gather all requirements up front before implementing one.
 *
 * @author ke.zhen.xu
 */
public class Solution065ValidNumber {

    enum State {
        INTEGER, DOUBLE, EXP
    }

    public boolean isNumber(String s) {
        s = s.trim();
        if (s.isEmpty())
            return false;
        char[] sa = s.toCharArray();
        State state = State.INTEGER;
        boolean startOfState = true;
        for (int i = 0; i < sa.length; i++) {
            if (sa[i] == '-' || sa[i] == '+') {
                if (!startOfState || state == State.DOUBLE) {
                    return false;
                }
            } else if (Character.isDigit(sa[i])) {
                startOfState = false;
                continue;
            } else if (sa[i] == '.') {
                if (state == State.DOUBLE || state == State.EXP)
                    return false;
                state = State.DOUBLE;
            } else if (sa[i] == 'e') {
                if (startOfState || state == State.EXP)
                    return false;
                startOfState = true;
                state = State.EXP;
            } else {
                return false;
            }
        }
        return !startOfState;
    }
}