package com.github.shuvava.problems.bst;

import com.github.shuvava.problems.TestHelper;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidateBSTTest {

  @DisplayName("bst validation")
  @ParameterizedTest(name = "bst [{0}] should return {1}")
  @CsvSource(value = {
      "24, -60, null, -60, -6| false",
      "0, null, -1| false",
      "2,1,3| true",
      "10, 5, 15, null, null, 6, 20|false",
      "2147483647| true"
  }, delimiter = '|')
  public void isValidBST(final String input, final boolean expected) {
    // arrange
    List<Integer> arr = TestHelper.parseToList(input);
    var instance = new ValidateBST();
    TreeNode root = new CreateBST().createBST(arr);
    //act
    boolean actual = instance.isValidBST(root);
    //assert
    Assertions.assertEquals(expected, actual);
  }
}
