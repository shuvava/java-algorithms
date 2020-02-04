package com.github.shuvava.search.bst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BstNodesTest {

  private BinarySearchTree<Integer> bst;

  @BeforeEach
  public void setup() {
    bst = BinarySearchTree.fromList(49, 46, 79, 43, 64, 83, 40, 81, 87);
  }

  @Test
  public void findSmaller(){
    var node = BstNodes.findSmaller(bst.getRoot(), 45);
    assertEquals(43, node.getValue());
  }
}
