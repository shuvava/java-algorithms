package com.github.shuvava.problems.linkedLists;

public class RemoveNthNodeFromEndOfList {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) {
      return null;
    }
    if (n <= 0) {
      return head;
    }
    ListNode origin = head;
    ListNode nNode = head;
    int i = 0;
    while (head != null) {
      if (i > n) {
        nNode = nNode.next;
      } else {
        i += 1;
      }
      head = head.next;
    }
    if (nNode == origin && i == n) {
      return nNode.next;
    }
    if (nNode.next != null && i > n) {
      nNode.next = nNode.next.next;
    }
    return origin;
  }
}
