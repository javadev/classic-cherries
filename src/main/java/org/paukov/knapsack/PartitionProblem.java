package org.paukov.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dpaukov on 4/2/18.
 * <p>
 * Splits an array of integer values into 2 part of the same sum.
 */
public class PartitionProblem {

  public static List<List<Integer>> calculate(Integer[] array) {
    int n = array.length;
    int sum = 0;
    for (Integer value : array) {
      sum += value;
    }
    int k = sum / 2;
    boolean[][] m = new boolean[k + 1][n + 1];

    for (int j = 0; j <= n; j++) {
      m[0][j] = true;
    }

    for (int i = 1; i <= k; i++) {
      for (int j = 1; j <= n; j++) {
        if (i >= array[j - 1]) {
          m[i][j] = m[i][j - 1] || m[i - array[j - 1]][j - 1];
        } else {
          m[i][j] = m[i][j - 1];
        }
      }
    }

    System.out.println(
        "Partition Exists: " + m[k][n] + ", array: " + Arrays.toString(array) + " sum: " + sum);

    if (m[k][n]) {
      List<Integer> firstPartition = new ArrayList<>();
      List<Integer> secondPartition = new ArrayList<>(Arrays.asList(array));

      int r = k;
      int t = n;
      while (r > 0 && t > 0) {
        while (m[r][t]) {
          t--;
        }
        firstPartition.add(array[t]);
        secondPartition.remove(array[t]);
        r = r - array[t];
      }
      return Arrays.asList(firstPartition, secondPartition);
    }
    return null;
  }

  public static void main(String[] args) {
    System.out.println(PartitionProblem.calculate(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}));
  }

}
