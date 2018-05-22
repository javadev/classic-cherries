package org.paukov.editdistance;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;
import org.junit.Test;

/**
 * Created by dpaukov on 3/22/18.
 */
public class CommonSubstringsTest {

  @Test
  public void calculate_hello() throws Exception {
    String source = "abchelloxyz";
    String target = "klmhelloprt";
    CommonSubstrings commonSubstrings = new CommonSubstrings(source, target);

    List<String> list = commonSubstrings.calculate();

    assertThat(list).containsExactly("hello");
  }

  @Test
  public void calculate_identical() throws Exception {
    String source = "hello";
    String target = "hello";
    CommonSubstrings commonSubstrings = new CommonSubstrings(source, target);

    List<String> list = commonSubstrings.calculate();

    assertThat(list).containsExactly("hello");
  }

  @Test
  public void calculate_5_substrings() throws Exception {
    String source = "ABBCADGGHEEASSSCC";
    String target = "ABDCADGGHMEASSSAC";
    CommonSubstrings commonSubstrings = new CommonSubstrings(source, target);

    List<String> list = commonSubstrings.calculate();

    assertThat(list).containsExactly("A", "B", "CADGGH", "EASSS", "C");
  }

  @Test
  public void calculate_empty() throws Exception {
    String source = "";
    String target = "";
    CommonSubstrings commonSubstrings = new CommonSubstrings(source, target);

    List<String> list = commonSubstrings.calculate();

    assertThat(list).isEmpty();
  }

  @Test
  public void calculate_source_empty() throws Exception {
    String source = "";
    String target = "hello";
    CommonSubstrings commonSubstrings = new CommonSubstrings(source, target);

    List<String> list = commonSubstrings.calculate();

    assertThat(list).isEmpty();
  }

  @Test
  public void calculate_target_empty() throws Exception {
    String source = "hello";
    String target = "";
    CommonSubstrings commonSubstrings = new CommonSubstrings(source, target);

    List<String> list = commonSubstrings.calculate();

    assertThat(list).isEmpty();
  }

  @Test
  public void calculate_different() throws Exception {
    String source = "abc";
    String target = "xyz";
    CommonSubstrings commonSubstrings = new CommonSubstrings(source, target);

    List<String> list = commonSubstrings.calculate();

    assertThat(list).isEmpty();
  }

  @Test
  public void calculate_repeated_substrings() throws Exception {
    String source = "hello1hello2hello3";
    String target = "hello";
    CommonSubstrings commonSubstrings = new CommonSubstrings(source, target);

    List<String> list = commonSubstrings.calculate();

    assertThat(list).containsExactly("hello");
  }

}