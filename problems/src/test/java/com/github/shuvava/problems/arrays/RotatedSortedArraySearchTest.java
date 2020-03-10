package com.github.shuvava.problems.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RotatedSortedArraySearchTest {

  private static int[] parseString(String input) {
    if (input == null) {
      return ArrayUtils.EMPTY_INT_ARRAY;
    }
    return Stream
        .of(
            input.split(",")
        )
        .map(String::trim)
        .mapToInt(Integer::parseInt)
        .toArray();
  }

  @DisplayName("get rotated array pivot")
  @ParameterizedTest(name = "[{0}] should return {1}")
  @CsvSource(value = {
      "4, 5, 6, 7, 0, 1, 2| 4",
      "0, 1, 2, 4, 5, 6, 7| 0",
      "3, 1| 1",
      "2, 3, 1| 2",
      "3, 1, 2| 1"
  }, delimiter = '|')
  public void getPivot(final String input, final int expected) {
    //arrange
    int[] nums = parseString(input);
    var instance = new RotatedSortedArraySearch();
    //act
    int actual = instance.getPivot(nums);

    assertEquals(expected, actual);
  }

  @DisplayName("search element rotated array pivot")
  @ParameterizedTest(name = "target = {1} in [{0}] should return {2}")
  @CsvSource(value = {
      "4, 5, 6, 7, 0, 1, 2| 0| 4",
      "0, 1, 2, 4, 5, 6, 7| 3| -1",
      "0, 1, 2, 4, 5, 6, 7| 7| 6",
      "3, 1| 1| 1",
      "3, 5, 1| 5| 1",
  }, delimiter = '|')
  public void search(final String input, final int target, final int expected) {
    //arrange
    int[] nums = parseString(input);
    var instance = new RotatedSortedArraySearch();
    //act
    int actual = instance.search(nums, target);

    assertEquals(expected, actual);
  }
}
