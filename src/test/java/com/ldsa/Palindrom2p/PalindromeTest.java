package com.ldsa.Palindrome2p;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {

    // Test for valid palindromes
    @Test
    public void testPalindromeWithValidCases() {
        assertTrue(PalindromeChecker.isPalindrome("AmanaplanacanalPanama"));
        assertTrue(PalindromeChecker.isPalindrome("racecar"));
        assertTrue(PalindromeChecker.isPalindrome("MadamInEdenImAdam"));
        assertTrue(PalindromeChecker.isPalindrome("12321"));
    }

    // Test for invalid palindromes
    @Test
    public void testPalindromeWithInvalidCases() {
        assertFalse(PalindromeChecker.isPalindrome("hello"));
        assertFalse(PalindromeChecker.isPalindrome("notapalindrome"));
    }
}
