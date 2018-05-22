package org.paukov.backtracking;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;


/**
 * Created by dpaukov on 3/31/18.
 */
public class SearchSequenceIn2DArrayTest {

  @Test
  public void calculate_1346() throws Exception {
    int[][] matrix = new int[][]{{1, 2, 3}, {3, 4, 5}, {5, 6, 7}};
    int[] pattern = new int[]{1, 3, 4, 6};
    SearchSequenceIn2DArray.Cell[] result = SearchSequenceIn2DArray.calculate(matrix, pattern);
    assertThat(result).containsOnly(null, cell(0, 0), cell(1, 0), cell(1, 1), cell(2, 1));
  }


  @Test
  public void calculate_13453() throws Exception {
    int[][] matrix = new int[][]{{1, 2, 3}, {3, 4, 5}, {5, 6, 7}};
    int[] pattern = new int[]{1, 3, 4, 6, 5, 3};
    SearchSequenceIn2DArray.Cell[] result = SearchSequenceIn2DArray.calculate(matrix, pattern);
    assertThat(result)
        .containsOnly(null, cell(0, 0), cell(1, 0), cell(1, 1), cell(2, 1), cell(2, 0), cell(1, 0));
  }

  @Test
  public void calculate_111() throws Exception {
    int[][] matrix = new int[][]{{1, 2, 3}, {3, 4, 5}, {5, 6, 7}};
    int[] pattern = new int[]{1, 1, 1};
    SearchSequenceIn2DArray.Cell[] result = SearchSequenceIn2DArray.calculate(matrix, pattern);
    assertThat(result).containsOnly(null, cell(0, 0), cell(0, 0), cell(0, 0));
  }

  @Test
  public void calculate_no_pattern() throws Exception {
    int[][] matrix = new int[][]{{1, 2, 3}, {3, 4, 5}, {5, 6, 7}};
    int[] pattern = new int[]{1, 2, 3, 4};
    SearchSequenceIn2DArray.Cell[] result = SearchSequenceIn2DArray.calculate(matrix, pattern);
    assertThat(result).isEmpty();
  }

  @Test
  public void calculate_empty_matrix() throws Exception {
    int[][] matrix = new int[][]{{}};
    int[] pattern = new int[]{1, 1, 1};
    SearchSequenceIn2DArray.Cell[] result = SearchSequenceIn2DArray.calculate(matrix, pattern);
    assertThat(result).isEmpty();
  }

  @Test
  public void calculate_empty_pattern() throws Exception {
    int[][] matrix = new int[][]{{1, 2, 3}, {3, 4, 5}, {5, 6, 7}};
    int[] pattern = new int[]{};
    SearchSequenceIn2DArray.Cell[] result = SearchSequenceIn2DArray.calculate(matrix, pattern);
    assertThat(result).isEmpty();
  }

  @Test
  public void calculate_empty_pattern_empty_matrix() throws Exception {
    int[][] matrix = new int[][]{{}};
    int[] pattern = new int[]{};
    SearchSequenceIn2DArray.Cell[] result = SearchSequenceIn2DArray.calculate(matrix, pattern);
    assertThat(result).isEmpty();
  }

  SearchSequenceIn2DArray.Cell cell(int i, int j) {
    return new SearchSequenceIn2DArray.Cell(i, j);
  }

}