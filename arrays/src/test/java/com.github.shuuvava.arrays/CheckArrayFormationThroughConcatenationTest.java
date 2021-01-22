package com.github.shuuvava.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CheckArrayFormationThroughConcatenationTest {

  private static ArrayList<ArrayList<Integer>> parseToArrayOfArray(String input) {
    if (input == null) {
      return new ArrayList<ArrayList<Integer>>();
    }
    return Stream.of(input.split(";"))
      .map(String::trim)
      .map(
        line ->
          Stream.of(line.split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(ArrayList<Integer>::new, ArrayList::add, ArrayList::addAll))
      .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
  }

  private static ArrayList<Integer> parseArray(String input) {
    if (input == null) {
      return new ArrayList<>();
    }
    return Stream.of(input.split(","))
      .map(String::trim)
      .mapToInt(Integer::parseInt)
      .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
  }

  @DisplayName("Check array formation through concatenation")
  @ParameterizedTest(name = "test #{index}")
  @CsvSource(
    value = {
      "85 | 85 | true",
      "15, 88 | 88; 15 | true",
      "49, 18, 16 | 16, 18, 49 | false",
      "91, 4, 64, 78 | 78; 4, 64; 91 | true",
      "1, 3, 5, 7 | 16, 18, 49 | false",
    },
    delimiter = '|')
  public void CheckArray(final String arrStr, final String piecesStr, final boolean expected) {
    ArrayList<Integer> arr = parseArray(arrStr);
    ArrayList<ArrayList<Integer>> pieces = parseToArrayOfArray(piecesStr);

    boolean actual = CheckArrayFormationThroughConcatenation.Test(arr, pieces);

    assertEquals(expected, actual);
  }
}
