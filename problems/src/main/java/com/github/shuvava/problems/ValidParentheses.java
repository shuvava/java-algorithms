package com.github.shuvava.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid.
 *
 * <p>An input string is valid if:
 *
 * <p>Open brackets must be closed by the same type of brackets. Open brackets must be closed in
 * the
 * correct order.
 *
 * <p>Note that an empty string is also considered valid.
 */
public class ValidParentheses {

  Map<Character, Character> Mapper = new HashMap<>() {{
    put('{', '}');
    put('(', ')');
    put('[', ']');
  }};

  public boolean isValid(String s) {
    if (s == null) {
      return false;
    }
    int i = 0;
    int h = s.length();
    char[] chars = s.toCharArray();
    Stack<Character> stack = new Stack<>();
    while (i < h) {
      char c = chars[i];
      if (Mapper.containsKey(c)) {
        stack.push(Mapper.get(c));
      } else if (stack.isEmpty()) {
        return false;
      } else {
        char expected = stack.pop();
        if (c != expected) {
          return false;
        }
      }
      i += 1;
    }
    return stack.isEmpty();
  }
}
