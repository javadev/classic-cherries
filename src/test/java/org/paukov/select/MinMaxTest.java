package org.paukov.select;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

/**
 * Created by dima on 3/26/16.
 */
public class MinMaxTest {

  @Test
  public void test_find_min_max_sorted_array_6() {
    int[] array = new int[]{1, 2, 3, 4, 5, 6};
    MinMax minmax = MinMax.findMinMax(array, 0, array.length - 1);
    assertThat(minmax.min).isEqualTo(1);
    assertThat(minmax.max).isEqualTo(6);
    assertThat(minmax.comparisons).isEqualTo(3 * 3 - 2);
  }

  @Test
  public void test_find_min_max_unsorted_array_6() {
    int[] array = new int[]{3, 4, 2, 5, 1, 6};
    MinMax minmax = MinMax.findMinMax(array, 0, array.length - 1);
    assertThat(minmax.min).isEqualTo(1);
    assertThat(minmax.max).isEqualTo(6);
    assertThat(minmax.comparisons).isEqualTo(3 * 3 - 2);
  }

  @Test
  public void test_find_min_max_sorted_array_7() {
    int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
    MinMax minmax = MinMax.findMinMax(array, 0, array.length - 1);
    assertThat(minmax.min).isEqualTo(1);
    assertThat(minmax.max).isEqualTo(7);
    assertThat(minmax.comparisons).isEqualTo(3 * 4 - 2);
  }

  @Test
  public void test_find_min_max_unsorted_array_7() {
    int[] array = new int[]{3, 4, 2, 7, 5, 1, 6,};
    MinMax minmax = MinMax.findMinMax(array, 0, array.length - 1);
    assertThat(minmax.min).isEqualTo(1);
    assertThat(minmax.max).isEqualTo(7);
    assertThat(minmax.comparisons).isEqualTo(3 * 4 - 2);
  }

  @Test
  public void test_find_min_max_sorted_array_3() {
    int[] array = new int[]{3, 2, 1};
    MinMax minmax = MinMax.findMinMax(array, 0, array.length - 1);
    assertThat(minmax.min).isEqualTo(1);
    assertThat(minmax.max).isEqualTo(3);
    assertThat(minmax.comparisons).isEqualTo(3 * 2 - 2);
  }

  @Test
  public void test_find_min_max_unsorted_array_3() {
    int[] array = new int[]{6, 2, 7};
    MinMax minmax = MinMax.findMinMax(array, 0, array.length - 1);
    assertThat(minmax.min).isEqualTo(2);
    assertThat(minmax.max).isEqualTo(7);
    assertThat(minmax.comparisons).isEqualTo(3 * 2 - 2);
  }

  @Test
  public void test_find_min_max_sorted_array_2_0() {
    int[] array = new int[]{2, 1};
    MinMax minmax = MinMax.findMinMax(array, 0, array.length - 1);
    assertThat(minmax.min).isEqualTo(1);
    assertThat(minmax.max).isEqualTo(2);
    assertThat(minmax.comparisons).isEqualTo(3 * 1 - 2);
  }

  @Test
  public void test_find_min_max_sorted_array_2_1() {
    int[] array = new int[]{1, 2};
    MinMax minmax = MinMax.findMinMax(array, 0, array.length - 1);
    assertThat(minmax.min).isEqualTo(1);
    assertThat(minmax.max).isEqualTo(2);
    assertThat(minmax.comparisons).isEqualTo(3 * 1 - 2);
  }
}
