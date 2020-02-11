package com.github.shuvava.problems.romanToInteger;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RomanToIntegerTest {

  @DisplayName("Roman To Integer")
  @ParameterizedTest(name = "run #{index} with [{arguments}]")
  @CsvSource({"LVIII, 58", "MCMXCIV, 1994"})
  public void romanToInt(String s, int expected) {
    RomanToInteger instance = new RomanToInteger();
    int actual = instance.romanToInt(s);
    assertEquals(expected, actual);
  }
}
