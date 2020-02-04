package com.github.shuvava.search.bst;

import java.util.List;
import lombok.Getter;

public class BinarySearchTree<T extends Comparable<T>> {
  @Getter private BstNode<T> root;
  @Getter private int length;

  public BinarySearchTree() {
    this.length = 0;
  }

  public static <T extends Comparable<T>> BinarySearchTree<T> fromList(T...list) {
    BinarySearchTree<T> bst = new BinarySearchTree<>();
    for (T item : list) {
      bst.add(item);
    }
    return bst;
  }

  public void add(T value) {
    BstNode<T> node = new BstNode<>(value);
    add(node);
  }

  public void add(BstNode<T> node) {
    if (node == null) {
      return;
    }
    this.length += 1;
    if (this.root == null) {
      this.root = node;
      return;
    }
    BstNodeUpdates.insert(this.root, node);
  }
}
