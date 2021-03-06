package com.github.shuvava.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class BubbleSortTest extends BaseSortTest {

  @Test
  public void Sort() {
    ISortAlgorithm instance = getInstance();
    // The element that should be found

    instance.sort(array);
    assertArrayEquals(arrayExpected, array);
  }

  @Test
  public void SimpleTest() {
    ISortAlgorithm instance = getInstance();
    Integer[] arr = {6, 5, 1, 4};
    Integer[] arrExpected = Arrays.copyOf(arr, arr.length);
    Arrays.sort(arrExpected);
    instance.sort(arr);
    assertArrayEquals(arrExpected, arr);
  }

  @Override
  protected ISortAlgorithm getInstance() {
    return new BubbleSort();
  }
}
