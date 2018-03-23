package org.paukov.editdistance;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;


/**
 * Created by dpaukov on 3/22/18.
 */
public class EditDistanceTest {

    @Test
    public void compare_thou_shalt_not() throws Exception {
        String source = "thou shalt not";
        String target = "you should not";
        EditDistance editDistance = new EditDistance(source, target);

        EditDistance.Matrix matrix = editDistance.compare();

        assertThat(matrix.getEditDistance()).isEqualTo(5);
        assertThat(matrix.getMinEditPathString()).isEqualTo("DSMMMMMISMSMMMM");

    }

    @Test
    public void compare_hello_heklo() throws Exception {
        String source = "hello";
        String target = "heklo";
        EditDistance editDistance = new EditDistance(source, target);

        EditDistance.Matrix matrix = editDistance.compare();

        assertThat(matrix.getEditDistance()).isEqualTo(1);
        assertThat(matrix.getMinEditPathString()).isEqualTo("MMSMM");
    }

    @Test
    public void compare_hello_a2() throws Exception {
        String source = "hello";
        String target = "a2";
        EditDistance editDistance = new EditDistance(source, target);

        EditDistance.Matrix matrix = editDistance.compare();

        assertThat(matrix.getEditDistance()).isEqualTo(5);
        assertThat(matrix.getMinEditPathString()).isEqualTo("DDDSS");
    }

    @Test
    public void compare_hello_alax() throws Exception {
        String source = "hello";
        String target = "alax";
        EditDistance editDistance = new EditDistance(source, target);

        EditDistance.Matrix matrix = editDistance.compare();

        assertThat(matrix.getEditDistance()).isEqualTo(4);
        assertThat(matrix.getMinEditPathString()).isEqualTo("DSMSS");
    }

    @Test
    public void compare_empty() throws Exception {
        EditDistance editDistance = new EditDistance("", "");

        EditDistance.Matrix matrix = editDistance.compare();

        assertThat(matrix.getEditDistance()).isEqualTo(0);
        assertThat(matrix.getMinEditPathString()).isEqualTo("");
    }

    @Test
    public void compare_target_empty() throws Exception {
        EditDistance editDistance = new EditDistance("source", "");

        EditDistance.Matrix matrix = editDistance.compare();

        assertThat(matrix.getEditDistance()).isEqualTo(6);
        assertThat(matrix.getMinEditPathString()).isEqualTo("DDDDDD");
    }

    @Test
    public void compare_source_empty() throws Exception {
        EditDistance editDistance = new EditDistance("", "target");

        EditDistance.Matrix matrix = editDistance.compare();

        assertThat(matrix.getEditDistance()).isEqualTo(6);
        assertThat(matrix.getMinEditPathString()).isEqualTo("IIIIII");
    }


    @Test
    public void compare_source_tranform_without_insert() throws Exception {
        EditDistance editDistance = new EditDistance("s uR e2", "source");

        EditDistance.Matrix matrix = editDistance.compare();

        assertThat(matrix.getEditDistance()).isEqualTo(4);
        assertThat(matrix.getMinEditPathString()).isEqualTo("MSMSSMD");
    }

    @Test
    public void compare_source_tranform_with_insert() throws Exception {
        EditDistance editDistance = new EditDistance("source", "souXrce");

        EditDistance.Matrix matrix = editDistance.compare();

        assertThat(matrix.getEditDistance()).isEqualTo(1);
        assertThat(matrix.getMinEditPathString()).isEqualTo("MMMIMMM");
    }

}