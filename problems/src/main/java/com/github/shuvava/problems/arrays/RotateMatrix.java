package com.github.shuvava.problems.arrays;

/**
 * ou are given an n x n 2D matrix representing an image.
 *
 * <p>Rotate the image by 90 degrees (clockwise).
 *
 * <p>Note:
 *
 * <p>You have to rotate the image in-place,
 * which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix
 * and do the rotation.
 * <p>
 * https://leetcode.com/problems/rotate-image/
 */
public class RotateMatrix {

  public static void rotate(int[][] matrix) {
    int levels = matrix.length / 2;
    int len = matrix.length - 1;
    for (int level = 0; level < levels; level++) {
      int items = len - 2 * level;
      for (int i = 0; i < items; i++) {
        int x0 = level, y0 = i + level;
        int x1 = level + i, y1 = len - level;
        int x2 = len - level, y2 = len - (i + level);
        int x3 = len - (i + level), y3 = level;
        int tmp = matrix[x0][y0];
        matrix[x0][y0] = matrix[x3][y3];
        matrix[x3][y3] = matrix[x2][y2];
        matrix[x2][y2] = matrix[x1][y1];
        matrix[x1][y1] = tmp;
      }
    }
  }
}
