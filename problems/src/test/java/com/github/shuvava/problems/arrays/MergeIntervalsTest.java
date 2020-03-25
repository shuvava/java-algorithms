package com.github.shuvava.problems.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MergeIntervalsTest {

  private static int[][] parseToArrayOfArray(String input) {
    if (input == null) {
      return new int[0][0];
    }
    return Stream
        .of(input.split(";"))
        .map(String::trim)
        .map(line -> Stream
            .of(
                line.split(",")
            )
            .map(String::trim)
            .mapToInt(Integer::parseInt)
            .toArray()
        )
        .toArray(int[][]::new);
  }

  @DisplayName("array merge intervals")
  @ParameterizedTest(name = "{0} should return {1}")
  @CsvSource(value = {
      "1,3;2,6;8,10;15,18| 1,6;8,10;15,18",
  }, delimiter = '|')
  public void merge(final String input, final String output) {
    //arrange
    int[][] intervals = parseToArrayOfArray(input);
    int[][] expected = parseToArrayOfArray(output);
    var instance = new MergeIntervals();
    // act
    int[][] actual = instance.merge(intervals);
    // assert
    Arrays.sort(expected, Comparator.comparingInt(a -> a[0]));
    Arrays.sort(actual, Comparator.comparingInt(a -> a[0]));
    Assertions.assertArrayEquals(expected, actual);
  }
}
