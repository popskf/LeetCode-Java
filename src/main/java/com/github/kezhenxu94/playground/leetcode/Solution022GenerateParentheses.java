package com.github.kezhenxu94.playground.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *
 * 22. Generate Parentheses
 *
 *  Given n pairs of parentheses, write a function to generate all combinations
 *  of well-formed parentheses.
 *
 *  For example, given n = 3, a solution set is:
 *
 *  [
 *  "((()))",
 *  "(()())",
 *  "(())()",
 *  "()(())",
 *  "()()()"
 *  ]
 *
 *  </pre>
 *
 * @author ke.zhen.xu
 */
public class Solution022GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0)
            return result;
        char[] bt = new char[2 * n];
        backtracking(result, bt, 0, bt.length);
        return result;
    }

    public void backtracking(List<String> result, char[] bt, int k, int n) {
        char[] parentheses = {'(', ')'};
        for (char c : parentheses) {
            if (validIfAdded(bt, k, c)) {
                if (k == n - 1) {
                    if (parenthesesValid(bt, k, true))
                        result.add(new String(bt));
                } else
                    backtracking(result, bt, k + 1, n);
            }
        }
    }

    // if valid after adding char c, add it, and return true, else return false
    public boolean validIfAdded(char[] sb, int k, char c) {
        sb[k] = c;
        if (parenthesesValid(sb, k, false))
            return true;
        return false;
    }

    public boolean parenthesesValid(char[] sb, int k, boolean strict) {
        LinkedList<Character> stack = new LinkedList<>();
        char c;
        for (int i = 0; i <= k; i++) {
            if ((c = sb[i]) == '(')
                stack.addLast(c);
            else if (c == ')')
                if (stack.isEmpty() || stack.getLast() != '(')
                    return false;
                else
                    stack.removeLast();
        }
        if (strict)
            return stack.isEmpty();
        return true;
    }
}
