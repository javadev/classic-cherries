package org.paukov.backtracking;

import org.junit.Test;

import java.util.Arrays;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by dpaukov on 3/10/18.
 */
public class MaxPossibleTimeTest {
    @Test
    public void calc_1925() throws Exception {
        String time = MaxPossibleTime.calc(Arrays.asList(1, 9, 2, 5));
        assertThat(time).isEqualTo("21:59");
    }

    @Test
    public void calc_3925() throws Exception {
        String time = MaxPossibleTime.calc(Arrays.asList(3, 9, 2, 5));
        assertThat(time).isEqualTo("23:59");
    }

    @Test
    public void calc_1277() throws Exception {
        String time = MaxPossibleTime.calc(Arrays.asList(1, 2, 7, 7));
        assertThat(time).isEqualTo("17:27");
    }

    @Test
    public void calc_3277() throws Exception {
        String time = MaxPossibleTime.calc(Arrays.asList(3, 2, 7, 7));
        assertThat(time).isNull();
    }
}