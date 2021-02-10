package com.github.shuvava.problems.bst;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.github.shuvava.problems.TestHelper;
import com.github.shuvava.testcommon.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ConvertToGreaterTreeTest extends BaseTest {

  @DisplayName("bst convertBST")
  @ParameterizedTest(name = "bst [{0}] should return {1}")
  @CsvSource(value = {
    "3, 2, 4, 1 | 7, 9, 4, 10",
    "1, 0, 2 | 3, 3, 2",
    "0, null, 1 | 1, null, 1",
  }, delimiter = '|')
  public void convertBST(final String input, final String expectedStr) {
    // arrange
    var arr = TestHelper.parseToList(input);
    var expected = TestHelper.parseToList(expectedStr);
    var root = CreateBST.createBST(arr);

    root = ConvertToGreaterTree.convertBST(root);
    var actual = CreateBST.convertToList(root);

    assertArrayEquals(expected.toArray(), actual.toArray());
  }
}
