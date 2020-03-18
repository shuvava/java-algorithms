package com.github.shuvava.problems.maxumum_depth_of_binary_tree;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class MaximumDepthOfBinaryTree {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int maxDeep = 0;
    Stack<Entry<TreeNode, Integer>> stack = new Stack<>();
    stack.push(Map.entry(root, 1));
    while (!stack.isEmpty()) {
      Entry<TreeNode, Integer> entry = stack.pop();
      var node = entry.getKey();
      int deep = entry.getValue();
      if (node.left != null) {
        stack.push(Map.entry(node.left, deep+1));
      }
      if (node.right != null) {
        stack.push(Map.entry(node.right, deep + 1));
      }
      if (deep > maxDeep) {
        maxDeep = deep;
      }
    }
    return maxDeep;
  }
}
