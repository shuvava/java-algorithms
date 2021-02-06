package com.github.shuvava.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to
 * the integer. The digits are stored such that the most significant digit is at the head of the
 * list, and each element in the array contains a single digit. You may assume the integer does not
 * contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1: Input: digits = [1,2,3] Output: [1,2,4] Explanation: The array represents the integer
 * 123. Example 2: Input: digits = [4,3,2,1] Output: [4,3,2,2] Explanation: The array represents the
 * integer 4321. Example 3: Input: digits = [0] Output: [1] Constraints: 1 <= digits.length <= 100 0
 * <= digits[i] <= 9
 */
public class PlusOneArray {

  public static List<Integer> plusOne(List<Integer> digits) {
    boolean shift = false;

    for (int i = digits.size() - 1; i >= 0; i--) {
      var val = digits.get(i);
      if (val == 9) {
        digits.set(i, 0);
        shift = true;
      } else {
        digits.set(i, val + 1);
        return digits;
      }
    }

    if (shift) {
      var result = new ArrayList<Integer>();
      result.add(1);
      result.addAll(digits);
      return result;
    } else {
      return digits;
    }
  }
}
