package com.github.shuvava.problems.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

public class CreateBST {

  /**
   * left(i)=2(i+1): returns index of node's left child
   */
  private static int getLeft(int inx) {
    return 2 * inx + 1;
  }

  /**
   * right(i)=2i: returns index of node's right child
   */
  private static int getRight(int inx) {
    return 2 * (inx + 1);
  }

  public static TreeNode createBST(List<Integer> arr) {
    if (arr == null || arr.size() == 0 || arr.get(0) == null) {
      return null;
    }
    var root = new TreeNode(arr.get(0));
    Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
    stack.push(Pair.of(root, 0));
    while (!stack.isEmpty()) {
      var pair = stack.pop();
      TreeNode node = pair.getLeft();
      int inx = pair.getRight();
      int lInx = getLeft(inx);
      int rInx = getRight(inx);
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

  public static List<Integer> convertToList(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    var result = new ArrayList<Integer>();
    result.add(null);
    var curLevel = 0;
    var stack = new Stack<Triple<TreeNode, Integer, Integer>>();
    stack.push(Triple.of(root, 0, 0));
    while (!stack.isEmpty()) {
      var triple = stack.pop();
      var node = triple.getLeft();
      var level = triple.getMiddle();
      var inx = triple.getRight();
      if (level > curLevel) {
        var capacity = level * 2;
        result.addAll(Collections.nCopies(capacity, null));
        curLevel = level;
      }
      result.set(inx, node.val);
      if (node.left != null) {
        stack.push(Triple.of(node.left, level + 1, getLeft(inx)));
      }
      if (node.right != null) {
        stack.push(Triple.of(node.right, level + 1, getRight(inx)));
      }
    }

    var inx = result.size() - 1;
    while (result.get(inx) == null) {
      result.remove(inx);
      inx -= 1;
    }

    return result;
  }
}
