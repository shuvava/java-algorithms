package com.github.shuvava.problems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TwoSumTest {

  @Test
  public void testSolution() {
    var instance = new TwoSum();
    var result = instance.twoSum(new int [] {2,7,11,15}, 9);
    assertArrayEquals(new int[]{0, 1}, result);
  }
}
