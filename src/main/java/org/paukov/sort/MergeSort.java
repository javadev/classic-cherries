package org.paukov.sort;

import java.util.Arrays;

/**
 * Created by dpaukov
 */
public class MergeSort {

  public void mergeSort(int[] array) {
    mergeSort(array, 0, array.length - 1);
  }

  void mergeSort(int[] array, int low, int high) {
    if (high - low < 2) {
      return;
    }

    if (low < high) {
      int mid = low + (high - low) / 2;
      mergeSort(array, low, mid);
      mergeSort(array, mid + 1, high);
      merge(array, low, mid, high);
    }
  }

  void merge(int[] array, int low, int mid, int high) {

    int[] b = Arrays.copyOfRange(array, low, mid);

    for (int i = low, j = mid, k = 0; k < b.length; i++) {
      if (j == high || b[k] < array[j]) {
        array[i] = b[k++];
      } else {
        array[i] = array[j++];
      }
    }
  }

  int[] merge(int[] a, int[] b) {

    int[] answer = new int[a.length + b.length];
    int i = 0, j = 0, k = 0;

    while (i < a.length && j < b.length) {
      if (a[i] < b[j]) {
        answer[k++] = a[i++];
      } else {
        answer[k++] = b[j++];
      }
    }

    while (i < a.length) {
      answer[k++] = a[i++];
    }

    while (j < b.length) {
      answer[k++] = b[j++];
    }

    return answer;
  }
}
