package org.paukov.exercise.tree;

/**
 * Created by dpaukov on 5/21/18.
 * <p>
 * 654. Maximum Binary Tree
 * https://leetcode.com/problems/maximum-binary-tree/description/
 * <p>
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 * <p>
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 * <p>
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 * <pre>
 *     6
 *   /   \
 *  3     5
 *  \    /
 *  2  0
 *   \
 *   1
 * </pre>
 */
public class MaximumBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Recursive solution, O(n^2) in the worst case.
     * Can try to improve by using max-heap for searching max value in each subarray.
     */
    TreeNode constructTree(int[] arr, int lo, int hi) {
        if (lo == hi) {
            return new TreeNode(arr[lo]);
        } else if (lo > hi) {
            return null;
        }

        int max = arr[lo];
        int max_i = lo;

        for (int i = lo + 1; i <= hi; i++) {
            if (arr[i] > max) {
                max = arr[i];
                max_i = i;
            }
        }

        TreeNode node = new TreeNode(max);
        node.left = constructTree(arr, lo, max_i - 1);
        node.right = constructTree(arr, max_i + 1, hi);
        return node;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructTree(nums, 0, nums.length - 1);
    }
}
