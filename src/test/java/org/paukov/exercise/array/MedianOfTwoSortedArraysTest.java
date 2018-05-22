package org.paukov.exercise.array;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;


/**
 * Created by dpaukov on 4/26/18.
 */
public class MedianOfTwoSortedArraysTest {

  @Test
  public void findMedianSortedArrays_01() throws Exception {
    int[] array1 = new int[]{1, 3, 5, 6, 7, 9};
    int[] array2 = new int[]{2, 4, 6, 23, 45};

    double median = MedianOfTwoSortedArrays.findMedianSortedArrays(array1, array2);

    assertThat(median).isEqualTo(6.0);
  }

  @Test
  public void findMedianSortedArrays_02() throws Exception {
    int[] array1 = new int[]{1, 3, 5, 6, 7, 9};
    int[] array2 = new int[]{2, 4, 6, 23, 45, 50};

    double median = MedianOfTwoSortedArrays.findMedianSortedArrays(array1, array2);

    assertThat(median).isEqualTo(6.0);
  }

  @Test
  @Ignore
  public void findMedianSortedArrays_03() throws Exception {
    int[] array1 = new int[]{1, 3};
    int[] array2 = new int[]{2};

    double median = MedianOfTwoSortedArrays.findMedianSortedArrays(array1, array2);

    assertThat(median).isEqualTo(2.0);
  }

  @Test
  @Ignore
  public void findMedianSortedArrays_04() throws Exception {
    int[] array1 = new int[]{1, 2};
    int[] array2 = new int[]{3, 4};

    double median = MedianOfTwoSortedArrays.findMedianSortedArrays(array1, array2);

    assertThat(median).isEqualTo(2.5);
  }

}