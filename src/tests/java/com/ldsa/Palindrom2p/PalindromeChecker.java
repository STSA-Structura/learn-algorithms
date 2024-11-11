package com.ldsa.Palindrome2p;

public class PalindromeChecker {

    // Method to check if a string is a palindrome using the Two Pointers approach
    public static boolean isPalindrome(String s) {
        // Remove non-alphanumeric characters and convert to lowercase
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Initialize two pointers
        int left = 0;
        int right = s.length() - 1;

        // Traverse the string from both ends
        while (left < right) {
            // Compare characters at both pointers
            if (s.charAt(left) != s.charAt(right)) {
                return false; // Characters don't match
            }
            left++; // Move left pointer to the right
            right--; // Move right pointer to the left
        }

        return true; // All characters matched, it's a palindrome
    }
}
