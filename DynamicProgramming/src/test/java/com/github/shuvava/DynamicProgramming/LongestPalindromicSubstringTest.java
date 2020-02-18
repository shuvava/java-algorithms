package com.github.shuvava.DynamicProgramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class LongestPalindromicSubstringTest {

  @DisplayName("Length of the longest palindrome")
  @ParameterizedTest(name = "run #{index} with [{arguments}]")
  @CsvSource({"babad, bab", "cbbd, bb"})
  public void longestPalindrome(String s, String expected) {
    var instance = new LongestPalindromicSubstring();
    String actual = instance.longestPalindrome(s);
    assertEquals(expected, actual);
  }

}
