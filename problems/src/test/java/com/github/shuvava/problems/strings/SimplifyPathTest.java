package com.github.shuvava.problems.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SimplifyPathTest {

  @DisplayName("Simplify Path")
  @ParameterizedTest(name = "run #{index} should return [{1}]")
  @CsvSource(
    value = {
      "/../ | /",
      "/home/ | /home",
      "/home//foo/ | /home/foo",
      "/a/./b/../../c/ | /c",
    },
    delimiter = '|')
  public void simplifyPathTest(final String path, final String expected) {
    var actual = SimplifyPath.simplifyPath(path);

    assertEquals(expected, actual);
  }
}
