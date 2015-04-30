package org.paukov.select;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by dpaukov
 */
public class QuickSelectTest {

    @Test
    public void test_in_sorted_list(){
        QuickSelect quickSelect = new QuickSelect();
        int[] array = new int[]{1,2,3,4,5,6,7};
        Integer value = quickSelect.quickSelect(array, 4);
        assertThat(value).isEqualTo(4);
    }

    @Test
    public void test_unsorted_list(){
        QuickSelect quickSelect = new QuickSelect();
        int[] array = new int[]{2,5,3,6,1,4,7};
        Integer value = quickSelect.quickSelect(array, 4);
        assertThat(value).isEqualTo(4);
    }

    @Test
    public void test_sorted_list_last_element(){
        QuickSelect quickSelect = new QuickSelect();
        int[] array = new int[]{1,2,3,4,5,6,7};
        Integer value = quickSelect.quickSelect(array, 7);
        assertThat(value).isEqualTo(7);
    }

    @Test
    public void test_sorted_list_first_element(){
        QuickSelect quickSelect = new QuickSelect();
        int[] array = new int[]{0,1,2,3,4,5,6,7};
        Integer value = quickSelect.quickSelect(array, 1);
        assertThat(value).isEqualTo(0);
    }

    @Test
    public void test_not_found(){
        QuickSelect quickSelect = new QuickSelect();
        int[] array = new int[]{0,1,2,3,4,5,6,7};
        Integer value = quickSelect.quickSelect(array, 10);
        assertThat(value).isEqualTo(null);
    }

    @Test
    public void test_normal_element(){
        QuickSelect quickSelect = new QuickSelect();
        int[] array = new int[]{0,100,2,3,1,4,5,6,7};
        Integer value = quickSelect.quickSelect(array, 2);
        assertThat(value).isEqualTo(1);
    }
}
