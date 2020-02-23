package com.github.shuvava.problems.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * <p>Note:
 *
 * <p>The solution set must not contain duplicate triplets.
 *
 * <p>Example:
 *
 * <p>Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * <p>A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * <p>
 * <p>
 * Links: https://stackoverflow.com/questions/81346/most-efficient-way-to-increment-a-map-value-in-java
 */
class MutableInt {

  int value = 1; // note that we start at 0 since we're counting

  public void increment() {
    ++value;
  }

  public int get() {
    return value;
  }
}

public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    if (nums == null || nums.length < 3) {
      return Collections.emptyList();
    }
    Map<Integer, MutableInt> hash = new HashMap<>();
    for (int num : nums) {
      MutableInt count = hash.get(num);
      if (count == null) {
        hash.put(num, new MutableInt());
      } else {
        count.increment();
      }
    }
    Set<List<Integer>> set = new HashSet<>();
    for (int x : hash.keySet()) {
      for (int y : hash.keySet()) {
        int z = -(x + y);
        MutableInt cnt = hash.get(z);
        if (cnt == null) {
          continue;
        }
        if (x == y && y == z && cnt.get() < 3) {
          continue;
        }
        if (z == y && cnt.get() < 2) {
          continue;
        }
        if (z == x && cnt.get() < 2) {
          continue;
        }
        cnt = hash.get(x);
        if (x == y && cnt.get() < 2) {
          continue;
        }
        List<Integer> items = Stream.of(x, y, z)
            .sorted()
            .collect(Collectors.toList());
        set.add(items);
      }
    }
    return new ArrayList<>(set);
  }
}
