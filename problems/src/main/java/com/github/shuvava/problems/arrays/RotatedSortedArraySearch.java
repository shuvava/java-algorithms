package com.github.shuvava.problems.arrays;

public class RotatedSortedArraySearch {

  public int getPivot(int[] nums) {
    int low = 0;
    int high = nums.length - 1;
    while (low < high) {
      if (low + 1 == high && nums[low] > nums[high]) {
        return high;
      }
      int mid = (high + low) >> 1;
      if (nums[mid] > nums[high]) {
        low = mid;
      } else {
        high = mid;
      }
    }
    return 0;
  }

  public int search(int[] nums, int target) {
    if (nums == null) {
      return -1;
    }
    int pivot = nums.length - getPivot(nums);
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = ((high + low) >> 1) - pivot;
      int midInx = mid < 0 ? nums.length + mid : mid;
      if (nums[midInx] == target) {
        return midInx;
      }
      if (nums[midInx] > target) {
        high = mid + pivot - 1;
      } else {
        low = mid + pivot + 1;
      }
    }
    return -1;
  }
}
