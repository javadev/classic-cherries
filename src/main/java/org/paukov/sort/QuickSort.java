package org.paukov.sort;

/**
 * Created by dpaukov
 */
public class QuickSort {

  public void quickSort(int[] array) {
    quickSort(array, 0, array.length - 1);
  }

  void quickSort(int[] array, int low, int high) {
    if (low < high) {
      int p = partition(array, low, high);
      quickSort(array, low, p);
      quickSort(array, p + 1, high);
    }
  }

  // Partition the array list[first..last]
  int partition(int[] list, int first, int last) {
    int pivot = list[first]; // Choose the first element as the pivot
    int low = first + 1; // Index for forward search
    int high = last; // Index for backward search

    while (high > low) {
      // Search forward from left
      while (low <= high && list[low] <= pivot) {
        low++;
      }

      // Search backward from right
      while (low <= high && list[high] > pivot) {
        high--;
      }

      // Swap two elements in the list
      if (high > low) {
        swap(list, low, high);
      }
    }

    while (high > first && list[high] >= pivot) {
      high--;
    }

    // Swap pivot with list[high]
    if (pivot > list[high]) {
      list[first] = list[high];
      list[high] = pivot;
      return high;
    } else {
      return first;
    }
  }

  void swap(int[] array, int low, int high) {
    int value = array[low];
    array[low] = array[high];
    array[high] = value;
  }
}

