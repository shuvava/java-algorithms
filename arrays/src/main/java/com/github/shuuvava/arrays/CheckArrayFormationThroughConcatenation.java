package com.github.shuuvava.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an array of distinct integers arr and an array of integer arrays pieces, where the
 * integers in pieces are distinct. Your goal is to form arr by concatenating the arrays in pieces
 * in any order. However, you are not allowed to reorder the integers in each array pieces[i].
 * <p>
 * Return true if it is possible to form the array arr from pieces. Otherwise, return false.
 * <p>
 * Example 1: Input: arr = [85], pieces = [[85]] Output: true` Example 2: Input: arr = [15,88],
 * pieces = [[88],[15]] Output: true Explanation: Concatenate [15] then [88] Example 3: Input: arr =
 * [49,18,16], pieces = [[16,18,49]] Output: false Explanation: Even though the numbers match, we
 * cannot reorder pieces[0]. Example 4: Input: arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
 * Output: true Explanation: Concatenate [91] then [4,64] then [78] Example 5: Input: arr =
 * [1,3,5,7], pieces = [[2,4,6,8]] Output: false
 * <p>
 * Constraints: 1 <= pieces.length <= arr.length <= 100 sum(pieces[i].length) == arr.length 1 <=
 * pieces[i].length <= arr.length 1 <= arr[i], pieces[i][j] <= 100 The integers in arr are distinct.
 * The integers in pieces are distinct (i.e., If we flatten pieces in a 1D array, all the integers
 * in this array are distinct).
 */
public class CheckArrayFormationThroughConcatenation {

    private static int FindPiece(Map<Integer, Integer> s, int item) {
        return s.getOrDefault(item, -1);
    }

    public static boolean Test(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> pieces) {
        var s = new HashMap<Integer, Integer>();
        for (Integer value : arr) {
            for (int iPieces = 0; iPieces < pieces.size(); iPieces++) {
                if (pieces.get(iPieces).get(0).equals(value)) {
                    s.put(value, iPieces);
                }
            }
        }

        var iPiece = FindPiece(s, arr.get(0));
        var iLen = -1;
        var inx = 0;
        if (iPiece > -1) {
            iLen = pieces.get(iPiece).size();
        }

        for (Integer integer : arr) {
            if (iPiece == -1) {
                return false;
            } else if (inx >= iLen) {
                iPiece = FindPiece(s, integer);
                if (iPiece > -1) {
                    iLen = pieces.get(iPiece).size();
                    inx = 1;
                }
            } else {
                if (integer != pieces.get(iPiece).get(inx)) {
                    return false;
                }
                inx += 1;
            }
        }

        return true;
    }
}
