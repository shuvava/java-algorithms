package com.github.shuvava.search;

import java.util.NoSuchElementException;

public interface ISearchAlgorithm {

  /**
   *
   * @param array array is an array where the element should be found
   * @param value is an element which should be found
   * @param <T> is any comparable type
   * @return index of the element
   */
  <T extends Comparable<T>> int find(T[] array, T value) throws NoSuchElementException;
}
