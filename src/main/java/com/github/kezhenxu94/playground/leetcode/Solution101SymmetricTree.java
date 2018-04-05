package com.github.kezhenxu94.playground.leetcode;

/**
 * 101. Symmetric Tree
 *
 * <pre>
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 *
 * </pre>
 *
 * TODO Use iterative method
 *
 * @author ke.zhen.xu
 */
public class Solution101SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isTreeSymmetric(root.left, root.right);
    }

    private boolean isTreeSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null) // one of the two trees is null
            return false;
        return root1.val == root2.val && isTreeSymmetric(root1.left, root2.right)
                && isTreeSymmetric(root1.right, root2.left);
    }
}
