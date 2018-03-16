package org.paukov.backtracking;

import org.junit.Test;

import java.util.Set;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by dpaukov on 3/15/18.
 */
public class RemoveInvalidParenthesesTest {
    @Test
    public void calc_01() throws Exception {
        Set<String> solutions = RemoveInvalidParentheses.calc("()())()");
        assertThat(solutions).contains("()()()", "(())()");
    }

    @Test
    public void calc_02() throws Exception {
        Set<String> solutions = RemoveInvalidParentheses.calc("(a)())()");
        assertThat(solutions).contains("(a)()()", "(a())()");
    }

    @Test
    public void calc_03() throws Exception {
        Set<String> solutions = RemoveInvalidParentheses.calc(")(");
        assertThat(solutions).contains("");
    }
}