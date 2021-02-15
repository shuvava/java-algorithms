package com.github.shuvava.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.shuvava.testcommon.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MatrixWeakestRowTest extends BaseTest {

  @DisplayName("The K Weakest Rows in a Matrix")
  @ParameterizedTest(name = "test #{index}")
  @CsvSource(value = {
      "1,1,0,0,0;" +
      "1,1,1,1,0;" +
      "1,0,0,0,0;" +
      "1,1,0,0,0;" +
      "1,1,1,1,1 | 3 | 2,0,3",
      "1,0,0,0;" +
      "1,1,1,1;" +
      "1,0,0,0;" +
      "1,0,0,0 | 2 | 0,2",
  }, delimiter = '|')
  public void kWeakestRows(final String matStr, final int k, final String expectedStr) {
    var mat = parseToArrayOfArray(matStr);
    var expected = parseArray(expectedStr);

    var actual = MatrixWeakestRow.kWeakestRows(mat, k);

    assertEquals(expected, actual);
  }
}
