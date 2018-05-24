package org.paukov.exercise.array;

import java.util.Arrays;

/**
 * Created by dpaukov on 5/23/18.
 *
 * 59. Spiral Matrix II.
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 *
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral
 * order.
 *
 * Example:
 *
 * Input: 3 Output: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 */
public class SpiralMatrix2 {

  static int[][] generateMatrix(int n) {
    int[][] arr = new int[n][n];
    int count = 1;
    int r1 = 0;
    int r2 = n - 1;
    int k1 = 0;
    int k2 = n - 1;
    while (r1 <= r2 && k1 <= k2) {
      int i = r1;
      int j = k1;
      for (; j <= k2; j++) {
        arr[i][j] = count++;
      }
      j = k2;
      i++;
      for (; i <= r2; i++) {
        arr[i][j] = count++;
      }
      if (r1 < r2 && k1 < k2) {
        i = r2;
        j--;
        for (; j >= k1; j--) {
          arr[i][j] = count++;
        }
        j = k1;
        i--;
        for (; i >= r1 + 1; i--) {
          arr[i][j] = count++;
        }
      }
      r1++;
      r2--;
      k1++;
      k2--;
    }
    return arr;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.deepToString(generateMatrix(1)));
    System.out.println(Arrays.deepToString(generateMatrix(2)));
    System.out.println(Arrays.deepToString(generateMatrix(3)));
    System.out.println(Arrays.deepToString(generateMatrix(5)));
  }

}
