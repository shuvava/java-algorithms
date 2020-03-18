package com.github.shuvava.problems.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

  private static String sortString(String str) {
    char[] arr = str.toCharArray();
    Arrays.sort(arr);
    return new String(arr);
  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> groups = new HashMap<>();
    for (String s : strs) {
      String key = sortString(s);
      List<String> group = groups.get(key);
      if (group == null) {
        group = new ArrayList<>();
        groups.put(key, group);
      }
      group.add(s);
    }
    return new ArrayList<>(groups.values());
  }
}
