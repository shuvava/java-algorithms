package com.github.shuvava.problems.bst;

import java.util.Stack;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * <p>Assume a BST is defined as follows:
 *
 * <p>The left subtree of a node contains only nodes with keys less than the node's key. The right
 * subtree of a node contains only nodes with keys greater than the node's key. Both the left and
 * right subtrees must also be binary search trees.
 *
 * <p>Example 1:
 *
 * <p>2 / \ 1 3
 *
 * <p>Input: [2,1,3] Output: true Example 2:
 *
 * <p>5 / \ 1 4 / \ 3 6
 *
 * <p>Input: [5,1,4,null,null,3,6] Output: false Explanation: The root node's value is 5 but its
 * right child's value is 4.
 */
public class ValidateBST {

  private Long getMin(Long val1, Long val2) {
    if (val1 == null) {
      return val2;
    }
    if (val2 == null) {
      return val1;
    }
    if (val2 > val1) {
      return val1;
    }
    return val2;
  }

  private Long getMax(Long val1, Long val2) {
    if (val1 == null) {
      return val2;
    }
    if (val2 == null) {
      return val1;
    }
    if (val2 < val1) {
      return val1;
    }
    return val2;
  }

  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    Stack<StackItem> stack = new Stack<>();
    stack.push(StackItem.of(root, Long.MIN_VALUE, Long.MAX_VALUE));
    while (!stack.isEmpty()) {
      var item = stack.pop();
      if (item.node.val >= item.max) {
        return false;
      }
      if (item.node.val <= item.min) {
        return false;
      }
      if (item.node.right != null) {
        stack.push(
            StackItem.of(item.node.right, this.getMax((long) item.node.val, item.min), item.max));
      }
      if (item.node.left != null) {
        stack.push(
            StackItem.of(item.node.left, item.min, this.getMin((long) item.node.val, item.max)));
      }
    }
    return true;
  }
}

class StackItem {

  final TreeNode node;
  final Long min;
  final Long max;

  StackItem(TreeNode node, Long min, Long max) {
    this.node = node;
    this.min = min;
    this.max = max;
  }

  static StackItem of(TreeNode node, Long min, Long max) {
    return new StackItem(node, min, max);
  }
}
