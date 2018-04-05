package com.github.kezhenxu94.playground.leetcode;

import java.util.LinkedList;

/**
 * 155. Min Stack
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 *
 * @author ke.zhen.xu
 */
public class Solution155MinStack {

    class MinStack {
        LinkedList<Integer> stack;
        int minIndex;

        public MinStack() {
            stack = new LinkedList<>();
            minIndex = 0;
        }

        public void push(int x) {
            stack.addLast(x);
            if (x < stack.get(minIndex))
                minIndex = stack.size() - 1;
        }

        public void pop() {
            stack.removeLast();
            if (!stack.isEmpty() && minIndex == stack.size())
                findNextMinimum();
        }

        public int top() {
            return stack.getLast();
        }

        public int getMin() {
            return stack.get(minIndex);
        }

        private void findNextMinimum() {
            minIndex = 0;
            int minValue = stack.get(0);
            for (int i = 1; i < stack.size(); i++) {
                if (stack.get(i) < minValue) {
                    minValue = stack.get(i);
                    minIndex = i;
                }
            }
        }
    }
}
