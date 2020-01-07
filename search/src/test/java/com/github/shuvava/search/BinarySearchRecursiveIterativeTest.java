package com.github.shuvava.search;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinarySearchRecursiveIterativeTest {
  private Random r = ThreadLocalRandom.current();
  private Integer[] array;
  @BeforeEach
  public  void setUp() {
    // Just generate data
    int size = 100;
    int maxElement = 100000;

    array = IntStream
        .generate(() -> r.nextInt(maxElement))
        .limit(size)
        .sorted()
        .boxed()
        .toArray(Integer[]::new);
  }

  @Test
  public void Find() {
    BinarySearchIterative search = new BinarySearchIterative();
    // The element that should be found
    int shouldBeFound = array[r.nextInt(array.length - 1)];
    int atIndex = search.find(array, shouldBeFound);
    assertTrue(atIndex>= 0);
  }

  @Test
  public void SimpleTest() {
    BinarySearchIterative search = new BinarySearchIterative();
    Integer[] arr = {10, 12, 15};
    int inx = search.find(arr, 12);
    assertEquals(inx, 1);

  }
}
