package com.github.shuvava.problems.greedyAlgorithms.permutations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ArrayPermutationTest {

  private static int[] parseToArray(String input) {
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

  private static List<List<Integer>> parseToListOfList(String input) {
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
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList())
        )
        .collect(Collectors.toList());
  }

  @DisplayName("array permutations recursive")
  @ParameterizedTest(name = "run #{index}")
  @CsvSource(value = {
      "1,2,3| 1,2,3; 2,1,3; 3,1,2; 1,3,2; 2,3,1; 3,2,1",
  }, delimiter = '|')
  public void permuteRecursive(final String input, final String output) {
    //arrange
    int[] nums = parseToArray(input);
    List<List<Integer>> expected = parseToListOfList(output);
    //act
    List<List<Integer>> actual = ArrayPermutation.permuteRecursive(nums);
    //assert
    assertEquals(expected, actual);
  }

  @DisplayName("array permutations iterative")
  @ParameterizedTest(name = "run #{index}")
  @CsvSource(value = {
      "1,2,3| 1,2,3; 2,1,3; 3,1,2; 1,3,2; 2,3,1; 3,2,1",
  }, delimiter = '|')
  public void permuteIterative(final String input, final String output) {
    //arrange
    int[] nums = parseToArray(input);
    List<List<Integer>> expected = parseToListOfList(output);
    //act
    List<List<Integer>> actual = ArrayPermutation.permuteIterative(nums);
    //assert
    assertEquals(expected, actual);
  }
}
