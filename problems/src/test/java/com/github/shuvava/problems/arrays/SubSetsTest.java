package com.github.shuvava.problems.arrays;

import static com.github.shuvava.problems.TestHelper.parseToArray;
import static com.github.shuvava.problems.TestHelper.parseToListOfList;
import static com.github.shuvava.problems.TestHelper.sortCollection;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SubSetsTest {

  @DisplayName("array all possible subsets")
  @ParameterizedTest(name = "run #{index}")
  @CsvSource(value = {
      "1,2,3| 1,2,3; 3; 2; 1; 1,2; 2,3; 1,3;",
      "1| 1;",
  }, delimiter = '|')
  public void subsets(final String input, final String output) {
    //arrange
    int[] nums = parseToArray(input);
    List<List<Integer>> expected = parseToListOfList(output);
    expected.add(new ArrayList<>());
    sortCollection(expected);
    var instance = new SubSets();
    //act
    List<List<Integer>> actual = instance.subsets(nums);
    //assert
    sortCollection(actual);
    assertEquals(expected, actual);
  }
}
