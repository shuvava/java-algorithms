package com.github.shuvava.problems.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GroupAnagramsTest {

  private static String[] parseToArray(String input) {
    if (input == null) {
      return ArrayUtils.EMPTY_STRING_ARRAY;
    }
    return Stream
        .of(
            input.split(",")
        )
        .map(String::trim)
        .toArray(String[]::new);
  }

  private static List<List<String>> parseToListOfList(String input) {
    if (input == null) {
      return new ArrayList<>();
    }
    return Stream
        .of(input.split(";"))
        .map(String::trim)
        .map(line -> Stream
            .of(
                line.split(",")
            )
            .map(String::trim)
            .collect(Collectors.toList())
        )
        .collect(Collectors.toList());
  }

  @DisplayName("group anagrams")
  @ParameterizedTest(name = "run #{index}")
  @CsvSource(value = {
      "eat,tea,tan,ate,nat,bat| eat, tea, ate;bat;tan, nat",
  }, delimiter = '|')
  public void groupAnagrams(final String input, final String output) {
    // arrange
    String[] strs = parseToArray(input);
    List<List<String>> expected = parseToListOfList(output);
    // atc
    List<List<String>> actual = GroupAnagrams.groupAnagrams(strs);
    // assert
    assertEquals(expected, actual);
  }
}
