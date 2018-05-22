package org.paukov.exercise.array;

/**
 * Created by dpaukov on 5/21/18.
 *
 * 718. Maximum Length of Repeated Subarray (Medium).
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
 *
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both
 * arrays.
 *
 * Example 1: Input: A: [1,2,3,2,1] B: [3,2,1,4,7] Output: 3 Explanation: The repeated subarray with
 * maximum length is [3, 2, 1].
 */
public class MaximumLengthOfRepeatedSubarray {

  // Same idea as for the Longest Common Substring Problem.
  static int findLength(int[] A, int[] B) {
    int max = 0;
    int[][] dp = new int[A.length][B.length];

    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < B.length; j++) {
        if (A[i] == B[j]) {
          if (i == 0 || j == 0) {
            dp[i][j] = 1;
          } else {
            dp[i][j] = dp[i - 1][j - 1] + 1;
          }
          if (dp[i][j] > max) {
            max = dp[i][j];
          }
        } else {
          dp[i][j] = 0;
        }
      }
    }

    return max;
  }

  public static void main(String[] args) {
    System.out.println("Result: " + findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
  }
}
