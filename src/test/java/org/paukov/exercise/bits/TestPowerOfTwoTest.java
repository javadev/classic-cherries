package org.paukov.exercise.bits;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by dpaukov on 5/6/18.
 */
public class TestPowerOfTwoTest {

    @Test
    public void isPowerOfTwo_0() throws Exception {
        assertThat(TestPowerOfTwo.isPowerOfTwo(0)).isFalse();
    }

    @Test
    public void isPowerOfTwo_1() throws Exception {
        assertThat(TestPowerOfTwo.isPowerOfTwo(1)).isTrue();
    }

    @Test
    public void isPowerOfTwo_2() throws Exception {
        assertThat(TestPowerOfTwo.isPowerOfTwo(2)).isTrue();
    }

    @Test
    public void isPowerOfTwo_3() throws Exception {
        assertThat(TestPowerOfTwo.isPowerOfTwo(3)).isFalse();
    }

    @Test
    public void isPowerOfTwo_4() throws Exception {
        assertThat(TestPowerOfTwo.isPowerOfTwo(4)).isTrue();
    }


}