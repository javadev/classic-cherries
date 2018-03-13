package org.paukov.backtracking;

import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by dpaukov on 3/10/18.
 */
public class GenerateParenthesesTest {
    @Test
    public void calc_3() throws Exception {
        List<String> result = GenerateParentheses.calc(3);
        assertThat(result).containsExactly("((()))", "(()())", "(())()", "()(())", "()()()");
    }

    @Test
    public void calc_2() throws Exception {
        List<String> result = GenerateParentheses.calc(2);
        assertThat(result).containsExactly("(())", "()()");
    }

    @Test
    public void calc_1() throws Exception {
        List<String> result = GenerateParentheses.calc(1);
        assertThat(result).containsExactly("()");
    }

    @Test
    public void calc_0() throws Exception {
        List<String> result = GenerateParentheses.calc(0);
        assertThat(result).containsExactly("");
    }

}