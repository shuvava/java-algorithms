package com.github.shuvava.problems.arrays;

/**
 * * Given an array of integers nums sorted in ascending order, find the starting and ending
 * position of a given target value.
 *
 * <p>Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * <p>If the target is not found in the array, return [-1, -1].
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:
 *
 * <p>Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]
 */
public class FindFirstLastPositionsInSortedArray {

  public int[] searchRange(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = (high + low) >> 1;
      if (nums[mid] == target) {
        low = mid - 1;
        high = mid + 1;
        while (low >= 0 && nums[low] == target) {
          low -= 1;
        }
        while (high < nums.length && nums[high] == target) {
          high += 1;
        }
        low += 1;
        high -= 1;
        return new int[]{low, high};
      }
      if (nums[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return new int[]{-1, -1};
  }
}
