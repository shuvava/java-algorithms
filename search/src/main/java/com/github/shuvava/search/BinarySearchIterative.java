package com.github.shuvava.search;

import java.util.NoSuchElementException;

public class BinarySearchIterative implements ISearchAlgorithm {

  @Override
  public <T extends Comparable<T>> int find(T[] array, T value) {
    int lo = 0;
    int hi = array.length-1;
    while (lo <= hi) {
      int mid = (hi+lo) >>> 1;
      int comp = value.compareTo(array[mid]);
      if (comp < 0) {
        hi = mid - 1;
      } else if (comp > 0) {
        lo = mid + 1;
      } else {
        return mid;
      }
    }
    throw new NoSuchElementException();
  }
}
