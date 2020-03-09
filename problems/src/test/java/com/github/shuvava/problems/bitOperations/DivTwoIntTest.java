package com.github.shuvava.problems.bitOperations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DivTwoIntTest {

  @DisplayName("Length of the longest palindrome")
  @ParameterizedTest(name = "{0}//{1} should return {2}")
  @CsvSource({
      "10, 3, 3",
      "1, 1, 1",
      "-2147483648, -1, 2147483647",
      "-2147483648, 1 , -2147483648",
      "-1010369383, -2147483648, 0"
  })
  public void divide(int dividend, int divisor, int expected) {
    var instance = new DivTwoInt();
    //act
    int actual = instance.divide(dividend, divisor);

    assertEquals(expected, actual);
  }
}
