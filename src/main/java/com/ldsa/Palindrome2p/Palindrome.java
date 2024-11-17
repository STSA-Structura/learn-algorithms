package com.ldsa.Palindrome2p;

public class Palindrome {

    public static void main(String[] args) {
        String[] testStrings = {
                "A man, a plan, a canal, Panama",
                "racecar",
                "hello",
                "Madam, in Eden, I'm Adam",
                "12321",
                "RACEACAR",
                "A",
                "ABCDEFGFEDCBA",
                "ABC",
                "ABCBA",
                "ABBA",
                "RACEACAR"
        };

        // Check each test case with detailed information
        for (int k = 0; k < testStrings.length; k++) {
            System.out.println("Test Case #" + (k + 1));
            System.out.println(new String(new char[100]).replace('\0', '-'));
            System.out.println("The input string is \"" + testStrings[k] + "\" and the length of the string is "
                    + testStrings[k].length() + ".");
            System.out.println("\nIs it a palindrome?..... " + PalindromeChecker.isPalindrome(testStrings[k]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
            System.out.println(); // Blank line between test cases
        }

    }
}
