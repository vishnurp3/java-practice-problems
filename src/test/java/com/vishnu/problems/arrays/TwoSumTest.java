package com.vishnu.problems.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TwoSumTest {
    private final TwoSum twoSum = new TwoSum();

    static Stream<Arguments> provideTwoSumTestCases() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 9, new int[]{3, 4}),
                Arguments.of(new int[]{0, 4, 3, 0}, 0, new int[]{0, 3})
        );
    }

    @DisplayName("Parameterized Test for Two Sum Problem")
    @ParameterizedTest(name = "Test Case {index}: nums={0}, target={1} => Expected={2}")
    @MethodSource("provideTwoSumTestCases")
    void testTwoSum(int[] nums, int target, int[] expected) {
        int[] result = twoSum.twoSum(nums, target);
        assertArrayEquals(expected, result, "The returned indices do not match the expected indices.");
    }

    @Test
    @DisplayName("Test Two Sum with No Solution")
    void testTwoSumNoSolution() {
        int[] nums = {1, 2, 3};
        int target = 7;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> twoSum.twoSum(nums, target));
        assertEquals("No two sum solution", exception.getMessage());
    }
}
