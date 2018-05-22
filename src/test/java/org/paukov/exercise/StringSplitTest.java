package org.paukov.exercise;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;
import org.junit.Test;

/**
 * Created by dpaukov on 2/18/18.
 */
public class StringSplitTest {

  @Test
  public void test_split_01() {
    StringSplit stringSplit = new StringSplit(' ');
    List<String> words = stringSplit.split("hello world");
    assertThat(words).containsExactly("hello", "world");
  }

  @Test
  public void test_split_02() {
    StringSplit stringSplit = new StringSplit(' ');
    List<String> words = stringSplit.split("   hello   world   ");
    assertThat(words).containsExactly("hello", "world");
  }

  @Test
  public void test_split_03() {
    StringSplit stringSplit = new StringSplit(' ');
    List<String> words = stringSplit.split("a   hello 3  world   4");
    assertThat(words).containsExactly("a", "hello", "3", "world", "4");
  }

  @Test
  public void test_split_04() {
    StringSplit stringSplit = new StringSplit(' ');
    List<String> words = stringSplit.split("a b");
    assertThat(words).containsExactly("a", "b");
  }

  @Test
  public void test_split_05() {
    StringSplit stringSplit = new StringSplit(' ');
    List<String> words = stringSplit.split("        ");
    assertThat(words).isEmpty();
  }

  @Test
  public void test_split_06() {
    StringSplit stringSplit = new StringSplit(' ');
    List<String> words = stringSplit.split("");
    assertThat(words).isEmpty();
  }
}
