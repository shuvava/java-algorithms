package com.github.shuvava.sort;

import java.util.Arrays;
import java.util.List;

public interface ISortAlgorithm {
  /**
   * Main method arrays sorting algorithms
   *
   * @param unsorted - an array should be sorted
   * @return a sorted array
   */
  <T extends Comparable<T>> void sort(T[] unsorted);
}
