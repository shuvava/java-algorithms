package com.github.shuvava.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class CountingSortTest extends BaseSortTest {

  @Test
  public void Sort() {
    ISortAlgorithm instance = getInstance();

    instance.sort(array);

    assertArrayEquals(arrayExpected, array);
  }

  @Test
  public void SimpleTest() {
    ISortAlgorithm instance = getInstance();
    Integer[] arr = {6, 5, 3, 2, 8, 10, 9};
    Integer[] arrExpected = Arrays.copyOf(arr, arr.length);
    Arrays.sort(arrExpected);

    instance.sort(arr);

    assertArrayEquals(arrExpected, arr);
  }
  @Override
  protected ISortAlgorithm getInstance() {
    return new CountingSort();
  }

}
