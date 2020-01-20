package com.github.shuvava.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseSortTest {
  private Random r = ThreadLocalRandom.current();
  protected Integer[] array;
  protected Integer[] arrayExpected;
  @BeforeEach
  public  void setUp() {
    // Just generate data
    int size = 100;
    int maxElement = 100000;

    array = IntStream
        .generate(() -> r.nextInt(maxElement))
        .limit(size)
        .boxed()
        .toArray(Integer[]::new);
    arrayExpected = Arrays.copyOf(array, array.length);
    Arrays.sort(arrayExpected);
  }
}
