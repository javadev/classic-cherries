package org.paukov.exercise.linkedlist;

/**
 * Created by dpaukov on 4/25/18.
 * <p>
 * 2. Add Two Numbers
 * <p>
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * <p>
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode s1 = l1, s2 = l2;
    int rem = 0;
    ListNode root = null;
    ListNode node = null;

    while (s1 != null || s2 != null || rem != 0) {

      int s1Value = 0;
      if (s1 != null) {
        s1Value = s1.val;
      }

      int s2Value = 0;
      if (s2 != null) {
        s2Value = s2.val;
      }

      int value = s1Value + s2Value + rem;

      if (value >= 10) {
        value = value - 10;
        rem = 1;
      } else {
        rem = 0;
      }

      if (root == null) {
        root = new ListNode(value);
        node = root;
      } else {
        node.next = new ListNode(value);
        node = node.next;
      }

      if (s1 != null) {
        s1 = s1.next;
      } else {
        s1 = null;
      }

      if (s2 != null) {
        s2 = s2.next;
      } else {
        s2 = null;
      }
    }
    return root;
  }

  //Definition for singly-linked list.
  public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

}
