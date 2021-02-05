package com.github.shuuvava.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.shuvava.testcommon.BaseTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ContainsDuplicateTest extends BaseTest {

  @DisplayName("Check array contains duplicate")
  @ParameterizedTest(name = "test #{index}")
  @CsvSource(value = {
    "1,2,3,1 | true",
    "1,2,3,4 | false",
    "1,1,1,3,3,4,3,2,4,2 | true",
  }, delimiter = '|')
  public void CheckArray(final String arrStr, final boolean expected) {
    List<Integer> arr = parseArray(arrStr);

    var actual = ContainsDuplicate.ArrayContainsDuplicate(arr);

    assertEquals(expected, actual);
  }

  @DisplayName("Check array contains duplicate optimized version")
  @ParameterizedTest(name = "test #{index}")
  @CsvSource(value = {
    "1,2,3,1 | true",
    "1,2,3,4 | false",
    "1,1,1,3,3,4,3,2,4,2 | true",
  }, delimiter = '|')
  public void CheckArray2(final String arrStr, final boolean expected) {
    List<Integer> arr = parseArray(arrStr);

    var actual = ContainsDuplicate.ArrayContainsDuplicateOptimized(arr);

    assertEquals(expected, actual);
  }
}
