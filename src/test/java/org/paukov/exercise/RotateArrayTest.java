package org.paukov.exercise;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

/**
 * Created by dpaukov
 */
public class RotateArrayTest {

  @Test
  public void test_reverse_1() {
    RotateArray rotateArray = new RotateArray();
    int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    rotateArray.reverse(array, 0, 7);
    assertThat(array).isEqualTo(new int[]{8, 7, 6, 5, 4, 3, 2, 1, 9, 10});
  }

  @Test
  public void test_reverse_2() {
    RotateArray rotateArray = new RotateArray();
    int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    rotateArray.reverse(array, 0, 6);
    assertThat(array).isEqualTo(new int[]{7, 6, 5, 4, 3, 2, 1, 8, 9, 10});
  }

  @Test
  public void test_rotate_1() {
    RotateArray rotateArray = new RotateArray();
    int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    rotateArray.rotate(array, 2);
    assertThat(array).isEqualTo(new int[]{10, 11, 1, 2, 3, 4, 5, 6, 7, 8, 9});
  }

  @Test
  public void test_rotate_2() {
    RotateArray rotateArray = new RotateArray();
    int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    rotateArray.rotate(array, 2);
    assertThat(array).isEqualTo(new int[]{9, 10, 1, 2, 3, 4, 5, 6, 7, 8});
  }

  @Test
  public void test_rotate_3() {
    RotateArray rotateArray = new RotateArray();
    int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    rotateArray.rotate(array, 6);
    assertThat(array).isEqualTo(new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3, 4});
  }

  @Test
  public void test_rotate_4() {
    RotateArray rotateArray = new RotateArray();
    int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    rotateArray.rotate(array, 0);
    assertThat(array).isEqualTo(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
  }

  @Test
  public void test_rotate_5() {
    RotateArray rotateArray = new RotateArray();
    int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    rotateArray.rotate(array, -2);
    assertThat(array).isEqualTo(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
  }
}
