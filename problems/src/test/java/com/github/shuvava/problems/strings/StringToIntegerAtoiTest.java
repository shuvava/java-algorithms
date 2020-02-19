package com.github.shuvava.problems.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringToIntegerAtoiTest {

  @DisplayName("String to integer (Atoi)")
  @ParameterizedTest(name = "run #{index} with [{arguments}]")
  @CsvSource({"42, 42", "-42, -42", "4193 with words, 4193", "-91283472332, -2147483648", "+, 0",
      "+-42, 0", "9223372036854775808, 2147483647"})
  public void myAtoi(String s, int expected) {
    var instance = new StringToIntegerAtoi();
    int actual = instance.myAtoi(s);
    assertEquals(expected, actual);
  }
}
