package com.ldsa.Palindrome2p;

public class Palindrome {

    public static void main(String[] args) {
        String[] testStrings = {
                "A man, a plan, a canal, Panama",
                "racecar",
                "hello",
                "Madam, in Eden, I'm Adam",
                "12321"
        };

        // Check each test case
        for (String testString : testStrings) {
            boolean result = PalindromeChecker.isPalindrome(testString);
            System.out.println("\"" + testString + "\" is palindrome: " + result);
        }
    }
}
