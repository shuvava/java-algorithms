package com.github.shuvava.search.bst;

import java.util.ArrayList;
import java.util.List;

public class BstNodes {
  /** is v < w ? */
  static <T extends Comparable<T>> boolean less(T v, T w) {
    return v.compareTo(w) < 0;
  }

  /** is v >= w ? */
  static <T extends Comparable<T>> boolean moreOrEqual(T v, T w) {
    return v.compareTo(w) >= 0;
  }

  /** is v <= w ? */
  static <T extends Comparable<T>> boolean lessOrEqual(T v, T w) {
    return v.compareTo(w) <= 0;
  }

  /**
   * find first node which value is less or equal value
   *
   * @param node start point of traversal
   * @param value value to search
   * @return BstNode | null
   */
  static <T extends Comparable<T>> BstNode<T> findSmaller(BstNode<T> node, T value) {
    if (node == null) {
      return null;
    }
    if (moreOrEqual(value, node.getValue())) {
      return node;
    }
    return findSmaller(node.getLeft(), value);
  }

  /** find max value in bst */
  static <T extends Comparable<T>> BstNode<T> max(BstNode<T> node) {
    BstNode<T> previous = null;
    while (node != null) {
      previous = node;
      node = node.getRight();
    }
    return previous;
  }

  /** find min value in bst */
  static <T extends Comparable<T>> BstNode<T> min(BstNode<T> node) {
    BstNode<T> previous = null;
    while (node != null) {
      previous = node;
      node = node.getLeft();
    }
    return previous;
  }

  /** find node in subtree */
  static <T extends Comparable<T>> BstNode<T> find(BstNode<T> node, T value) {
    if (node == null) {
      return null;
    }
    int comp = node.getValue().compareTo(value);
    if (comp == 0) {
      return node;
    }
    if (comp < 0) {
      return find(node.getRight(), value);
    }
    return find(node.getLeft(), value);
  }

  /** find next larger value(successor) in bst */
  static <T extends Comparable<T>> BstNode<T> nextLarger(BstNode<T> node, T value) {
    if (node == null) {
      return null;
    }
    if (less(value, node.getValue())) {
      var nodeTmp = nextLarger(node.getLeft(), value);
      if (nodeTmp != null) {
        node = nodeTmp;
      }
      return node;
    }
    return nextLarger(node.getRight(), value);
  }
  /** find next smaller value(predecessor) in bst */
  static <T extends Comparable<T>> BstNode<T> nextSmaller(BstNode<T> node, T value) {
    if (node == null) {
      return  null;
    }
    if (less(node.getValue(), value)) {
      var nodeTmp = nextSmaller(node.getRight(), value);
      if (nodeTmp != null) {
        node = nodeTmp;
      }
      return node;
    }
    return nextSmaller(node.getLeft(), value);
  }

  static <T extends Comparable<T>> List<T> asList(BstNode<T> node) {
    var arr = new ArrayList<T>();
    processToList(node, arr);

    return arr;
  }

  static <T extends Comparable<T>> Boolean isBstTreeValid(BstNode<T> node) {
    if (node == null) {
      return true;
    }
    if (!node.isValid()) {
      return false;
    }
    return isBstTreeValid(node.getLeft()) && isBstTreeValid(node.getRight());
  }

  private static <T extends Comparable<T>> void processToList(BstNode<T> node, List<T> arr) {
    if (node == null) {
      return;
    }
    arr.add(node.getValue());
    processToList(node.getLeft(), arr);
    processToList(node.getRight(), arr);
  }

  /** find count of nodes less or equal value in subtree */
  static <T extends Comparable<T>> int countSmaller(BstNode<T> node, T value) {
    return countSmaller(node, value, 0);
  }

  private static <T extends Comparable<T>> int countSmaller(BstNode<T> node, T value, int count) {
    if (node == null) {
      return count;
    }
    if (moreOrEqual(value, node.getValue())) {
      count += 1;
      if (node.getLeft() != null) {
        count += node.getLeft().getRank();
      }
      return countSmaller(node.getRight(), value, count);
    }
    return countSmaller(node.getLeft(), value, count);
  }
}
