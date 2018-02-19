package org.paukov.exercise;

/**
 * Created by dpaukov
 */
public class RotateArray {

    public void rotate(int[] array, int k){
        if (k <= 0) {
            return;
        }

        k = k % array.length;
        reverse(array, array.length-k, array.length-1);
        reverse(array, 0, array.length-k-1);
        reverse(array, 0, array.length-1);
    }

    void reverse(int[] array, int start, int end){
        int length = (end - start) / 2;
        for (int i = 0; i <= length; i++){
            swap(array, start + i, end - i);
        }
    }

    void swap(int[] array, int start, int end){
        int value = array[start];
        array[start]=array[end];
        array[end]=value;
    }
}
