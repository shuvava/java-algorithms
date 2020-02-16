package com.github.shuvava.problems.linkedLists;

/**
 * ou are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order and each of their nodes contain a single digit. Add the two numbers and
 * return it as a linked list.
 *
 * <p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * <p>Example:
 *
 * <p>Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 + 465 = 807.
 */
public class addTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode prev = null;
    ListNode current = new ListNode(0);
    ListNode root = current;
    int register = 0;
    while (l1 != null && l2 != null) {
      current.val += l1.val + l2.val;
      if (current.val > 9) {
        register = 1;
        current.val -= 10;
      } else {
        register = 0;
      }
      prev = current;
      current.next = new ListNode(register);
      current = current.next;
      l1 = l1.next;
      l2 = l2.next;
    }
    while (l1 != null) {
      current.val += l1.val;
      if (current.val > 9) {
        register = 1;
        current.val -= 10;
      } else {
        register = 0;
      }
      prev = current;
      current.next = new ListNode(register);
      current = current.next;
      l1 = l1.next;
    }
    while (l2 != null) {
      current.val += l2.val;
      if (current.val > 9) {
        register = 1;
        current.val -= 10;
      } else {
        register = 0;
      }
      prev = current;
      current.next = new ListNode(register);
      current = current.next;
      l2 = l2.next;
    }
    if (register == 0 && prev != null) {
      prev.next = null;
    }
    return root;
  }
}
