package org.paukov.editdistance;

import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.*;

/**
 * Created by dpaukov on 3/23/18.
 */
public class LongestCommonSubsequenceTest {

    @Test
    public void calculate_democrat_republican() throws Exception {
        String source = "democrat";
        String target = "republican";
        LongestCommonSubsequence lcs = new LongestCommonSubsequence(source, target);

        String lcsStr = lcs.calculate();

        assertThat(lcsStr).isEqualTo("eca");
    }

}