package com.github.shuvava.search.bst;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * class implements base functionality of node of BST
 *
 * <p>:Properties:
 *
 * <p>Each node x in the binary tree has a key key(x). Nodes other than the root have a parent p(x).
 * Nodes may have a left child lef t(x) and/or a right child right(x). These are pointers unlike in
 * a heap. The invariant is: for any node x, for all nodes y in the left subtree of x, key(y) ≤
 * key(x). For all nodes y in the right subtree of x key(y) ≥ key(x).
 */
@EqualsAndHashCode
public class BstNode<T extends Comparable<T>> {

  @Getter @Setter private int rank;
  @Getter @Setter private int level;
  @Getter @Setter private T value;
  @Getter private BstNode<T> parent;
  @Getter private BstNode<T> left;
  @Getter private BstNode<T> right;

  public BstNode(T value) {
    this.value = value;
    this.left = null;
    this.right = null;
    this.level = 0;
    this.rank = 1;
  }

  private static <T extends Comparable<T>> void fixBstNodeRank(BstNode<T> node, int removedItems) {
    while (node != null) {
      node.rank += removedItems;
      node = node.parent;
    }
  }

  private static <T extends Comparable<T>> void fixBstNodeLevel(BstNode<T> node, int level) {
    if (node == null) {
      return;
    }
    node.level = level + 1;
    fixBstNodeLevel(node.left, node.level);
    fixBstNodeLevel(node.right, node.level);
  }

  public void setParent(BstNode<T> node) {
    this.parent = node;
    if (node == null) {
      fixBstNodeLevel(this, -1);
    } else {
      fixBstNodeLevel(this, node.level);
    }
  }

  public void setLeft(BstNode<T> node) {
    if (this.left != null) {
      fixBstNodeRank(this, -this.left.rank);
    }
    if (node != null) {
      node.setParent(this);
      fixBstNodeRank(this, node.rank);
    }
    this.left = node;
  }

  public void setRight(BstNode<T> node) {
    if (this.right != null) {
      fixBstNodeRank(this, -this.right.rank);
    }
    if (node != null) {
      node.setParent(this);
      fixBstNodeRank(this, node.rank);
    }
    this.right = node;
  }

  /** * True if this node is left child of parent */
  public Boolean isLeftChild() {
    return this.parent != null && this.parent.left == this;
  }

  /** * True if this node is right child of parent */
  public Boolean isRightChild() {
    return this.parent != null && this.parent.right == this;
  }

  public int getChildrenCount() {
    int cnt = 0;
    if (this.left != null) {
      cnt += 1;
    }
    if (this.right != null) {
      cnt += 1;
    }
    return cnt;
  }

  public Boolean isValid() {
    if (this.left != null && BstNodes.moreOrEqual(this.left.value, this.value)) {
      return false;
    }
    return this.right == null || !BstNodes.less(this.right.value, this.value);
  }
}
