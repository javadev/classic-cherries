package org.paukov.exercise.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dpaukov on 5/21/18.
 *
 * 54. Spiral Matrix (Medium).
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in
 * spiral order.
 *
 * Example 1:
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();

    if (matrix.length == 0) {
      return result;
    }

    int r1 = 0;
    int r2 = matrix.length - 1;

    int k1 = 0;
    int k2 = matrix[0].length - 1;

    while (r1 <= r2 && k1 <= k2) {
      int i = r1;
      int j = k1;

      for (; j <= k2; j++) {
        result.add(matrix[i][j]);
      }
      j = k2;
      i++;
      for (; i <= r2; i++) {
        result.add(matrix[i][j]);
      }

      if (r1 < r2 && k1 < k2) {
        i = r2;
        j--;
        for (; j >= k1; j--) {
          result.add(matrix[i][j]);
        }
        j = k1;
        i--;
        for (; i >= r1 + 1; i--) {
          result.add(matrix[i][j]);
        }
      }
      k1++;
      k2--;
      r1++;
      r2--;
    }

    return result;
  }
}
