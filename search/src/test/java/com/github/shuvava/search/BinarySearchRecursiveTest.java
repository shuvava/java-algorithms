package com.github.shuvava.search;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchRecursiveTest {

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
    BinarySearchRecursive search = new BinarySearchRecursive();
    // The element that should be found
    int shouldBeFound = array[r.nextInt(array.length - 1)];
    int atIndex = search.find(array, shouldBeFound);
    assertTrue(atIndex>= 0);
  }

  @Test
  public void SimpleTest() {
    BinarySearchRecursive search = new BinarySearchRecursive();
    Integer[] arr = {10, 12, 15};
    int inx = search.find(arr, 12);
    assertEquals(inx, 1);
  }
}
