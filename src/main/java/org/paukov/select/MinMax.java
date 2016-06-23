package org.paukov.select;


public class MinMax {

    int min;
    int max;
    int comparisons;

    MinMax(int min, int max, int comparisons){
        this.min = min;
        this.max = max;
        this.comparisons = comparisons;
    }

    static MinMax findMinMax(int[] array, int start, int end){

        int comparisons=1;
        int min = array[start];
        int max = array[start];

        if (array[start+1] > max) {
            max = array[start+1];
        } else {
            min = array[start+1];
        }

        for (int i=start+2; i<=end; i+=2){

            int min2 = array[i];
            int max2 = min2;

            if (i!=end){
                max2 = array[i + 1];
            }

            if (max2 < min2) {
                min2 = max2;
                max2 = array[i];
            }

            if (min2 < min) {
                min = min2;
            }

            if (max2 > max) {
                max = max2;
            }
            comparisons += 3;

        }
        return new MinMax(min, max, comparisons);

    }

}
