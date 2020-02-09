package com.github.shuvava.problems.reverse_integer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SolutionTest {

  @Test
  public void reverseString(){
    String input = "GeeksforGeeks";
    Solution instance = new Solution();
    String result = instance.reverseString(input);
    assertEquals("skeeGrofskeeG", result);
  }
}
