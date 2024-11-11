package com.ldsa.Palindrome2p;

public class PalindromeChecker {

    // Method to check if a string is a palindrome using the Two Pointers approach
    public static boolean isPalindrome(String s) {
        // Step 1: Remove non-alphanumeric characters and convert to lowercase.
        // This ensures we handle case-insensitivity and ignore symbols like
        // punctuation.
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Step 2: Initialize two pointers, one starting from the beginning and the
        // other from the end
        int left = 0;
        int right = s.length() - 1;

        // Step 3: Traverse the string from both ends using the two pointers
        while (left < right) {
            // Step 4: If characters at both pointers don't match, it's not a palindrome
            if (s.charAt(left) != s.charAt(right)) {
                return false; // The string is not a palindrome
            }

            // Step 5: Move the left pointer towards the center (right direction)
            // Step 6: Move the right pointer towards the center (left direction)
            left++;
            right--;
        }

        // Step 7: If we successfully reach here, all characters matched, it's a
        // palindrome
        return true;
    }
}
