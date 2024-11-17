package com.ldsa.ThreeSum2p;

import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {
        // Input list of arrays
        int[][] numsList = {
            {3, 7, 1, 2, 8, 4, 5},
            {-1, 2, 1, -4, 5, -3},
            {2, 3, 4, 1, 7, 9},
            {1, -1, 0},
            {2, 4, 2, 7, 6, 3, 1},
            { -1, 2, 1, -4, 5, -3 }
        };

        // Corresponding target values
        int[] testList = {10, 7, 20, -1, 8, 7};

        // Iterate over each test case
        for (int i = 0; i < testList.length; i++) {
            System.out.print(i + 1);  // Print the index of the test case
            System.out.println(".\tInput array: " + Arrays.toString(numsList[i]));  // Print the input array

            if (ThreeSumChecker.findSumOfThree(numsList[i], testList[i])) {
                System.out.println("\tSum for " + testList[i] + " exists ");
            } else {
                System.out.println("\tSum for " + testList[i] + " does not exist ");
            }

            // Print a separator line
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
