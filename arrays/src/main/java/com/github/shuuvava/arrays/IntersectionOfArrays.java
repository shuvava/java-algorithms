package com.github.shuuvava.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2,2] Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] Output: [4,9] Note:
 * <p>
 * Each element in the result should appear as many times as it shows in both arrays. The result can
 * be in any order. Follow up:
 * <p>
 * What if the given array is already sorted? How would you optimize your algorithm? What if nums1's
 * size is small compared to nums2's size? Which algorithm is better? What if elements of nums2 are
 * stored on disk, and the memory is limited such that you cannot load all elements into the memory
 * at once?
 */
public class IntersectionOfArrays {

  public static <T extends Comparable<T>> ArrayList<T> GetIntersection(ArrayList<T> nums1,
    ArrayList<T> nums2) {
    Collections.sort(nums1);
    Collections.sort(nums2);

    if (nums1.size() == 0 || nums2.size() == 0) {
      return new ArrayList<>();
    }

    int inx1 = 0;
    int inx2 = 0;
    var result = new ArrayList<T>();

    while (inx1 < nums1.size() && inx2 < nums2.size()) {
      var val1 = nums1.get(inx1);
      var val2 = nums2.get(inx2);
      if (val1 == val2) {
        result.add(val1);
        inx1 += 1;
        inx2 += 1;
      } else if (val2.compareTo(val1) > 0) {
        inx1 += 1;
      } else {
        inx2 += 1;
      }
    }

    return result;
  }
}
