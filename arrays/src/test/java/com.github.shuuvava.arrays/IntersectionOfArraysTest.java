package com.github.shuuvava.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class IntersectionOfArraysTest extends BaseTest {

  @DisplayName("Check arrays intersection")
  @ParameterizedTest(name = "test #{index}")
  @CsvSource(value = {
    "1, 2, 2, 1 | 2, 2 | 2, 2",
    "4, 9, 5 | 9, 4, 9, 8, 4 | 4, 9",
    "3, 1, 2 | 1, 1 | 1",
  }, delimiter = '|')
  public void CheckArrayRotateO1Space(final String nums1Str, final String nums2Str,
    final String expectedStr) {
    ArrayList<Integer> nums1 = parseArray(nums1Str);
    ArrayList<Integer> nums2 = parseArray(nums2Str);
    ArrayList<Integer> expected = parseArray(expectedStr);

    var actual = IntersectionOfArrays.GetIntersection(nums1, nums2);

    assertArrayEquals(expected.toArray(), actual.toArray());
  }
}
