package com.github.shuvava.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidSudokuTest {

  private static char[][] parseString(String input) {
    if (input == null) {
      return new char[0][0];
    }
    List<char[]> data = new ArrayList<>();
    for (String line : input.split(";")) {
      List<Character> arr = new ArrayList<>();
      for (String chr : line.split(",")) {
        arr.add(chr.trim().charAt(0));
      }
      data.add(ArrayUtils.toPrimitive(arr.toArray(Character[]::new)));
    }

    return data.toArray(char[][]::new);
  }

  @DisplayName("Validate sudoku")
  @ParameterizedTest(name = "run #{index} should return [{1}]")
  @CsvSource(
      value = {
          "5,3,.,.,7,.,.,.,.;"
              + "6,.,.,1,9,5,.,.,.;"
              + ".,9,8,.,.,.,.,6,.;"
              + "8,.,.,.,6,.,.,.,3;"
              + "4,.,.,8,.,3,.,.,1;"
              + "7,.,.,.,2,.,.,.,6;"
              + ".,6,.,.,.,.,2,8,.;"
              + ".,.,.,4,1,9,.,.,5;"
              + ".,.,.,.,8,.,.,7,9 | true",

          "8,3,. ,.,7,. ,.,.,.;"
              + "6,.,. ,1,9,5 ,.,.,.;"
              + ".,9,8 ,.,.,. ,.,6,.;"
              + "8,.,. ,.,6,. ,.,.,3;"
              + "4,.,. ,8,.,3 ,.,.,1;"
              + "7,.,. ,.,2,. ,.,.,6;"
              + ".,6,. ,.,.,. ,2,8,.;"
              + ".,.,. ,4,1,9 ,.,.,5;"
              + ".,.,. ,.,8,. ,.,7,9 | false"
      },
      delimiter = '|')
  public void isValidSudoku(final String input, final boolean expected) {
    //arrange
    char[][] data = parseString(input);
    var instance = new ValidSudoku();
    //act
    boolean actual = instance.isValidSudoku(data);

    assertEquals(expected, actual);
  }
}
