package org.paukov.exercise.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dpaukov on 5/31/18.
 *
 * 234. Palindrome Linked List (Easy).
 * https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class LC234PalindromeLinkedList {

  // Time Complexity O(n), Memory O(n)
  // Other interesting solution
  // https://leetcode.com/problems/palindrome-linked-list/discuss/64501/Java-easy-to-understand
  public boolean isPalindrome(ListNode head) {
    List<Integer> a = new ArrayList<>();
    ListNode p = head;
    while (p != null) {
      a.add(p.val);
      p = p.next;
    }
    for (int i = 0; i < a.size() / 2; i++) {
      if (!a.get(i).equals(a.get(a.size() - i - 1))) {
        return false;
      }
    }
    return true;
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
