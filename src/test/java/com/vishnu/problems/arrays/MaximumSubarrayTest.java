package com.vishnu.problems.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MaximumSubarrayTest {

    private final MaximumSubarray maximumSubarray = new MaximumSubarray();

    static Stream<Arguments> provideMaxSubArrayTestCases() {
        return Stream.of(
                Arguments.of(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{5, 4, -1, 7, 8}, 23),
                Arguments.of(new int[]{-1, -2, -3, -4}, -1),
                Arguments.of(new int[]{0, 0, 0, 0}, 0),
                Arguments.of(new int[]{3, -2, 5, -1}, 6),
                Arguments.of(new int[]{-2, -1}, -1),
                Arguments.of(new int[]{2, -1, 2, 3, 4, -5}, 10),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 15),
                Arguments.of(new int[]{5, -9, 6, -2, 3}, 7),
                Arguments.of(new int[]{Integer.MAX_VALUE}, Integer.MAX_VALUE)
        );
    }

    @DisplayName("Parameterized Test for Maximum Subarray Problem")
    @ParameterizedTest(name = "Test Case {index}: nums={0} => Expected Max Sum={1}")
    @MethodSource("provideMaxSubArrayTestCases")
    void testMaxSubArray(int[] nums, int expectedMaxSum) {
        int actualMaxSum = maximumSubarray.maxSubArray(nums);
        assertEquals(expectedMaxSum, actualMaxSum,
                "The calculated maximum subarray sum does not match the expected value.");
    }

    @DisplayName("Test Maximum Subarray with Null Input")
    @org.junit.jupiter.api.Test
    void testMaxSubArrayWithNullInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> maximumSubarray.maxSubArray(null));
        assertEquals("Input array cannot be null or empty.", exception.getMessage());
    }

    @DisplayName("Test Maximum Subarray with Empty Array")
    @org.junit.jupiter.api.Test
    void testMaxSubArrayWithEmptyArray() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> maximumSubarray.maxSubArray(new int[]{}));
        assertEquals("Input array cannot be null or empty.", exception.getMessage());
    }
}
