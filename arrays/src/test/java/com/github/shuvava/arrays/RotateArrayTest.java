package com.github.shuvava.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.github.shuvava.testcommon.BaseTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RotateArrayTest extends BaseTest {

    @DisplayName("Check array rotation with O(n) space complicity")
    @ParameterizedTest(name = "test #{index}")
    @CsvSource(value = {
        "1, 2, 3, 4, 5, 6, 7 | 2 | 6, 7, 1, 2, 3, 4, 5",
        "1, 2, 3, 4, 5, 6, 7 | 3 | 5, 6, 7, 1, 2, 3, 4",
        "1, 2, 3, 4, 5, 6, 7 | 4 | 4, 5, 6, 7, 1, 2, 3",
        "-1, -100, 3, 99 | 2 | 3, 99, -1, -100",
    }, delimiter = '|')
    public void CheckArrayRotateOnSpace(final String arrStr, final int k, final String expectedStr){
        List<Integer> arr = parseArray(arrStr);
        List<Integer> expected = parseArray(expectedStr);

        var actual = RotateArray.rotateArrayOnSpace(arr, k);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @DisplayName("Check array rotation with O(1) space complicity")
    @ParameterizedTest(name = "test #{index}")
    @CsvSource(value = {
        "1, 2, 3, 4, 5, 6, 7 | 2 | 6, 7, 1, 2, 3, 4, 5",
        "1, 2, 3, 4, 5, 6, 7 | 3 | 5, 6, 7, 1, 2, 3, 4",
        "1, 2, 3, 4, 5, 6, 7 | 4 | 4, 5, 6, 7, 1, 2, 3",
        "-1, -100, 3, 99 | 2 | 3, 99, -1, -100",
    }, delimiter = '|')
    public void CheckArrayRotateO1Space(final String arrStr, final int k, final String expectedStr){
        List<Integer> arr = parseArray(arrStr);
        List<Integer> expected = parseArray(expectedStr);

        RotateArray.rotateArrayO1Space(arr, k);

        assertArrayEquals(expected.toArray(), arr.toArray());
    }
}
