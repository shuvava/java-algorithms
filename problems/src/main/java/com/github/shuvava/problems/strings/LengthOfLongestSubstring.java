package com.github.shuvava.problems.strings;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> cset = new HashMap<>();
    int maxLen = 0;
    StringBuilder subString = new StringBuilder();
    char[] chars = s.toCharArray();
    for (char c : chars) {
      if (cset.containsKey(c)) {
        if (subString.length() > maxLen) {
          maxLen = subString.length();
        }
        int inx = cset.get(c);
        for (int i = 0; i <= inx; i++) {
          cset.remove(subString.charAt(0));
          subString.deleteCharAt(0);
        }
        cset.forEach((k, v) -> cset.replace(k, v - inx - 1));
      }
      cset.put(c, subString.length());
      subString.append(c);
    }
    if (subString.length() > maxLen) {
      maxLen = subString.length();
    }
    return maxLen;
  }
}
