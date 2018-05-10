package org.paukov.select;

import java.util.Arrays;

/**
 * Created by dpaukov on 5/9/18.
 *
 * Dutch national flag problem.
 * https://en.wikipedia.org/wiki/Dutch_national_flag_problem
 *
 *
 */
public class ThreeWayPartitioning {

    static class Pair {
        int lt;
        int gt;

        Pair(int lt, int gt) {
            this.lt = lt;
            this.gt = gt;
        }

        @Override
        public String toString() {
            return "Pair{" + "lt=" + lt + ", gt=" + gt + '}';
        }
    }

    public static Pair run(int[] a, int lo, int hi) {
        if (lo>hi){
            return new Pair(lo, hi);
        }

        int lt = lo;
        int gt = hi;
        int pivot = a[lo];
        int i = lo;

        while (i <= gt) {
            if (a[i] < pivot) {
                swap(a, lt++, i++);
            } else if (a[i] > pivot) {
                swap(a, i, gt--);
            } else {
                i++;
            }
        }
        return new Pair(lt, gt);
    }

    private static void swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static void main(String[] args) {
        int[] array = new int[]{20, 1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
        System.out.println("Array    : " + Arrays.toString(array));
        Pair pair = ThreeWayPartitioning.run(array, 0, array.length - 1);
        System.out.println("Pair     : " + pair);
        System.out.println("Partition: " + Arrays.toString(array));
    }

}
