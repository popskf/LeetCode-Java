package com.github.kezhenxu94.playground.leetcode;

/**
 * <pre>
 *
 * 404. Sum of Left Leaves
 *
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 *
 * </pre>
 *
 * @author ke.zhen.xu
 */
public class Solution404SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        int[] result = {0};
        sumup(result, root, false);
        return result[0];
    }


    private void sumup(int[] sumSoFar, TreeNode root, boolean left) {
        if (root == null)
            return;
        if (root.left == null && root.right == null && left) {
            sumSoFar[0] += root.val;
            return;
        }
        if (root.left != null)
            sumup(sumSoFar, root.left, true);
        if (root.right != null)
            sumup(sumSoFar, root.left, false);
    }
}
