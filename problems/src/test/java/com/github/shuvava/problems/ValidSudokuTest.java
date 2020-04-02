package com.github.shuvava.problems;

import static com.github.shuvava.problems.TestHelper.parseStringOfChar;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidSudokuTest {



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
    char[][] data = parseStringOfChar(input);
    var instance = new ValidSudoku();
    //act
    boolean actual = instance.isValidSudoku(data);

    assertEquals(expected, actual);
  }
}
