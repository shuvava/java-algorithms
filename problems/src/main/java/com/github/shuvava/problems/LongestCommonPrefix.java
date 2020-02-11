package com.github.shuvava.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class LongestCommonPrefix {

  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    if (Arrays.stream(strs).anyMatch(Objects::isNull)) {
      return "";
    }
    StringBuilder result = new StringBuilder();
    int inx = 0;
    int maxInx = Arrays.stream(strs).min(Comparator.comparingInt(String::length)).get().length();
    while (inx < maxInx) {
      for (int i = 1; i < strs.length; i++) {
        if (strs[i - 1].charAt(inx) != strs[i].charAt(inx)) {
          return result.toString();
        }
      }
      result.append(strs[0].charAt(inx));
      inx += 1;
    }
    return result.toString();
  }
}
