package com.vishnu.problems.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * Finds the indices of the two numbers that add up to the target.
     *
     * @param nums   Array of integers.
     * @param target Target sum.
     * @return Array containing the two indices.
     * @throws IllegalArgumentException if no solution is found.
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement), i};
            }
            numToIndex.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
