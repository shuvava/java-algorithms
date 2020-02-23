package com.github.shuvava.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

public class ContainerWithMostWaterTest {

  @DisplayName("Container with most water")
  @ParameterizedTest(name = "run #{index} with [{arguments}]")
  @CsvSource({"1,8,6,2,5,4,8,3,7, 49"})
  public void maxArea(ArgumentsAccessor argumentsAccessor) {
    //arrange
    int size = argumentsAccessor.size() - 1;
    int expected = argumentsAccessor.getInteger(size);
    int[] height = new int[size];
    for (int i = 0; i < size; i++) {
      height[i] = argumentsAccessor.getInteger(i);
    }
    var instance = new ContainerWithMostWater();
    //act
    int actual = instance.maxArea(height);
    //assert
    assertEquals(expected, actual);
  }
}
