package com.github.shuvava.problems;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> hash = new HashMap<>();
    for (int i=0; i< nums.length; i++) {
      int val = nums[i];
      if (hash.containsKey(val)) {
        return new int[] {hash.get(val), i};
      }
      int diff = target - val;
      hash.put(diff, i);
    }
    return null;
  }
}
