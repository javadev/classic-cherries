package org.paukov.sort;

/**
 * Created by dpaukov
 */
public class RadixSort {

    public void sort_lsd(int[] array){
        int[] bins = new int[10];
        int[] array2 = new int[array.length];
        int mod = 10;
        int div = 1;

        while(true) {

            for (int i = 0; i < array.length; i++) {
                int bin = radix(array[i], mod, div);
                bins[bin]++;
            }
            for (int i = 1; i < bins.length; i++) {
                bins[i] = bins[i] + bins[i - 1];
            }
            for (int i = array.length - 1; i >= 0; i--) {
                int bin = radix(array[i], mod, div);
                int idx = --bins[bin];
                array2[idx] = array[i];
            }
            for (int i = 0; i < array2.length; i++) {
                array[i] = array2[i];
                array2[i] = 0;
            }
            mod*=10;
            div*=10;

            if (!should_continue(array, mod)){
                return;
            } else {
                for (int i = 0; i < bins.length; i++) {
                    bins[i] = 0;
                }
            }

        }

    }

    int radix(int value, int mod, int div){
        return value % mod / div;
    }

    boolean should_continue(int[] array, int mod){
        for (int i = 0; i < array.length; i++) {
            if(array[i]>=(mod/10)){
                return true;
            }
        }
        return false;
    }
}
