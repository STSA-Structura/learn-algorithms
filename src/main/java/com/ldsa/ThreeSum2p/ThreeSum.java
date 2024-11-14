package com.ldsa.ThreeSum2p;

public class ThreeSum {
    public static void main(String[] args) {
        // Example usage
        int[] nums = {-1, 2, 1, -4};
        int target = 2;

        boolean result = ThreeSumChecker.findTripletSum(nums, target);
        System.out.println("Is there a triplet that sums to " + target + " ? " + result);
    }
}
