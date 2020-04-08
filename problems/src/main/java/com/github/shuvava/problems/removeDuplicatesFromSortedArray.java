package com.github.shuvava.problems;

public class removeDuplicatesFromSortedArray {

  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int inx = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[inx - 1] != nums[i]) {
        nums[inx] = nums[i];
        inx += 1;
      }
    }
    return inx;
  }
}
