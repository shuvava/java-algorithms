package com.github.shuvava.search.bst;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Stack;
import org.junit.jupiter.api.Test;

public class BstNodeTest {

  @Test
  public void testRank() {
    Stack<Integer> arr = getData();
    Integer item = arr.pop();
    BstNode<Integer> root = new BstNode<>(item);
    var node = root;
    var parent = node;
    while (!arr.isEmpty()) {
      item = arr.pop();
      parent = node;
      node = new BstNode<>(item);
      parent.setLeft(node);
    }

    assertEquals(9, root.getRank());
    node.getParent().getParent().setLeft(null);
    assertEquals(7, root.getRank());
  }

  @Test
  public void testLevel(){
    Stack<Integer> arr = getData();
    Integer item = arr.pop();
    BstNode<Integer> root = new BstNode<>(item);
    var node = root;
    var parent = node;
    while (!arr.isEmpty()) {
      item = arr.pop();
      parent = node;
      node = new BstNode<>(item);
      parent.setLeft(node);
    }

    assertEquals(8, node.getLevel());
    var testNode = node.getParent().getParent();
    testNode.setParent(null);;
    assertEquals(0, testNode.getLevel());
    assertEquals(2, testNode.getLeft().getLeft().getLevel());
  }

  public Stack<Integer> getData() {
    Stack<Integer> stack = new Stack<>();
    for (Integer i : Arrays.asList(49, 46, 79, 43, 64, 83, 40, 81, 87)) {
      stack.push(i);
    }
    return stack;
  }
}
