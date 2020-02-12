package com.github.shuvava.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

public class LongestCommonPrefixTest {

  @DisplayName("Longest common prefix")
  @ParameterizedTest(name = "run #{index} with [{arguments}]")
  @CsvSource({"flower, flow, flight, fl"})
  public void longestCommonPrefix(ArgumentsAccessor argumentsAccessor) {
    //arrange
    List<String> strs = new ArrayList<>();
    int size = argumentsAccessor.size() - 1;
    String expected = argumentsAccessor.getString(size);
    for (int i = 0; i < size; i++) {
      strs.add(argumentsAccessor.getString(i));
    }
    LongestCommonPrefix instance = new LongestCommonPrefix();
    String[] params = new String[strs.size()];
    strs.toArray(params);
    //act
    String actual = instance.longestCommonPrefix(params);
    //assert
    assertEquals(expected, actual);
  }

}
