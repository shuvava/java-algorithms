package com.github.shuvava.problems.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * <p>Note: The solution set must not contain duplicate subsets.
 *
 * <p>Example:
 *
 * <p>Input: nums = [1,2,3] Output: [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 */
public class SubSets {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    res.add(new ArrayList<>());
    List<List<Integer>> temp;
    for (int e : nums) {
      temp = new ArrayList<>();
      for (List<Integer> ss : res) {
        List<Integer> ssCopy = new ArrayList<>();
        ss.forEach(s -> ssCopy.add(s));
        ssCopy.add(e);
        temp.add(ssCopy);
      }
      temp.forEach(item -> res.add(item));
    }
    return res;
  }
}
