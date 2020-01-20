package com.github.shuvava.search;

import java.util.NoSuchElementException;

public class BinarySearchRecursive implements ISearchAlgorithm {
  /**
   * recursive implementation of binary search
   *
   * @param array is an array where the element should be found
   * @param value is an element which should be found
   * @param lo the lower bound
   * @param hi the upper bound
   * @param <T> is any comparable type
   * @return index of found element in array
   */
  public static <T extends Comparable<T>> int searchRecursive(T[] array, T value, int lo, int hi) throws NoSuchElementException {
    if (lo > hi) {
      throw new NoSuchElementException();
    }
    int mid = (hi+lo) >>> 1;
    int comp = value.compareTo(array[mid]);
    if (comp < 0) {
      return searchRecursive(array, value, lo, mid - 1);
    } else if (comp > 0) {
      return searchRecursive(array, value, mid + 1, hi);
    }
    return mid;
  }

  @Override
  public <T extends Comparable<T>> int find(T[] array, T value) throws NoSuchElementException {
    return searchRecursive(array, value,0, array.length);
  }
}
