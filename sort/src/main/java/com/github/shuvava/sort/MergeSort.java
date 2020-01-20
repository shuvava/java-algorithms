package com.github.shuvava.sort;

/**
 * Merge sort Complexity: O(n*ln(n)) require double size of memory Algorithm: 1. Split array on a
 * half (mergeSort) recursively till 1 elements array 2. merge two pre sorted sub array (merge) (on
 * the deepest level array contents just one element)
 */
public class MergeSort implements ISortAlgorithm {

  @Override
  public <T extends Comparable<T>> void sort(T[] unsorted) {
    if (unsorted.length<2) {
      return; // already sorted
    }
    mergeSort(unsorted, 0, unsorted.length-1);
  }

  private static <T extends Comparable<T>> void mergeSort(T[] array, int low, int high) {
    if (low >= high) {
      return;
    }
    int mid = (low + high) >>> 1;
    mergeSort(array, low, mid);
    mergeSort(array, mid + 1, high);
    int comp = array[mid].compareTo(array[mid + 1]);
    if (comp > 0) {//This is where we optimize for best case.
      merge(array, low, mid, high);
    }
  }

  private static <T extends Comparable<T>> void merge(T[] array, int low, int mid, int high) {
    int i = low;
    int j = mid + 1;
    int k = 0;
    T[] temp = (T[]) new Comparable[high - low + 1];
    while (i <= mid && j <= high) {
      int comp = array[i].compareTo(array[j]);
      if (comp < 0) {
        temp[k] = array[i];
        i++;
      } else {
        temp[k] = array[j];
        j++;
      }
      k++;
    }
    while (j <= high) {
      temp[k] = array[j];
      k++;
      j++;
    }
    while (i <= mid) {
      temp[k] = array[i];
      k++;
      i++;
    }
    System.arraycopy(temp, 0, array, low, temp.length);
  }
}
