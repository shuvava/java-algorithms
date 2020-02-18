package com.github.shuvava.DynamicProgramming;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum
 * length of s is 1000.
 *
 * <p>Example 1:
 *
 * <p>Input: "babad" Output: "bab" Note: "aba" is also a valid answer. Example 2:
 *
 * <p>Input: "cbbd" Output: "bb"
 */


public class LongestPalindromicSubstring {

  public String longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    int n = s.length();
    int start = 0;
    int maxLength = 1;
    boolean[][] table = new boolean[n][n];
    // All substrings of length 1 are palindromes
    for (int i = 0; i < n; i++) {
      table[i][i] = true;
    }
    // check sub-string of length 2
    for (int i = 0; i < n - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        table[i][i + 1] = true;
        if (maxLength < 2) {
          start = i;
          maxLength = 2;
        }
      }
    }

    // Check ofr lengths greater than 2
    // k is length of substring
    int j;
    for (int k = 3; k <= n; k++) {
      for (int i = 0; i < (n - k + 1); i++) {
        // Get the ending index if substring from
        // starting index i and length k
        j = i + k - 1;
        // checking for sub-string from i index to j index
        // if s[i+1] to s[j-1] is a palindrome
        if (table[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
          table[i][j] = true;
          if (k > maxLength) {
            start = i;
            maxLength = k;
          }
        }
      }
    }
    return s.substring(start, start + maxLength);
  }
}
