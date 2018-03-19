package org.paukov.exercise.bits;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by dpaukov on 3/19/18.
 */
public class HammingDistanceTest {

    @Test
    public void hammingDistance() throws Exception {
        assertThat(HammingDistance.hammingDistance(2, 4)).isEqualTo(2);
        assertThat(HammingDistance.hammingDistance(7, 8)).isEqualTo(4);
        assertThat(HammingDistance.hammingDistance(63, 0)).isEqualTo(6);
    }

}