package com.github.shuuvava.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.shuvava.testcommon.BaseTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CheckArrayFormationThroughConcatenationTest extends BaseTest {

  @DisplayName("Check array formation through concatenation")
  @ParameterizedTest(name = "test #{index}")
  @CsvSource(value = {
    "85 | 85 | true",
    "15, 88 | 88; 15 | true",
    "49, 18, 16 | 16, 18, 49 | false",
    "91, 4, 64, 78 | 78; 4, 64; 91 | true",
    "1, 3, 5, 7 | 16, 18, 49 | false",
  }, delimiter = '|')
  public void CheckArray(final String arrStr, final String piecesStr, final boolean expected) {
    List<Integer> arr = parseArray(arrStr);
    List<List<Integer>> pieces = parseToArrayOfArray(piecesStr);

    boolean actual = CheckArrayFormationThroughConcatenation.Test(arr, pieces);

    assertEquals(expected, actual);
  }
}
