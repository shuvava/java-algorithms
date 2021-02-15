package com.github.shuvava.problems.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of
 * the original BST is changed to the original key plus sum of all keys greater than the original
 * key in BST.
 * <p>
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key. The right
 * subtree of a node contains only nodes with keys greater than the node's key. Both the left and
 * right subtrees must also be binary search trees.
 * <p>
 * Example 1: Input: root = [4,1,6,0,2,5,7,None,None,None,3,None,None,None,8] Output:
 * [30,36,21,36,35,26,15,None,None,None,33,None,None,None,8] Example 2: Input: root = [0,None,1]
 * Output: [1,None,1] Example 3: Input: root = [1,0,2] Output: [3,3,2] Example 4: Input: root =
 * [3,2,4,1] Output: [7,9,4,10]
 */
public class ConvertToGreaterTree {

  private static int getIndex(List<Integer> arr, Integer val) {
    int low = 0;
    int high = arr.size() - 1;
    while (low <= high) {
      var mid = (high + low) >> 1;
      var test = arr.get(mid);
      if (test < val) {
        high = mid - 1;
      } else if (test > val) {
        low = mid + 1;
      } else {
        return mid;
      }
    }

    return -1;
  }

  public static TreeNode convertBST(TreeNode root) {
    if (root == null) {
      return null;
    }

    var heap = new ArrayList<Integer>();
    var heapSum = new ArrayList<Integer>();
    var stack = new Stack<TreeNode>();
    TreeNode node;

    stack.push(root);
    while (!stack.isEmpty()) {
      node = stack.pop();
      heap.add(node.val);
      if (node.left != null) {
        stack.push(node.left);
      }
      if (node.right != null) {
        stack.push(node.right);
      }
    }

    var sum = 0;
    heap.sort(Collections.reverseOrder());
    for (var val : heap) {
      sum += val;
      heapSum.add(sum);
    }

    stack.push(root);
    while (!stack.isEmpty()) {
      node = stack.pop();
      var inx = getIndex(heap, node.val);
      node.val = heapSum.get(inx);
      if (node.left != null) {
        stack.push(node.left);
      }
      if (node.right != null) {
        stack.push(node.right);
      }
    }

    return root;
  }
}
