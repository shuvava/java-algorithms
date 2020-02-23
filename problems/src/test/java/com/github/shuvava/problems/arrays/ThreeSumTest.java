package com.github.shuvava.problems.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

public class ThreeSumTest {

  @DisplayName("3 sum")
  @ParameterizedTest(name = "run #{index} with [{arguments}]")
  @CsvSource({"'-1,0,1,2,-1,-4', '-1,-1,2', '-1,0,1'"})
  public void threeSum(ArgumentsAccessor argumentsAccessor) {
    //arrange
    int[] testCase =
        Stream
            .of(
                argumentsAccessor
                    .getString(0)
                    .split(",")
            )
            .map(String::trim)
            .mapToInt(Integer::parseInt)
            .toArray();
    List<List<Integer>> expected = new ArrayList<>();
    int size = argumentsAccessor.size();
    for (int i = 1; i < size; i++) {
      List<Integer> item = Stream
          .of(
              argumentsAccessor
                  .getString(i)
                  .split(",")
          )
          .map(String::trim)
          .mapToInt(Integer::parseInt)
          .boxed()
          .collect(Collectors.toList());
      expected.add(item);
    }
    var instance = new ThreeSum();
    //act
    var actual = instance.threeSum(testCase);
    //assert
    assertEquals(expected, actual);
  }
}
