package com.github.shuvava.problems.bst;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;

/***
 * Given a binary tree, imagine yourself standing on the right side of it,
 *  return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class RightSideView {

  public static List<Integer> rightSideView(TreeNode root) {
    var result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }
    var stack = new Stack<Entry<Integer, TreeNode>>();
    stack.push(new SimpleEntry<>(0, root));
    while (!stack.isEmpty()) {
      var item = stack.pop();
      var level = item.getKey();
      var node = item.getValue();
      if (node.left != null) {
        stack.push(new SimpleEntry<>(level + 1, node.left));
      }
      if (node.right != null) {
        stack.push(new SimpleEntry<>(level + 1, node.right));
      }
      if (result.size() <= level) {
        result.add(node.val);
      }
    }

    return result;
  }
}
