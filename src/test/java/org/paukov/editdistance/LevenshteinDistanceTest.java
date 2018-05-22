package org.paukov.editdistance;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

/**
 * Created by dpaukov on 3/22/18.
 */
public class LevenshteinDistanceTest {

  @Test
  public void calculate_thou_shalt_not() throws Exception {
    assertThat(LevenshteinDistance.calculate("thou shalt not", "you should not")).isEqualTo(5);
  }

  @Test
  public void calculate_hello_heklo() throws Exception {
    assertThat(LevenshteinDistance.calculate("hello", "heklo")).isEqualTo(1);
  }

  @Test
  public void calculate_empty() throws Exception {
    assertThat(LevenshteinDistance.calculate("", "")).isEqualTo(0);
    assertThat(LevenshteinDistance.calculate("source", "")).isEqualTo(6);
    assertThat(LevenshteinDistance.calculate("", "target")).isEqualTo(6);
  }

  @Test
  public void calculate_hello_alax() throws Exception {
    assertThat(LevenshteinDistance.calculate("hello", "alax")).isEqualTo(4);
  }

}