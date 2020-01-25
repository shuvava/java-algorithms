package com.github.shuvava.sort;

import java.util.Map;
import java.util.TreeMap;

/**
 * Complexity: O(n+k); - for int
 *  where n length of element array and k range of elements
 */
public class CountingSort implements ISortAlgorithm {

  /**
   * Complexity O(n*log(n)) because of TreeMap usage
   * @param array unsorted elements
   * @param <T> any comparable type
   */
  @Override
  public <T extends Comparable<T>> void sort(T[] array) {
    Map<T, Integer> counts = new TreeMap<>();

    for(T t : array) {
      counts.merge(t, 1, Integer::sum);
    }

    int i=0;
    for(Map.Entry<T, Integer> entry : counts.entrySet()) {
      for(int j=0; j<entry.getValue(); j++)
        array[i++] = entry.getKey();
    }
  }
}
