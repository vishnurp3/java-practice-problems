package com.vishnu.problems.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StockProfitTest {

    private final StockProfit stockProfit = new StockProfit();

    static Stream<Arguments> provideMaxProfitTestCases() {
        return Stream.of(
                Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 5),
                Arguments.of(new int[]{7, 6, 4, 3, 1}, 0),
                Arguments.of(new int[]{1, 2}, 1),
                Arguments.of(new int[]{2, 4, 1}, 2),
                Arguments.of(new int[]{3, 2, 6, 5, 0, 3}, 4),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 4),
                Arguments.of(new int[]{5, 4, 3, 2, 1}, 0),
                Arguments.of(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}, 8),
                Arguments.of(new int[]{1}, 0),
                Arguments.of(new int[]{}, 0)
        );
    }

    @DisplayName("Parameterized Test for Maximum Stock Profit")
    @ParameterizedTest(name = "Test Case {index}: prices={0} => Expected Profit={1}")
    @MethodSource("provideMaxProfitTestCases")
    void testMaxProfit(int[] prices, int expectedProfit) {
        int actualProfit = stockProfit.maxProfit(prices);
        assertEquals(expectedProfit, actualProfit,
                "The calculated profit does not match the expected profit.");
    }
}
