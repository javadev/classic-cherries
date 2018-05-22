package org.paukov.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by dpaukov on 3/10/18.
 * <p>
 * Given four digits, find the maximum valid time that can be displayed on
 * a digital clock (in 24 -hour format) using those digits. for example,
 * given digits 2,3,5,9 the maximum valid time is "23:59". note that "24:39"
 * is not a valid time.
 */
public class MaxPossibleTime extends Backtracking<Integer, List<Integer>> {

  private long count = 0;
  private long maxCount = 0;
  private Integer[] max = new Integer[]{0, 0, 0, 0, 0};

  public static String calc(List<Integer> input) {
    MaxPossibleTime possibleTime = new MaxPossibleTime();
    possibleTime.run(new Integer[5], 0, input);
    if (possibleTime.maxCount > 0) {
      return String.format("%d%d:%d%d",
          possibleTime.max[1], possibleTime.max[2], possibleTime.max[3], possibleTime.max[4]);
    }
    return null;
  }

  public static void main(String[] args) {
    MaxPossibleTime.calc(Arrays.asList(1, 9, 2, 5));
  }

  boolean isTime(Integer[] vector, int k) {
    if (k != 4) {
      return false;
    }
    if (vector[1] == 1 &&
        vector[2] >= 0 && vector[2] <= 9 &&
        vector[3] >= 0 && vector[3] <= 5 &&
        vector[4] >= 0 && vector[4] <= 9) {
      return true;
    }
    return vector[1] == 2 &&
        vector[2] >= 0 && vector[2] <= 3 &&
        vector[3] >= 0 && vector[3] <= 5 &&
        vector[4] >= 0 && vector[4] <= 9;
  }

  int compareTime(Integer[] vector1, Integer[] vector2) {
    int diff1 = vector1[1] - vector2[1];
    int diff2 = vector1[2] - vector2[2];
    int diff3 = vector1[3] - vector2[3];
    int diff4 = vector1[4] - vector2[4];
    return diff1 * 600 + diff2 * 60 + diff3 * 10 + diff4;
  }

  protected boolean isSolution(Integer[] vector, int k, List<Integer> dataInput) {
    return k == 4;
  }

  protected void processSolution(Integer[] vector, int k, List<Integer> dataInput) {
    if (isTime(vector, k)) {
      count++;
      if (compareTime(max, vector) < 0) {
        maxCount++;
        max[1] = vector[1];
        max[2] = vector[2];
        max[3] = vector[3];
        max[4] = vector[4];
      }
      System.out.printf("%4d - %d%d:%d%d, max=%d%d:%d%d\n", count, vector[1], vector[2], vector[3],
          vector[4],
          max[1], max[2], max[3], max[4]);
    }
  }

  protected List<Integer> constructCandidates(Integer[] vector, int k, List<Integer> dataInput) {
    ArrayList<Integer> candidates = new ArrayList<Integer>(dataInput);
    for (int i = 1; i <= k; i++) {
      if (candidates.contains(vector[i])) {
        candidates.remove(vector[i]);
      }
    }
    return candidates;
  }
}
