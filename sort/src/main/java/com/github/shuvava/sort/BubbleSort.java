package com.github.shuvava.sort;

/**
 * Insertion sort(bubble sort) Complexity: O(n^2) for j(index) ← 2 to n insert key A[j] into the
 * (already sorted) sub-array A[1 .. j-1]. by pairwise key-swaps down to its right position
 * https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/lecture-videos/MIT6_006F11_lec03.pdf
 */
public class BubbleSort implements ISortAlgorithm {

  private static <T extends Comparable<T>> void swap(T[] array, int inx1, int inx2) {
    if (inx1 == inx2) {
      return;
    }
    T tmp = array[inx1];
    array[inx1] = array[inx2];
    array[inx2] = tmp;
  }

  /**
   * This method implements the Generic Bubble Sort
   *
   * @param array The array to be sorted Sorts the array in increasing order
   */
  @Override
  public <T extends Comparable<T>> void sort(T[] array) {
    int len = array.length;
    if (len < 2) {
      return;
    }
    int inx = 1;
    while (inx < len) {
      int innerInx = inx;
      while (innerInx > 0) {
        int comp = array[innerInx].compareTo(array[innerInx - 1]);
        if (comp < 0) {
          swap(array, innerInx, innerInx - 1);
        } else {
          break;
        }
        innerInx -= 1;
      }
      inx += 1;
    }
  }
}
