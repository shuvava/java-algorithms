package com.github.shuvava.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.ArrayUtils;

public class TestHelper {

  public static int[] parseToArray(String input) {
    if (input == null) {
      return ArrayUtils.EMPTY_INT_ARRAY;
    }
    return Stream
        .of(
            input.split(",")
        )
        .map(String::trim)
        .mapToInt(Integer::parseInt)
        .toArray();
  }

  public static List<List<Integer>> parseToListOfList(String input) {
    if (input == null) {
      return new ArrayList<>();
    }
    return Stream
        .of(input.split(";"))
        .map(String::trim)
        .map(line -> Stream
            .of(
                line.split(",")
            )
            .map(String::trim)
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList())
        )
        .collect(Collectors.toList());
  }

  public static void sortCollection(List<List<Integer>> items) {
    Collections.sort(items, Comparator
        .comparingInt(a -> {
          var a1 = (List<Integer>) a;
          return a1.size() > 0 ? a1.get(0) : Integer.MIN_VALUE;
        })
        .thenComparing(a -> {
          var a1 = (List<Integer>) a;
          return a1.size();
        })
    );
  }

  public static char[][] parseStringOfChar(String input) {
    if (input == null) {
      return new char[0][0];
    }
    List<char[]> data = new ArrayList<>();
    for (String line : input.split(";")) {
      List<Character> arr = new ArrayList<>();
      for (String chr : line.split(",")) {
        arr.add(chr.trim().charAt(0));
      }
      data.add(ArrayUtils.toPrimitive(arr.toArray(Character[]::new)));
    }

    return data.toArray(char[][]::new);
  }
}
