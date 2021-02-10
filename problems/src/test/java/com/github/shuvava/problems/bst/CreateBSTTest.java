package com.github.shuvava.problems.bst;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.github.shuvava.problems.TestHelper;
import com.github.shuvava.testcommon.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CreateBSTTest extends BaseTest {
  @DisplayName("bst creation")
  @ParameterizedTest(name = "bst [{0}] should return {1}")
  @CsvSource(value = {
    "1, 2, 3, null, 5, null, 4",
    "1, 2, 3, null, 4",
  }, delimiter = '|')
  public void createBST(final String input) {
    var arr = TestHelper.parseToList(input);
    var expected = TestHelper.parseToList(input);
    var root = CreateBST.createBST(arr);
    var actual = CreateBST.convertToList(root);

    assertArrayEquals(expected.toArray(), actual.toArray());
  }
}
