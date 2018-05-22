package org.paukov.exercise.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dpaukov on 5/21/18. 128. Longest Consecutive Sequence (Hard)
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements
 * sequence. Your algorithm should run in O(n) complexity.
 *
 * Example: Input: [100, 4, 200, 1, 3, 2] Output: 4 Explanation: The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class LongestConsecutiveSequence {

  static Set<Integer> find(Set<Set<Integer>> disjoin, Integer value) {
    for (Set<Integer> set : disjoin) {
      if (set.contains(value)) {
        return set;
      }
    }
    return null;
  }

  /**
   * Idea is to use Union-Find methods to construct largest set of the Consecutive Sequence.
   */
  static int longestConsecutive(int[] nums) {
    Set<Set<Integer>> disjoin = new HashSet<Set<Integer>>();

    for (int i = 0; i < nums.length; i++) {
      int value = nums[i];
      Set<Integer> s1 = find(disjoin, value - 1);
      Set<Integer> s2 = find(disjoin, value + 1);

      if (s1 != null) {
        s1.add(value);
      }
      if (s2 != null) {
        s2.add(value);
      }
      if (s1 != null && s2 != null) {
        if (s1 != s2) {
          s1.addAll(s2);
          // Set s2 can't be removed from the disjoin set
          // So update the set s2 as well
          s2.addAll(s1);
          //disjoin.remove(s2);
        }
      }
      if (s1 == null && s2 == null) {
        Set<Integer> s = find(disjoin, value);
        if (s != null) {
          s.add(value);
        } else {
          s = new HashSet<>();
          s.add(value);
          disjoin.add(s);
        }
      }
    }
    int max = 0;
    for (Set<Integer> set : disjoin) {
      if (set.size() > max) {
        max = set.size();
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[] arr1 = new int[]{100, 4, 200, 1, 3, 2, 4, 1, 100};
    int[] arr2 = new int[]{-6, -9, 8, -8, -1, -3, -6, 8, -9, -1, -4, -8, -5, 0, 1, 6, -8, -5, -7, 8,
        -2, -8, 4, 5, -5, -1, -5};
    int[] arr3 = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
    System.out.println("Arr1 (4): " + longestConsecutive(arr1));
    System.out.println("Arr2 (11): " + longestConsecutive(arr2));
    System.out.println("Arr3 (9): " + longestConsecutive(arr3));
  }
}
