package com.github.shuvava.search.bst;

public class BstNodeUpdates {
  static <T extends Comparable<T>> Boolean insert(BstNode<T> parent, BstNode<T> node) {
    if (node == null || parent == null) return false;
    if (BstNodes.lessOrEqual(parent.getValue(), node.getValue())) {
      var right = parent.getRight();
      if (right == null) {
        parent.setRight(node);
        return true;
      }
      return insert(right, node );
    }
    var left = parent.getLeft();
    if (left == null) {
      parent.setLeft(node);
      return true;
    }
    return insert(left, node);
  }
}
