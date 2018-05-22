package org.paukov.sort;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

/**
 * Created by dima on 4/21/15.
 */
public class QuickSortTest {

  @Test
  public void test_quick_sort() {
    QuickSort quickSort = new QuickSort();
    int[] array = new int[]{5, 2, 4, 6, 1, 3, 2, 6};
    quickSort.quickSort(array);
    assertThat(array).contains(1, 2, 2, 3, 4, 5, 6, 6);
  }

  @Test
  public void test_quick_sort_with_empty_array() {
    QuickSort quickSort = new QuickSort();
    int[] array = new int[]{};
    quickSort.quickSort(array);
    assertThat(array).hasSize(0);
  }

  @Test
  public void test_quick_sort_with_one_element() {
    QuickSort quickSort = new QuickSort();
    int[] array = new int[]{5};
    quickSort.quickSort(array);
    assertThat(array).contains(5);
  }
}
