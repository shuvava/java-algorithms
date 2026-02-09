package com.github.shuvava.problems.bst;

import java.util.List;
import java.util.Stack;
import org.apache.commons.lang3.tuple.Pair;

public class CreateBST {

  /**
   * left(i)=2(i+1): returns index of node's left child
   */
  private int getLeft(int inx) {
    return 2 * inx + 1;
  }

  /**
   * right(i)=2i: returns index of node's right child
   */
  private int getRight(int inx) {
    return 2 * (inx + 1);
  }

  public TreeNode createBST(List<Integer> arr) {
    if (arr == null || arr.size() == 0 || arr.getFirst() == null) {
      return null;
    }
    var root = new TreeNode(arr.getFirst());
    Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
    stack.push(Pair.of(root, 0));
    while (!stack.isEmpty()) {
      var pair = stack.pop();
      TreeNode node = pair.getLeft();
      int inx = pair.getRight();
      int lInx = this.getLeft(inx);
      int rInx = this.getRight(inx);
      if (lInx < arr.size()) {
        Integer val = arr.get(lInx);
        if (val != null) {
          var child = new TreeNode(val);
          node.left = child;
          stack.push(Pair.of(child, lInx));
        }
      }
      if (rInx < arr.size()) {
        Integer val = arr.get(rInx);
        if (val != null) {
          var child = new TreeNode(val);
          node.right = child;
          stack.push(Pair.of(child, rInx));
        }
      }
    }
    return root;
  }
}
