package org.paukov.exercise;


import org.junit.Test;

import java.util.*;

import static org.fest.assertions.Assertions.assertThat;

public class MaxPossibleTimeTest {


    @Test
    public void test_time_10(){
        MaxPossibleTime maxPossibleTime = new MaxPossibleTime();
        List<Integer> input = Arrays.asList(3,9,2,5);
        List<Integer> output = maxPossibleTime.calc(input);
        assertThat(output).containsSequence(2,3,5,9);
    }

    @Test
    public void test_time_20(){
        MaxPossibleTime maxPossibleTime = new MaxPossibleTime();
        List<Integer> input = Arrays.asList(1,9,2,5);
        List<Integer> output = maxPossibleTime.calc(input);
        assertThat(output).containsSequence(2,1,5,9);
    }

    @Test
    public void test_time_30(){
        MaxPossibleTime maxPossibleTime = new MaxPossibleTime();
        List<Integer> input = Arrays.asList(1,2,7,7);
        List<Integer> output = maxPossibleTime.calc(input);
        assertThat(output).containsSequence(1,7,2,7);
    }

    @Test
    public void test_time_40(){
        MaxPossibleTime maxPossibleTime = new MaxPossibleTime();
        List<Integer> input = Arrays.asList(3,2,7,7);
        List<Integer> output = maxPossibleTime.calc(input);
        assertThat(output).isNull();
    }
}
