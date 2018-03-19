package org.paukov.exercise.hashtable;

import org.junit.Test;

import java.util.Arrays;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by dpaukov on 3/19/18.
 */
public class GroupAnagramsTest {
    @Test
    public void groupAnagrams() throws Exception {
        assertThat(GroupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}))
                .containsOnly(
                        Arrays.asList("eat", "tea", "ate"),
                        Arrays.asList("tan", "nat"),
                        Arrays.asList("bat"));
    }
}