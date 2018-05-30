package org.paukov.exercise.array;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;
import org.junit.Test;

/**
 * Created by dpaukov on 5/29/18.
 */
public class SpiralMatrixTest {

  @Test
  public void spiralOrder_3x3() throws Exception {
    List<Integer> spiralList = SpiralMatrix.spiralOrder(new int[][]{
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    });
    assertThat(spiralList).containsExactly(1, 2, 3, 6, 9, 8, 7, 4, 5);
  }

  @Test
  public void spiralOrder_3x4() throws Exception {
    List<Integer> spiralList = SpiralMatrix.spiralOrder(new int[][]{
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12}
    });
    assertThat(spiralList).containsExactly(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
  }

  @Test
  public void spiralOrder_2x1() throws Exception {
    List<Integer> spiralList = SpiralMatrix.spiralOrder(new int[][]{
        {1},
        {5}
    });
    assertThat(spiralList).containsExactly(1, 5);
  }

  @Test
  public void spiralOrder_one() throws Exception {
    List<Integer> spiralList = SpiralMatrix.spiralOrder(new int[][]{
        {1}
    });
    assertThat(spiralList).containsExactly(1);
  }

  @Test
  public void spiralOrder_empty() throws Exception {
    List<Integer> spiralList = SpiralMatrix.spiralOrder(new int[][]{
        {}
    });
    assertThat(spiralList).isEmpty();
  }

}