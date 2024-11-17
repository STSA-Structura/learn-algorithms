package com.ldsa.ThreeSum2p;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;  // Correct static imports for assertions


public class ThreeSumCheckerTest {

    // Test case 1: Array with sum 10
    @Test
    public void testFindSumOfThreeExists() {
        int[] nums = { 3, 7, 1, 2, 8, 4, 5 };
        int target = 10;
        assertTrue(ThreeSumChecker.findSumOfThree(nums, target));
    }

    // // Test case 2: Array with sum 7
    // @Test
    // public void testFindSumOfThreeExists2() {
    //     int[] nums = { -1, 2, 1, -4, 5, -3 };
    //     int target = 7;
    //     assertTrue(ThreeSumChecker.findSumOfThree(nums, target));
    // }

    // // Test case 3: Array with sum 20 (does not exist)
    // @Test
    // public void testFindSumOfThreeNotExists() {
    //     int[] nums = { 2, 3, 4, 1, 7, 9 };
    //     int target = 20;
    //     assertFalse(ThreeSumChecker.findSumOfThree(nums, target));
    // }

    // // Test case 4: Array with sum -1
    // @Test
    // public void testFindSumOfThreeExists3() {
    //     int[] nums = { 1, -1, 0 };
    //     int target = -1;
    //     assertTrue(ThreeSumChecker.findSumOfThree(nums, target));
    // }

    // Test case 5: Array with sum 8
    @Test
    public void testFindSumOfThreeExists4() {
        int[] nums = { 2, 4, 2, 7, 6, 3, 1 };
        int target = 8;
        assertTrue(ThreeSumChecker.findSumOfThree(nums, target));
    }

    // Test case 6: Array with no triplet for sum 0
    @Test
    public void testFindSumOfThreeNotExists2() {
        int[] nums = { 1, 2, 3 };
        int target = 0;
        assertFalse(ThreeSumChecker.findSumOfThree(nums, target));
    }

    // Test case 7: Array with duplicate elements
    @Test
    public void testFindSumOfThreeWithDuplicates() {
        int[] nums = { 1, 1, 2, 3, 4 };
        int target = 6;
        assertTrue(ThreeSumChecker.findSumOfThree(nums, target));
    }

    // Test case 8: Array with negative numbers
    @Test
    public void testFindSumOfThreeNegativeNumbers() {
        int[] nums = { -5, -4, -3, -2, -1 };
        int target = -6;
        assertTrue(ThreeSumChecker.findSumOfThree(nums, target));
    }
}
