package com.github.shuvava.search.bst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BstNodeUpdatesTest {
  private BinarySearchTree<Integer> bst;
  private Integer[] data;

  @BeforeEach
  public void setup() {
    data = new Integer[]{49, 46, 79, 43, 64, 83, 40, 81, 87};
    bst = BinarySearchTree.fromList(data);
  }
  @Test
  public void insert() {
    assertNotNull(bst.getRoot().getLeft());
    assertNotNull(bst.getRoot().getLeft().getLeft());
    assertEquals(43, bst.getRoot().getLeft().getLeft().getValue());
  }

  @Test
  public void delete() {
    bst.remove(bst.getRoot().getLeft().getLeft());
    assertEquals(2, bst.getRoot().getLeft().getRank());
    assertEquals(8, bst.getRoot().getRank());
    assertNotNull(bst.getRoot().getLeft().getLeft());
    assertNull(bst.getRoot().getLeft().getLeft().getLeft());
    bst.remove(bst.getRoot().getRight());
    assertEquals(7, bst.getRoot().getRank());
  }

  @Test
  public void deleteWithChild(){
    bst.add(82);
    bst.remove(bst.getRoot().getLeft().getLeft());
    assertEquals(2, bst.getRoot().getLeft().getRank());
    assertEquals(9, bst.getRoot().getRank());
    assertNotNull(bst.getRoot().getLeft().getLeft());
    assertNull(bst.getRoot().getLeft().getLeft().getLeft());
    bst.remove(bst.getRoot().getRight());
    assertEquals(8, bst.getRoot().getRank());
  }
}
