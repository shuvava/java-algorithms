package com.github.shuvava.problems.linkedLists;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RemoveNthNodeFromEndOfListTest {

  private static List<Integer> parseString(String input) {
    if (input == null) {
      return Collections.emptyList();
    }
    return Stream
        .of(
            input.split(",")
        )
        .map(String::trim)
        .mapToInt(Integer::parseInt)
        .boxed()
        .collect(Collectors.toList());
  }

  @DisplayName("Remove Nth node from end")
  @ParameterizedTest(name = "n = {1} input [{0}] should return [{2}]")
  @CsvSource(value = {
      "1, 2, 3, 4, 5| 2 | 1, 2, 3, 5",
      "1| 1| ",
      "1,2|2|2",
      "1,2|3|1,2"
  }, delimiter = '|')
  public void removeNthFromEnd(final String input, final int n, final String output) {
    // arrange
    ListNode root = createLinkedList(parseString(input));
    List<Integer> expected = parseString(output);
    var instance = new RemoveNthNodeFromEndOfList();
    //act
    var result = instance.removeNthFromEnd(root, n);
    List<Integer> actual = toList(result);

    assertEquals(expected, actual);
  }

  private ListNode createLinkedList(List<Integer> testCase) {
    ListNode node = null;
    ListNode root = null;
    for (int i : testCase) {
      if (root == null) {
        root = new ListNode(i);
        node = root;
      } else {
        node.next = new ListNode(i);
        node = node.next;
      }
    }
    return root;
  }

  private List<Integer> toList(ListNode head) {
    List<Integer> arr = new ArrayList<>();
    while (head != null) {
      arr.add(head.val);
      head = head.next;
    }
    return arr;
  }
}
