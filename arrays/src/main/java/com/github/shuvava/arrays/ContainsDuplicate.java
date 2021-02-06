package com.github.shuvava.arrays;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * <p>
 * Your function should return true if any value appears at least twice in the array, and it should
 * return false if every element is distinct.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1] Output: true Example 2:
 * <p>
 * Input: [1,2,3,4] Output: false Example 3:
 * <p>
 * Input: [1,1,1,3,3,4,3,2,4,2] Output: true
 */
public class ContainsDuplicate {

  /**
   * check if array has duplicates with O(n) time complexity and O(n) memory
   *
   * @param nums array
   * @param <T> any type
   * @return True if array has duplicate
   */
  public static <T> Boolean ArrayContainsDuplicate(List<T> nums) {
    Set<T> map = new HashSet<>();
    for (T item : nums) {
      if (map.contains(item)) {
        return true;
      }
      map.add(item);
    }

    return false;
  }

  /**
   * check if array has duplicates with O(n*log(n)) time complexity and O(1) memory with data
   * structure mutation
   *
   * @param nums array
   * @param <T>  any Comparable type
   * @return True if array has duplicate
   */
  public static <T extends Comparable<T>> Boolean ArrayContainsDuplicateOptimized(
    List<T> nums) {
    if (nums.size() < 2) {
      return false;
    }

    Collections.sort(nums);

    for (int i = 0; i < nums.size() - 1; i++) {
      if (nums.get(i) == nums.get(i + 1)) {
        return true;
      }
    }

    return false;
  }
}
