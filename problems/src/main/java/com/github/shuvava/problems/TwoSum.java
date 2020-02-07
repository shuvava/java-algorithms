package com.github.shuvava.problems;

import java.util.Hashtable;

public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    Hashtable<Integer, Integer> hash = new Hashtable<>();
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
