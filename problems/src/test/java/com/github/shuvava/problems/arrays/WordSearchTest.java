package com.github.shuvava.problems.arrays;

import com.github.shuvava.problems.TestHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WordSearchTest {

  @DisplayName("array all possible subsets")
  @ParameterizedTest(name = "run #{index}")
  @CsvSource(value = {
      "A,B,C,E;S,F,E,S;A,D,E,E| ABCESEEEFS| true",
      "a,a| aaa| false",
  }, delimiter = '|')
  public void exist(final String input, final String word, final boolean expected) {
    //arrange
    char[][] board = TestHelper.parseStringOfChar(input);
    var instance = new WordSearch();
    //act
    boolean actual = instance.exist(board, word);

    Assertions.assertEquals(expected, actual);
  }
}
