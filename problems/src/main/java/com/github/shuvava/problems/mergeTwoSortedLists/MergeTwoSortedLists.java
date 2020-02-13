package com.github.shuvava.problems.mergeTwoSortedLists;

public class MergeTwoSortedLists {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    ListNode root = null;
    ListNode current = null;
    ListNode smallest = null;
    while (l1 != null && l2 != null) {
      smallest = l1;
      if (l2.val < smallest.val) {
        smallest = l2;
        l2 = l2.next;
      } else {
        l1 = l1.next;
      }
      if (root == null) {
        root = smallest;
        current = smallest;
      } else {
        current.next = smallest;
        current = smallest;
      }
    }
    while (l1 != null) {
      current.next = l1;
      current = l1;
      l1 = l1.next;
    }
    while (l2 != null) {
      current.next = l2;
      current = l2;
      l2 = l2.next;
    }
    return root;
  }
}
