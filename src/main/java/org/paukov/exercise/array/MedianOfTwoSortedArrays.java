package org.paukov.exercise.array;

/**
 * Created by dpaukov on 4/26/18.
 * <p>
 * 4. Median of Two Sorted Arrays
 * <p>
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 *
 * TODO: Idea is to partition the arrays into 2 halves with the same number of items.
 */
public class MedianOfTwoSortedArrays {

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int m = nums2.length;

    boolean isOdd = ((n + m) % 2 == 1);
    int expected_left_partition_size = (n + m) / 2;

    if (isOdd) {
      expected_left_partition_size++;
    }

    int left1 = n / 2 - 1;
    int left2 = expected_left_partition_size - left1 - 1;

    while (!isCorrectPartition(nums1, left1, nums2, left2)) {
      if (left1 >= 0 && (left2 + 1 < nums2.length) && nums1[left1] > nums2[left2 + 1]) {
        // we should move left for num1
        left1--;
      } else if (nums2[left2] > nums1[left1 + 1]) {
        // we should move right to num1
        left1++;
      }
      left2 = expected_left_partition_size - left1 - 1;
    }

    int l1, l2, r1, r2;
    if (left1 < 0) {
      l1 = -Integer.MAX_VALUE;
    } else {
      l1 = nums1[left1];
    }
    if (left2 < 0) {
      l2 = -Integer.MAX_VALUE;
    } else {
      l2 = nums2[left2];
    }
    if (left1 + 1 >= nums1.length) {
      r1 = Integer.MAX_VALUE;
    } else {
      r1 = nums1[left1 + 1];
    }
    if (left2 + 1 >= nums2.length) {
      r2 = Integer.MAX_VALUE;
    } else {
      r2 = nums2[left2 + 1];
    }

    if (isOdd) {
      return Math.max(l1, l2);
    } else {
      return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
    }
  }

  static boolean isCorrectPartition(int[] nums1, int left1, int[] nums2, int left2) {

    int l1, l2, r1, r2;
    if (left1 < 0) {
      l1 = -Integer.MAX_VALUE;
    } else {
      l1 = nums1[left1];
    }
    if (left2 < 0) {
      l2 = -Integer.MAX_VALUE;
    } else {
      l2 = nums2[left2];
    }
    if (left1 + 1 >= nums1.length) {
      r1 = Integer.MAX_VALUE;
    } else {
      r1 = nums1[left1 + 1];
    }
    if (left2 + 1 >= nums2.length) {
      r2 = Integer.MAX_VALUE;
    } else {
      r2 = nums2[left2 + 1];
    }

    return l1 < r2 && l2 < r1;
  }
}
