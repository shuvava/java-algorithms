package com.github.shuvava.problems.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RotateMatrixTest {

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

  @DisplayName("matrix rotation")
  @ParameterizedTest(name = "run #{index}")
  @CsvSource(value = {
      "1,2,3,4;5,6,7,8;9,10,11,12;13,14,15,16| 13,9,5,1;14,10,6,2;15,11,7,3;16,12,8,4",
      "1|1"
  }, delimiter = '|')
  public void rotate(final String input, final String output) {
    // arrange
    int[][] matrix = parseToArrayOfArray(input);
    int[][] expected = parseToArrayOfArray(output);
    // act
    RotateMatrix.rotate(matrix);
    int[][] actual = matrix;

    assertArrayEquals(expected, actual);
  }
}
