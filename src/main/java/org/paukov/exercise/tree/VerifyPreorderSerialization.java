package org.paukov.exercise.tree;

import java.util.Objects;

/**
 * Created by dpaukov on 5/18/18.
 * <p>
 * 331. Verify Preorder Serialization of a Binary Tree
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/description/
 * <p>
 * <p>
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node,
 * we record the node's value. If it is a null node, we record using a sentinel value such as #.
 * <p>
 * <pre>
 *      _9_
 *     /    \
 *    3      2
 *   / \    / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * </pre>
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#",
 * where # represents a null node.
 * <p>
 * Given a string of comma separated values, verify whether it is a correct preorder traversal
 * serialization of a binary tree. Find an algorithm without reconstructing the tree.
 * <p>
 * Each comma separated value in the string must be either an integer or a character '#'
 * representing null pointer.
 * <p>
 * You may assume that the input format is always valid, for example it could never contain two
 * consecutive commas such as "1,,3".
 * <p>
 * Example 1: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Return true
 * <p>
 * Example 2: "1,#"
 * Return false
 * <p>
 * Example 3: "9,#,#,1"
 * Return false
 */
public class VerifyPreorderSerialization {

    /**
     * Parses the string and returns the size of the valid tree or -1 if the tree is not valid
     */
    static int isValidNode(String[] preorder, int index) {
        String root = preorder[index];

        if (!Objects.equals(root, "#")) {
            // right tree
            int rSize = 1;

            if (index + rSize >= preorder.length) {
                return -1;
            }

            String right = preorder[index + rSize];
            if (!Objects.equals(right, "#")) {
                rSize = isValidNode(preorder, index + rSize);
            }

            if (rSize == -1) {
                return -1;
            }

            // left tree
            int lSize = 1;

            if (index + rSize + lSize >= preorder.length) {
                return -1;
            }

            String left = preorder[index + rSize + lSize];
            if (!Objects.equals(left, "#")) {
                lSize = isValidNode(preorder, index + rSize + lSize);
            }

            if (lSize == -1) {
                return -1;
            }

            return 1 + rSize + lSize;
        }
        if (index == preorder.length - 1) {
            return 1; // size of this node '#'
        }

        return -1;
    }


    public static boolean isValidSerialization(String preorder) {

        String[] array = preorder.split(",");

        int root = isValidNode(array, 0);
        if (root == -1) {
            return false;
        }

        return root == array.length;
    }

    public static void main(String[] args) {
        System.out.println(VerifyPreorderSerialization.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#")); // true
        System.out.println(VerifyPreorderSerialization.isValidSerialization("9,3,4,#,#,1,#,#,2,#,#,#,#")); // false
        System.out.println(VerifyPreorderSerialization.isValidSerialization("1,#")); // false
        System.out.println(VerifyPreorderSerialization.isValidSerialization("9,#,#,1")); // false
        System.out.println(VerifyPreorderSerialization.isValidSerialization("#")); //true
    }
}
