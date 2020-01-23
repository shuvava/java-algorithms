package com.github.shuvava.sort;

/**
 * Complexity: O(n*ln(n)); Worst: O(n2)
 * Algorithm:
 *   1. Partition array -> choose pivot element
 *     put in the left array elements smaller pivot
 *     put in the left array elements bigger pivot
 */
public class QuickSort implements ISortAlgorithm {

  @Override
  public <T extends Comparable<T>> void sort(T[] unsorted) {
    if (unsorted == null || unsorted.length<2) { //already sorted
      return;
    }
    quickSort(unsorted, 0, unsorted.length-1);
  }

  private static <T extends Comparable<T>> void swap(T[] array, int inxA, int inxB) {
    T temp = array[inxA];
    array[inxA] = array[inxB];
    array[inxB] = temp;
  }

  /**
   * Rearranges the elements of array[start:end] so that every element in array[start:pivot] is less
   * than or equal to array[pivot] and every element in array[pivot:end] is greater than
   * array[pivot]. Returns the index pivot to the caller
   *
   * @param array array of element to sort
   * @param low low(min) index in array
   * @param high high (max) index in array
   * @param <T> any Comparable object
   * @return index of pivot element
   */
  private static <T extends Comparable<T>> int getPartition(T[] array, int low, int high) {
    int pivot = low;
    int inx = low;
    while (inx < high) {
      int comp = array[inx].compareTo(array[high]);
      if (comp<0) {
        swap(array, pivot, inx);
        pivot++;
      }
      inx++;
    }
    swap(array, pivot, high);
    return pivot;
  }

  private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
    if (high <= low) {
      return;
    }
    int middle = getPartition(array, low, high);
    quickSort(array, low, middle-1);
    quickSort(array, middle+1, high);
  }
}
