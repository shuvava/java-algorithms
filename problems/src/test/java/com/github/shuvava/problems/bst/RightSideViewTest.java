package com.github.shuvava.problems.bst;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.github.shuvava.problems.TestHelper;
import com.github.shuvava.testcommon.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RightSideViewTest extends BaseTest {

  @DisplayName("bst validation")
  @ParameterizedTest(name = "bst [{0}] should return {1}")
  @CsvSource(value = {
    "1, 2, 3, null, 5, null, 4 | 1, 3, 4",
    "1, 2, 3, null, 4 | 1, 3, 4",
  }, delimiter = '|')
  public void rightSideView(final String input, final String expectedStr) {
    // arrange
    var arr = TestHelper.parseToList(input);
    var expected = parseArray(expectedStr);
    var root = new CreateBST().createBST(arr);
    //act
    var actual = RightSideView.rightSideView(root);

    assertArrayEquals(expected.toArray(), actual.toArray());
  }
}
