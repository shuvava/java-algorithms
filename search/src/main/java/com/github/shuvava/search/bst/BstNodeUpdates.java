package com.github.shuvava.search.bst;

import java.util.Optional;

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

  static <T extends Comparable<T>> Boolean delete(BstNode<T> node) {
    if (node == null ) return false;
    var parent = node.getParent();
    var left = node.getLeft();
    var right = node.getRight();
    var isLeftChild = node.isLeftChild();
    var countChildren = node.getChildrenCount();
    if (countChildren == 0) {
      if (isLeftChild) {
        parent.setLeft(null);
      } else {
        parent.setRight(null);
      }
      return true;
    }
    if (countChildren == 1) {
      if (isLeftChild) {
        parent.setLeft(Optional.ofNullable(left).orElse(right));
        return true;
      }
      parent.setRight(Optional.ofNullable(left).orElse(right));
      return true;
    }
    var nextLarger = BstNodes.nextLarger(node, node.getValue());
    if (nextLarger.isLeftChild()) {
      nextLarger.getParent().setLeft(nextLarger.getRight());
    } else {
      nextLarger.getParent().setRight(nextLarger.getRight());
    }
    nextLarger.setParent(null);
    if (isLeftChild) {
      parent.setLeft(nextLarger);
    } else {
      parent.setRight(nextLarger);
    }
    if (nextLarger != left) {
      nextLarger.setLeft(left);
    }
    if (nextLarger != right) {
      nextLarger.setRight(right);
    }
    return true;
  }
}
