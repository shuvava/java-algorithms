package com.github.shuvava.problems.greedyAlgorithms.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * links: * https://www.baeldung.com/java-array-permutations * https://en.wikipedia.org/wiki/Heap%27s_algorithm
 */
public class ArrayPermutation {

  private static void swap(int[] input, int a, int b) {
    int tmp = input[a];
    input[a] = input[b];
    input[b] = tmp;
  }

  private static void doPermutationRecursive(List<List<Integer>> res, int n, int[] elements) {
    if (n == 1) {
      res.add(Arrays.stream(elements).boxed().collect(Collectors.toList()));
    } else {
      for (int i = 0; i < n - 1; i++) {
        doPermutationRecursive(res, n - 1, elements);
        if (n % 2 == 0) {
          swap(elements, i, n - 1);
        } else {
          swap(elements, 0, n - 1);
        }
      }
      doPermutationRecursive(res, n - 1, elements);
    }
  }

  public static List<List<Integer>> permuteRecursive(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    doPermutationRecursive(res, nums.length, nums);
    return res;
  }

  public static List<List<Integer>> permuteIterative(int[] elements) {
    List<List<Integer>> res = new ArrayList<>();

    int n = elements.length;
    int[] indexes = new int[n];
    for (int i = 0; i < n; i++) {
      indexes[i] = 0;
    }

    res.add(Arrays.stream(elements).boxed().collect(Collectors.toList()));

    int i = 0;
    while (i < n) {
      if (indexes[i] < i) {
        swap(elements, i % 2 == 0 ? 0 : indexes[i], i);
        res.add(Arrays.stream(elements).boxed().collect(Collectors.toList()));
        indexes[i] += 1;
        i = 0;
      } else {
        indexes[i] = 0;
        i += 1;
      }
    }
    return res;
  }
}
