package org.paukov.knapsack;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Arrays;
import org.junit.Test;

/**
 * Created by dpaukov on 4/3/18.
 */
public class PartitionProblemTest {

  @Test
  public void calculate() {
    assertThat(PartitionProblem.calculate(new Integer[]{3, 1, 1, 2, 2, 1}))
        .containsExactly(Arrays.asList(1, 1, 3), Arrays.asList(2, 2, 1));

    assertThat(PartitionProblem.calculate(new Integer[]{3, 10, 1, 2, 2, 1, 4, 5}))
        .containsExactly(Arrays.asList(1, 10, 3), Arrays.asList(2, 2, 1, 4, 5));

    assertThat(PartitionProblem.calculate(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}))
        .containsExactly(Arrays.asList(6, 5, 4, 2, 1), Arrays.asList(3, 7, 8));

    assertThat(PartitionProblem.calculate(new Integer[]{1, 20, 18, 2, 30, 10, 15, 15, 4}))
        .containsExactly(Arrays.asList(15, 10, 30, 2), Arrays.asList(1, 20, 18, 15, 4));
  }

  @Test
  public void calculate_no_partition() {
    assertThat(PartitionProblem.calculate(new Integer[]{1, 1, 5})).isNull();
  }

}