package com.ldsa.ThreeSum2p;

import java.util.Arrays;

public class ThreeSumChecker {

    // Function to check if there exists a triplet with sum equal to the target
    public static boolean findSumOfThree(int[] nums, int target) {
        // First, sort the array
        Arrays.sort(nums);

        // Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Two pointer technique
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                if (currentSum == target) {
                    return true; // Found a triplet
                } else if (currentSum < target) {
                    left++; // Increase sum by moving left pointer
                } else {
                    right--; // Decrease sum by moving right pointer
                }
            }
        }

        return false; // No triplet found
    }
}
