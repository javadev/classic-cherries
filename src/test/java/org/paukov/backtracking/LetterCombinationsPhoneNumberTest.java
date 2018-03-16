package org.paukov.backtracking;

import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by dpaukov on 3/13/18.
 */
public class LetterCombinationsPhoneNumberTest {

    @Test
    public void calc_23() throws Exception {
        List<String> combinations = LetterCombinationsPhoneNumber.calc("23");
        assertThat(combinations).containsExactly("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
    }

    @Test
    public void calc_empty() throws Exception {
        List<String> combinations = LetterCombinationsPhoneNumber.calc("");
        assertThat(combinations).isEmpty();
    }

    @Test
    public void calc_no_digit_number() throws Exception {
        List<String> combinations = LetterCombinationsPhoneNumber.calc("ab");
        assertThat(combinations).isEmpty();
    }

}