package com.github.shuvava.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * <p>Example 1:
 *
 * <p>Input: [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]] Explanation: Since
 * intervals [1,3] and [2,6] overlaps, merge them into [1,6]. Example 2:
 *
 * <p>Input: [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4] and [4,5] are considered
 * overlapping.
 */
public class MergeIntervals {

  public int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return new int[0][];
    }
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    List<int[]> res = new ArrayList<>();
    res.add(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {
      int il = intervals[i][0];
      int ih = intervals[i][1];
      int[] el = res.get(res.size() - 1);
      int h = el[1];
      if (il <= h) {
        h = Integer.max(ih, h);
        el[1] = h;
      } else {
        res.add(new int[]{il, ih});
      }
    }
    return res.toArray(int[][]::new);
  }
}
