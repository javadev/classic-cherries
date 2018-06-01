package org.paukov.exercise.tree;

/**
 * Created by dpaukov on 5/30/18.
 *
 * 104. Maximum Depth of Binary Tree (Easy).
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the
 * farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 * <pre>
 *       3
 *      / \
 *     9  20
 *       /  \
 *      15   7
 * </pre>
 * return its depth = 3.
 */
public class LC104MaximumDepthOfBinaryTree {

  int depth(TreeNode node) {
    if (node == null) {
      return 0;
    } else {
      if (node.left == null) {
        return 1 + depth(node.right);
      }
      if (node.right == null) {
        return 1 + depth(node.left);
      }
      return 1 + Math.max(depth(node.left), depth(node.right));
    }
  }

  public int maxDepth(TreeNode root) {
    return depth(root);
  }

  // Definition for a binary tree node.
  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
