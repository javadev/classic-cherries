package org.paukov.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dpaukov on 3/5/18.
 * A child is running up the stairs and can take 1, 2 or 3 steps at a time.
 * Count how many possible ways the child can run up the stairs.
 */
public class ChildAndStaircase extends Backtracking<Integer, Integer> {

  private Integer count = 0;

  public static void main(String[] args) {
    ChildAndStaircase childAndStaircase = new ChildAndStaircase();
    Integer[] vector = new Integer[7];
    vector[0] = 0;
    childAndStaircase.run(vector, 0, 6);
  }

  private Integer sum(Integer[] vector, int k) {
    Integer sum = 0;
    for (int i = 1; i <= k; i++) {
      sum += vector[i];
    }
    return sum;
  }

  protected boolean isSolution(Integer[] vector, int k, Integer dataInput) {
    Integer s = sum(vector, k);
    return s.equals(dataInput);
  }

  protected void processSolution(Integer[] vector, int k, Integer dataInput) {
    count++;
    System.out.printf("%4d: ", count);
    for (int i = 1; i <= k; i++) {
      System.out.print(vector[i]);
    }
    System.out.printf(" = %d", sum(vector, k));
    System.out.println();
  }

  protected List<Integer> constructCandidates(Integer[] vector, int k, Integer dataInput) {
    List<Integer> candidates = new ArrayList<Integer>();
    Integer s = sum(vector, k);
    if ((dataInput - s) >= 1) {
      candidates.add(1);
    }
    if ((dataInput - s) >= 2) {
      candidates.add(2);
    }
    if ((dataInput - s) >= 3) {
      candidates.add(3);
    }
    return candidates;
  }
}
