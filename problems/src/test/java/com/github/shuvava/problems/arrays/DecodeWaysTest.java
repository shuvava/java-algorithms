package com.github.shuvava.problems.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DecodeWaysTest {

  @DisplayName("array all possible subsets")
  @ParameterizedTest(name = "\"{0}\" should return {1}")
  @CsvSource(value = {
      "0|0",
      "012|0",
      "69|1",
      "10|1",
      "126|3",
      "269|2",
      "219|3",
      "1269|3",
      "21269|5",
      "621269|5"
  }, delimiter = '|')
  public void numDecodings(final String input, final int expected) {
    var instance = new DecodeWays();
    //act
    int actual = instance.numDecodings(input);
    Assertions.assertEquals(expected, actual);
  }
}
