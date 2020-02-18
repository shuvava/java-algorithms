package com.github.shuvava.problems.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LengthOfLongestSubstringTest {

  @DisplayName("Length of the longest substring")
  @ParameterizedTest(name = "run #{index} with [{arguments}]")
  @CsvSource({"abcabcbb, 3", "bbbbb, 1", "pwwkew, 3"})
  public void lengthOfLongestSubstring(String s, int expected) {
    LengthOfLongestSubstring instance = new LengthOfLongestSubstring();
    int actual = instance.lengthOfLongestSubstring(s);
    assertEquals(expected, actual);
  }
}
