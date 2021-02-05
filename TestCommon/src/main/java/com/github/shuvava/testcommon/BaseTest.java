package com.github.shuvava.testcommon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
 * https://www.geeksforgeeks.org/array-vs-arraylist-in-java/
 * https://www.geeksforgeeks.org/difference-between-list-and-arraylist-in-java/
 * The List is a child interface of Collection.
 * It is an ordered collection of objects in which duplicate values can be stored.
 * Since List preserves the insertion order,
 * it allows positional access and insertion of elements.
 * List interface is implemented by the classes of
 *     ArrayList, LinkedList, Vector and Stack.
 */

public abstract class BaseTest {

  protected static List<List<Integer>> parseToArrayOfArray(String input) {
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
        .map(Integer::parseInt)
        .collect(ArrayList<Integer>::new, ArrayList::add, ArrayList::addAll)
      )
      .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
  }

  protected static List<Integer> parseArray(String input) {
    if (input == null) {
      return new ArrayList<>();
    }
    return Stream
      .of(
        input.split(",")
      )
      .map(String::trim)
      .mapToInt(Integer::parseInt)
      .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
  }

  protected static List<List<Character>> parseArrayOfArrayOfChar(String input) {
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
        .map(c -> c.charAt(0))
        .collect(ArrayList<Character>::new, ArrayList::add, ArrayList::addAll)
      )
      .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
  }
}
