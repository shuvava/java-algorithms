package com.github.shuvava.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumber {

  final Map<Character, String> phone = new HashMap<>() {{
    put('2', "abc");
    put('3', "def");
    put('4', "ghi");
    put('5', "jkl");
    put('6', "mno");
    put('7', "pqrs");
    put('8', "tuv");
    put('9', "wxyz");
  }};

  public List<String> letterCombinations(String digits) {
    if (digits == null) {
      return Collections.emptyList();
    }
    List<String> currents = new ArrayList<>();
    for (int i = 0; i < digits.length(); i++) {
      char digit = digits.charAt(i);
      List<String> nexts = new ArrayList<>();
      String letters = phone.get(digit);
      if (letters == null) {
        continue;
      }
      for (int j = 0; j < letters.length(); j++) {
        char letter = letters.charAt(j);
        if (i == 0) {
          nexts.add(Character.toString(letter));
        } else {
          currents
              .forEach(item -> nexts.add(item + letter));
        }
      }
      currents = nexts;
    }
    return currents;
  }
}
