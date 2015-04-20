package org.paukov.sort;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by dpaukov
 */
public class HeapSortTest {


    @Test
    public void test_heap_sort_0(){
        HeapSort heapSort = new HeapSort();
        int[] array = new int[] {17, 3, 19, 2, 7, 25, 100, 1, 36};
        heapSort.sort(array, array.length);

        assertThat(array).isNotNull().hasSize(9);

        assertThat(array[8]).isEqualTo(100);
        assertThat(array[7]).isEqualTo(36);
        assertThat(array[6]).isEqualTo(25);
        assertThat(array[5]).isEqualTo(19);
        assertThat(array[4]).isEqualTo(17);
        assertThat(array[3]).isEqualTo(7);
        assertThat(array[2]).isEqualTo(3);
        assertThat(array[1]).isEqualTo(2);
        assertThat(array[0]).isEqualTo(1);

    }

    @Test
    public void test_heap_sort_1(){
        HeapSort heapSort = new HeapSort();
        int[] array = new int[] {100, 36, 19, 25, 17, 7, 3, 2, 1};
        heapSort.sort(array, array.length);

        assertThat(array).isNotNull().hasSize(9);

        assertThat(array[8]).isEqualTo(100);
        assertThat(array[7]).isEqualTo(36);
        assertThat(array[6]).isEqualTo(25);
        assertThat(array[5]).isEqualTo(19);
        assertThat(array[4]).isEqualTo(17);
        assertThat(array[3]).isEqualTo(7);
        assertThat(array[2]).isEqualTo(3);
        assertThat(array[1]).isEqualTo(2);
        assertThat(array[0]).isEqualTo(1);

    }

    @Test
    public void test_heap_sort_2(){
        HeapSort heapSort = new HeapSort();
        int[] array = new int[] {100, 36, 19, 100, 25, 17, 7, 3, 2, 1, 25};
        heapSort.sort(array, array.length);

        assertThat(array).isNotNull().hasSize(11);

        assertThat(array[10]).isEqualTo(100);
        assertThat(array[9]).isEqualTo(100);
        assertThat(array[8]).isEqualTo(36);
        assertThat(array[7]).isEqualTo(25);
        assertThat(array[6]).isEqualTo(25);
        assertThat(array[5]).isEqualTo(19);
        assertThat(array[4]).isEqualTo(17);
        assertThat(array[3]).isEqualTo(7);
        assertThat(array[2]).isEqualTo(3);
        assertThat(array[1]).isEqualTo(2);
        assertThat(array[0]).isEqualTo(1);

    }

    @Test
    public void test_heap_sort_3(){
        HeapSort heapSort = new HeapSort();
        int[] array = new int[] {17};
        heapSort.sort(array, array.length);

        assertThat(array).isNotNull().hasSize(1);
        assertThat(array[0]).isEqualTo(17);
    }

    @Test
    public void test_heap_sort_4(){
        HeapSort heapSort = new HeapSort();
        int[] array = new int[] {};
        heapSort.sort(array, array.length);

        assertThat(array).isNotNull().hasSize(0);
    }



    @Test
    public void test_build_heap(){
        HeapSort heapSort = new HeapSort();
        int[] array = new int[] {17, 3, 19, 2, 7, 25, 100, 1, 36};
        heapSort.build_heap(array, array.length);

        assertThat(array).isNotNull().hasSize(9);

        assertThat(array[0]).isEqualTo(100);
        assertThat(array[1]).isEqualTo(17);
        assertThat(array[2]).isEqualTo(36);
        assertThat(array[3]).isEqualTo(3);
        assertThat(array[4]).isEqualTo(7);
        assertThat(array[5]).isEqualTo(19);
        assertThat(array[6]).isEqualTo(25);
        assertThat(array[7]).isEqualTo(1);
        assertThat(array[8]).isEqualTo(2);

    }

    @Test
    public void test_heapify_0(){
        HeapSort heapSort = new HeapSort();
        int[] array = new int[] {3, 17, 19};
        heapSort.heapify(array, array.length, 0);

        assertThat(array).isNotNull().hasSize(3);

        assertThat(array[0]).isEqualTo(19);
        assertThat(array[1]).isEqualTo(3);
        assertThat(array[2]).isEqualTo(17);


    }

    @Test
    public void test_restore_with_known_value_1(){
        HeapSort heapSort = new HeapSort();
        int[] array = new int[]{1,2,7,3,4,5,6,8,9};
        heapSort.sort(array, array.length);
        assertThat(array).isEqualTo(new int[]{1,2,3,4,5,6,7,8,9});

    }

    @Test
    public void test_restore_with_known_value_2(){
        HeapSort heapSort = new HeapSort();
        int[] array = new int[]{1,2,4,5,6,7,3,8,9};
        heapSort.sort(array, array.length);
        assertThat(array).isEqualTo(new int[]{1,2,3,4,5,6,7,8,9});
    }

    @Test
    public void test_restore_with_known_value_3(){
        HeapSort heapSort = new HeapSort();
        int[] array = new int[]{2,4,6,1,10,12,14,16,18,20};
        heapSort.sort(array, array.length);
        assertThat(array).isEqualTo(new int[]{1,2,4,6,10,12,14,16,18,20});
    }

    @Test
    public void test_restore_with_known_value_4(){
        HeapSort heapSort = new HeapSort();
        int[] array = new int[]{2,4,6,3,10,12,14,16,18,20};
        heapSort.sort(array, array.length);
        assertThat(array).isEqualTo(new int[]{2,3,4,6,10,12,14,16,18,20});

    }

    @Test
    public void test_restore_with_known_value_5(){
        HeapSort heapSort = new HeapSort();
        int[] array = new int[]{2,4,6,23,10,12,14,16,18,20};
        heapSort.sort(array, array.length);
        assertThat(array).isEqualTo(new int[]{2,4,6,10,12,14,16,18,20,23});
    }

    @Test
    public void test_restore_with_known_value_6(){
        HeapSort heapSort = new HeapSort();
        int[] array = new int[]{23,4,6,8,10,12,14,16,18,20};
        heapSort.sort(array, array.length);
        assertThat(array).isEqualTo(new int[]{4,6,8,10,12,14,16,18,20,23});

    }

    @Test
    public void test_restore_with_known_value_7(){
        HeapSort heapSort = new HeapSort();
        int[] array = new int[]{3,4,6,8,10,12,14,16,18,20,2};
        heapSort.sort(array, array.length);
        assertThat(array).isEqualTo(new int[]{2,3,4,6,8,10,12,14,16,18,20});
    }
}
