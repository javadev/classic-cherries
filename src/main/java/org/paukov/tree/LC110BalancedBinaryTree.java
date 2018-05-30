package org.paukov.tree;


/**
 * Created by dpaukov on 5/30/18.
 *
 * 110. Balanced Binary Tree (Easy)
 * https://leetcode.com/problems/balanced-binary-tree/description/
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 * <pre>
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 * </pre>
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 * <pre>
 *       1
 *      / \
 *     2   2
 *    / \
 *   3   3
 *  / \
 * 4   4
 * </pre>
 * Return false.
 */
public class LC110BalancedBinaryTree {

  int depth(TreeNode node) {
    if (node == null) {
      return 0;
    }

    if (node.left == null) {
      return 1 + depth(node.right);
    }
    if (node.right == null) {
      return 1 + depth(node.left);
    }

    return 1 + Math.max(depth(node.left), depth(node.right));
  }

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    int l = depth(root.left);
    int r = depth(root.right);
    if (Math.abs(l - r) > 1) {
      return false;
    } else {
      return isBalanced(root.left) && isBalanced(root.right);
    }
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
