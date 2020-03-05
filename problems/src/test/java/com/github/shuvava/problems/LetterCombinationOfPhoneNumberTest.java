package com.github.shuvava.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

public class LetterCombinationOfPhoneNumberTest {

  @DisplayName("Letter combinations")
  @ParameterizedTest(name = "run #{index} with [{arguments}]")
  @CsvSource({"23, ad,ae,af,bd,be,bf,cd,ce,cf"})
  public void letterCombinations(ArgumentsAccessor argumentsAccessor) {
    //arrange
    String test = argumentsAccessor.getString(0);
    List<String> expected = new ArrayList<>();
    int size = argumentsAccessor.size();
    for (int i = 1; i < size; i++) {
      expected.add(argumentsAccessor.getString(i));
    }
    var instance = new LetterCombinationOfPhoneNumber();
    //act
    List<String> actual = instance.letterCombinations(test);
    //assert
    actual.sort(String::compareTo);
    assertEquals(expected, actual);
  }
}
