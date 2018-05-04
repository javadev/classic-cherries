package org.paukov.exercise.math;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.*;

/**
 * Created by dpaukov on 5/3/18.
 */
public class IntegerToRomanTest {
    @Test
    public void intToRoman_37() throws Exception {
        String str = IntegerToRoman.intToRoman(37);
        assertThat(str).isEqualTo("XXXVII");
    }

    @Test
    public void intToRoman_86() throws Exception {
        String str = IntegerToRoman.intToRoman(86);
        assertThat(str).isEqualTo("LXXXVI");
    }

    @Test
    public void intToRoman_124() throws Exception {
        String str = IntegerToRoman.intToRoman(124);
        assertThat(str).isEqualTo("CXXIV");
    }

    @Test
    public void intToRoman_148() throws Exception {
        String str = IntegerToRoman.intToRoman(148);
        assertThat(str).isEqualTo("CXLVIII");
    }

    @Test
    public void intToRoman_400() throws Exception {
        String str = IntegerToRoman.intToRoman(400);
        assertThat(str).isEqualTo("CD");
    }

}