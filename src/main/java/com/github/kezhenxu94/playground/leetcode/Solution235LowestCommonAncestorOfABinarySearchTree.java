package com.github.kezhenxu94.playground.leetcode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of
 * two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes v and w as the lowest node in T that has both v
 * and w as descendants (where we allow a node to be a descendant of itself).”
 *
 * <pre>
 *       _______6______
 *      /              \
 *   ___2__          ___8__
 *  /      \        /      \
 *  0      _4       7       9
 *        /  \
 *        3   5
 * </pre>
 *
 * @author ke.zhen.xu
 */
public class Solution235LowestCommonAncestorOfABinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        while (!(max >= root.val && min <= root.val))
            root = root.val < min ? root.right : root.left;
        return root;
    }
}
