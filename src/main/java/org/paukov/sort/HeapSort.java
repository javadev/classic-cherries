package org.paukov.sort;

/**
 * Created by dpaukov
 */
public class HeapSort {

    public void sort(int[] array, int size){
        build_heap(array, size);
        for (int i=size-1; i>0; i--){
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }

    void build_heap(int[] array, int size){
        for (int i = size/2; i>=0; i--){
            heapify(array, size, i);
        }
    }

    void heapify(int[] array, int size, int i){
        int l = left(i);
        int r = right(i);

        if ((l < size) && (array[l]>array[i])) {
            swap(array, i, l);
            heapify(array, size, l);
        }
        if ((r < size) && (array[r]>array[i])) {
            swap(array, i, r);
            heapify(array, size, r);
        }
    }

    int parent(int i){
        return (i-1)/2;
    }

    int left(int i){
        return 2 * i + 1;
    }

    int right(int i){
        return 2 * i + 2;
    }

    void swap(int[] array, int i, int j){
        int value = array[i];
        array[i] = array[j];
        array[j] = value;
    }
}
