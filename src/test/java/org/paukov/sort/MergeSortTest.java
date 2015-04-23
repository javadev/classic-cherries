package org.paukov.sort;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by dpaukov
 */
public class MergeSortTest {

    @Test
    public void test_merge_sort() {
        MergeSort mergeSort = new MergeSort();
        int[] array = new int[]{5,2,4,6,1,3,2,6};
        mergeSort.mergeSort(array);
        assertThat(array).contains(1,2,2,3,4,5,6,6);
    }
}
