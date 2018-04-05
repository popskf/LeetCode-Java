package com.github.kezhenxu94.playground.leetcode;

/**
 * 110. Balanced Binary Tree
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 *
 * @author Ke Zhenxu
 */
public class Solution110BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        if (Math.abs(depth(root.left) - depth(root.right)) <= 1)
            return isBalanced(root.left) && isBalanced(root.right);
        return false;
    }

    private int depth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
