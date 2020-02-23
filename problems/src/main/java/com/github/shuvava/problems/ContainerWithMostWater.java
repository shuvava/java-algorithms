package com.github.shuvava.problems;

/**
 * https://leetcode.com/problems/container-with-most-water/
 *
 * <p>Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate
 * (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i,
 * 0). Find two lines, which together with x-axis forms a container, such that the container
 * contains the most water.
 *
 * <p>Note: You may not slant the container and n is at least 2. Example:
 *
 * <p>Input: [1,8,6,2,5,4,8,3,7] Output: 49
 *
 * <p>Solution
 *
 * <p>The intuition behind this approach is that the area formed between the lines will always be
 * limited by the height of the shorter line. Further, the farther the lines, the more will be the
 * area obtained.
 *
 * <p>We take two pointers, one at the beginning and one at the end of the array constituting the
 * length of the lines. Futher, we maintain a variable maxarea to store the maximum area obtained
 * till now. At every step, we find out the area formed between them, update maxarea and move the
 * pointer pointing to the shorter line towards the other end by one step.
 *
 * <p>Complexity Analysis
 *
 * <p>Time complexity : O(n). Single pass. Space complexity : O(1). Constant space is used.
 */
public class ContainerWithMostWater {

  public int maxArea(int[] height) {
    if (height == null) {
      return 0;
    }
    int left = 0;
    int right = height.length - 1;
    if (right < 1) {
      return 0;
    }
    int maxArea = 0;
    int maxY = 0;
    int x = right + 1;
    while (left < right) {
      x -= 1;
      int y = height[left];
      if (height[right] < y) {
        y = height[right];
        right -= 1;
      } else {
        left += 1;
      }
      if (maxY < y) {
        maxY = y;
        int area = y * x;
        if (area > maxArea) {
          maxArea = area;
        }
      }
    }
    return maxArea;
  }
}
