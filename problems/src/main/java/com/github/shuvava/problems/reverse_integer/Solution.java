package com.github.shuvava.problems.reverse_integer;

public class Solution {

  public String reverseString(String str) {
    byte[] bytes = str.getBytes();
    int max = bytes.length / 2;
    for (int i = 0; i < max; i++) {
      byte x = bytes[i];
      byte y = bytes[bytes.length - i - 1];
      // swap >>>>
      x = (byte) (x ^ y);
      y = (byte) (x ^ y);
      x = (byte) (x ^ y);
      // swap <<<<
      bytes[i] = x;
      bytes[bytes.length - i - 1] = y;
    }
    return new String(bytes);
  }

  public int reverse(int x) {
    boolean lessZero = false;
    if (x < 0) {
      lessZero = true;
      x = -x;
    }
    String str = reverseString(Integer.toString(x));
    try {
      int result = Integer.parseInt(str);
      if (lessZero) {
        result = -result;
      }
      return result;
    } catch (NumberFormatException ex) {
      return 0;
    }
  }
}
