package com.github.shuvava.problems.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FindFirstLastPositionsInSortedArrayTest {

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

  @DisplayName("search first & last element in sorted array")
  @ParameterizedTest(name = "target = {1} in [{0}] should return [{2}]")
  @CsvSource(value = {
      "5,7,7,8,8,10| 6| -1, -1",
      "5,7,7,8,8,10| 8| 3, 4",
      "5,7,7,8,8,10| 5| 0, 0",
      "5,7,7,8,8,10| 10| 5, 5",
  }, delimiter = '|')
  public void search(final String input, final int target, final String output) {
    //arrange
    int[] nums = parseString(input);
    int[] expected = parseString(output);
    var instance = new FindFirstLastPositionsInSortedArray();
    //act
    int[] actual = instance.searchRange(nums, target);

    assertArrayEquals(expected, actual);
  }
}
