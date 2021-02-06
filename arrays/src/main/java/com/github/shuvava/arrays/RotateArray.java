package com.github.shuvava.arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Follow up:
 * <p>
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this
 * problem. Could you do it in-place with O(1) extra space?
 * <p>
 * <p>
 * Example 1: Input: nums = [1,2,3,4,5,6,7], k = 3 Output: [5,6,7,1,2,3,4] Explanation: rotate 1
 * steps to the right: [7,1,2,3,4,5,6] rotate 2 steps to the right: [6,7,1,2,3,4,5] rotate 3 steps
 * to the right: [5,6,7,1,2,3,4] Example 2: Input: nums = [-1,-100,3,99], k = 2 Output:
 * [3,99,-1,-100] Explanation: rotate 1 steps to the right: [99,-1,-100,3] rotate 2 steps to the
 * right: [3,99,-1,-100]
 */
public class RotateArray {

    /***
     * rotate right array with O(n) space complicity
     * @param arr test array
     * @param k number of index to rotate
     * @param <T> array type
     * @return rotated array
     */
    public static <T> List<T> rotateArrayOnSpace(List<T> arr, int k) {
        var result = new ArrayList<T>(Collections.nCopies(arr.size(), null));
        var rotations = k % arr.size();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.size() - rotations + i < arr.size()) {
                result.set(i, arr.get(arr.size() - rotations + i));
            }
            if (i + rotations < arr.size()) {
                result.set(i + rotations, arr.get(i));
            }
        }
        return result;
    }

    /**
     * rotate right array in place with O(1) space complicity
     *
     * @param arr test array
     * @param k   number of index to rotate
     * @param <T> array type
     */
    public static <T> void rotateArrayO1Space(List<T> arr, int k) {
        var len = arr.size();
        var rotations = k % len;
        var gcd = BigInteger
            .valueOf(rotations)
            .gcd(BigInteger
                .valueOf(len))
            .intValue();
        for (int j = 0; j < gcd; j++) {
            var i = rotations + j;
            var temp = arr.get(j);
            while (i != j) {
                var swap = arr.get(i);
                arr.set(i, temp);
                temp = swap;
                i = (i + rotations) % len;
            }
            arr.set(i, temp);
        }
    }
}
