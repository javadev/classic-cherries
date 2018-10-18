package org.paukov.backtracking;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Set;
import org.junit.Test;

/**
 * Created by dpaukov on 3/15/18.
 */
public class LC301_RemoveInvalidParenthesesTest {

  @Test
  public void calc_01() throws Exception {
    Set<String> solutions = LC301_RemoveInvalidParentheses.calc("()())()");
    assertThat(solutions).contains("()()()", "(())()");
  }

  @Test
  public void calc_02() throws Exception {
    Set<String> solutions = LC301_RemoveInvalidParentheses.calc("(a)())()");
    assertThat(solutions).contains("(a)()()", "(a())()");
  }

  @Test
  public void calc_03() throws Exception {
    Set<String> solutions = LC301_RemoveInvalidParentheses.calc(")(");
    assertThat(solutions).contains("");
  }
}