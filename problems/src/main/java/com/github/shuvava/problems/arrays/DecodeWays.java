package com.github.shuvava.problems.arrays;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * <p>'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given a non-empty string containing only digits, determine
 * the
 * total number of ways to decode it.
 *
 * <p>Example 1:
 *
 * <p>Input: "12" Output: 2 Explanation: It could be decoded as "AB" (1 2) or "L" (12). Example 2:
 *
 * <p>Input: "226" Output: 3 Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF"
 * (2 2 6).
 */
public class DecodeWays {

  public int numDecodings(String s) {
    int[] counts = new int[s.length() + 1];
    int[] ints = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      ints[i] = Character.getNumericValue(s.charAt(i));
    }
    counts[counts.length - 1] = 1;
    for (int i = ints.length - 1; i >= 0; i--) {
      if (ints[i] > 0) {
        if (i + 1 < ints.length && (ints[i] < 2 || ints[i] == 2 && ints[i + 1] < 7)) {
          counts[i] = counts[i + 1] + counts[i + 2];
        } else {
          counts[i] = counts[i + 1];
        }
      }
    }
    return counts[0];
  }
}
