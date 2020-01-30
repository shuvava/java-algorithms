package com.github.shuvava.sort;

/**
 * In the worst case, this implementation makes log(n)
 *  compares to sort an array of length n.
 *  However, in the worst case, the running time is n^2
 *  because the number of array accesses can be quadratic.
 *
 *  As such, it is not suitable for sorting large arrays
 *  (unless the number of inversions is small).
 *  <p>
 *  This sorting algorithm is stable.
 *  It uses &Theta;(1) extra memory (not including the input array).
 *  <p>
 */
public class BinaryInsertionSort implements ISortAlgorithm  {

  @Override
  public <T extends Comparable<T>> void sort(T[] unsorted) {
    int n = unsorted.length;
    for (int i = 1; i < n; i++) {
      // binary search to determine index j at which to insert unsorted[i]
      T v = unsorted[i];
      int lo = 0, hi = i;
      while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (less(v, unsorted[mid])) {
          hi = mid;
        } else {
          lo = mid + 1;
        }
      }

      // insetion sort with "half exchanges"
      // (insert a[i] at index j and shift a[j], ..., a[i-1] to right)
      for (int j = i; j > lo; --j) {
        unsorted[j] = unsorted[j-1];
      }
      unsorted[lo] = v;
    }
  }

  /**
   * is v < w ?
   */
  public static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }
}
