package com.github.shuvava.problems.romanToInteger;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

  Map<String, Integer> Mapper = new HashMap<>() {{
    put("I", 1);
    put("II", 2);
    put("III", 3);
    put("IV", 4);
    put("V", 5);
    put("VI", 6);
    put("VII", 7);
    put("VIII", 8);
    put("IX", 9);
    put("X", 10);
    put("XX", 20);
    put("XXX", 30);
    put("XL", 40);
    put("L", 50);
    put("LX", 60);
    put("LXX", 70);
    put("LXXX", 80);
    put("XC", 90);
    put("C", 100);
    put("CC", 200);
    put("CCC", 300);
    put("CD", 400);
    put("D", 500);
    put("DC", 600);
    put("DCC", 700);
    put("DCCC", 800);
    put("CM", 900);
    put("M", 1000);
  }};

  public int romanToInt(String s) {
    if (s == null) {
      return 0;
    }
    int result = 0;
    while (s.length() > 0) {
      for (int i = 4; i > 0; i--) {
        if (i > s.length()) {
          continue;
        }
        String subStr = s.substring(0, i);
        if (Mapper.containsKey(subStr)) {
          result += Mapper.get(subStr);
          s = s.substring(i);
          break;
        }
      }
    }
    return result;
  }
}
