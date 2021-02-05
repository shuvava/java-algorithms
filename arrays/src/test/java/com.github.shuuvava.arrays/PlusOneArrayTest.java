package com.github.shuuvava.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.github.shuvava.testcommon.BaseTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlusOneArrayTest extends BaseTest {
  @DisplayName("Check plus one operation")
  @ParameterizedTest(name = "test #{index}")
  @CsvSource(value = {
    "9 | 1, 0",
    "1, 2, 3 | 1, 2, 4",
    "4, 3, 2, 1 | 4, 3, 2, 2",
    "0 | 1",
  }, delimiter = '|')
  public void plusOne(final String strDigits, final String strExpected) {
    ArrayList<Integer> digits = parseArray(strDigits);
    ArrayList<Integer> expected = parseArray(strExpected);

    var actual = PlusOneArray.plusOne(digits);

    assertArrayEquals(expected.toArray(), actual.toArray());
  }
}
