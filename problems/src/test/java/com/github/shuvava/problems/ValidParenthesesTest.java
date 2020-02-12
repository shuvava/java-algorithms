package com.github.shuvava.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidParenthesesTest {

  @DisplayName("Valid parentheses")
  @ParameterizedTest(name = "run #{index} with [{arguments}]")
  @CsvSource({"[]), false", "((({}))), true", "[,false", ")[,false", "()[]{},true"})
  public void isValid(ArgumentsAccessor argumentsAccessor) {
    String s = argumentsAccessor.getString(0);
    boolean expected = argumentsAccessor.getBoolean(1);
    ValidParentheses instance = new ValidParentheses();
    boolean result = instance.isValid(s);
    assertEquals(expected, result);
  }
}
