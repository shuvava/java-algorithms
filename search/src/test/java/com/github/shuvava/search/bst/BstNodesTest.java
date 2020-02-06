package com.github.shuvava.search.bst;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BstNodesTest {

  private BinarySearchTree<Integer> bst;
  private Integer[] data;

  @BeforeEach
  public void setup() {
    data = new Integer[]{49, 46, 79, 43, 64, 83, 40, 81, 87};
    bst = BinarySearchTree.fromList(data);
  }

  @Test
  public void findSmaller(){
    var node = BstNodes.findSmaller(bst.getRoot(), 45);
    assertEquals(43, node.getValue());
  }

  @Test
  public void countSmaller() {
    int count = BstNodes.countSmaller(bst.getRoot(), 45);
    assertEquals(2, count);
    count = BstNodes.countSmaller(bst.getRoot(), 79);
    assertEquals(6, count);
  }

  @Test
  public void max(){
    var node = BstNodes.max(bst.getRoot());
    var expected = Collections.max(Arrays.asList(data));
    assertEquals(expected, node.getValue());
  }

  @Test
  public void min(){
    var node = BstNodes.min(bst.getRoot());
    var expected = Collections.min(Arrays.asList(data));
    assertEquals(expected, node.getValue());
  }

  @Test
  public void find_ShouldReturnElement() {
    var node = BstNodes.find(bst.getRoot(), 64);
    assertNotNull(node);
    assertEquals(64, node.getValue());
  }

  @Test
  public void find_ShouldReturnNull() {
    var node = BstNodes.find(bst.getRoot(), 66);
    assertNull(node);
  }

  @Test
  public void nextLarger_goRightByTree() {
    var node = BstNodes.nextLarger(bst.getRoot(), 65);
    assertNotNull(node);
    assertEquals(79, node.getValue());
  }

  @Test
  public void nextLarger_goLeftByTree() {
    var node = BstNodes.nextLarger(bst.getRoot(), 44);
    assertNotNull(node);
    assertEquals(46, node.getValue());
  }

  @Test
  public void nextLarger_goLeftRightByTree1() {
    var node = BstNodes.nextLarger(bst.getRoot(), 63);
    assertNotNull(node);
    assertEquals(64, node.getValue());
  }

  @Test
  public void nextLarger_goLeftRightByTree2() {
    var node = BstNodes.nextLarger(bst.getRoot(), 82);
    assertNotNull(node);
    assertEquals(83, node.getValue());
  }

  @Test
  public void nextSmaller_goRightByTree() {
    var node = BstNodes.nextSmaller(bst.getRoot(), 65);
    assertNotNull(node);
    assertEquals(64, node.getValue());
  }

  @Test
  public void nextSmaller_goLeftByTree() {
    var node = BstNodes.nextSmaller(bst.getRoot(), 44);
    assertNotNull(node);
    assertEquals(43, node.getValue());
  }

  @Test
  public void nextSmaller_goLeftRightByTree1() {
    var node = BstNodes.nextSmaller(bst.getRoot(), 63);
    assertNotNull(node);
    assertEquals(49, node.getValue());
  }

  @Test
  public void nextSmaller_goLeftRightByTree2() {
    var node = BstNodes.nextSmaller(bst.getRoot(), 82);
    assertNotNull(node);
    assertEquals(81, node.getValue());
  }

  @Test
  public void asList() {
    Arrays.sort(data);
    var items = BstNodes.asList(bst.getRoot());
    var arr = items
        .stream()
        .sorted()
        .toArray();

    assertArrayEquals(data, arr);
  }
}
