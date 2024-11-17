# Valid Palindrome

Let's start by focusing on the `Palindrome` algorithm using the Two Pointers pattern in `Palindrome.java`.

## Problem: Check if a String is a Palindrome

A `palindrome` is a string that reads the same backward as forward. The two-pointer technique can be used to efficiently check if a string is a palindrome by comparing characters from both ends of the string.

## Plan

> 1. We will use two pointers:
>    - One starting from the beginning (`left`).
>    - One starting from the end (`right`).
> 1. Move the pointers towards the center, comparing characters at each step. If at any point the characters don't match, return `false`.
> 1. If the pointers meet or cross each other and all characters match, return `true`.

### Time Complexity:

- **O(n)**, where `n` is the length of the string, because we only make a single pass through the string.

### Palindrome.java Implementation:

```java
public class Palindrome {

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
                return false;  // Characters don't match
            }
            left++;   // Move left pointer to the right
            right--;  // Move right pointer to the left
        }

        return true;  // All characters matched, it's a palindrome
    }

    public static void main(String[] args) {
        // Test cases
        String[] testStrings = {
            "A man, a plan, a canal, Panama",
            "racecar",
            "hello",
            "Madam, in Eden, I'm Adam",
            "12321"
        };

        // Check each test case
        for (String testString : testStrings) {
            System.out.println("\"" + testString + "\" is palindrome: " + isPalindrome(testString));
        }
    }
}
```

### Explanation:

1. **Input Preprocessing**: The string is cleaned by removing non-alphanumeric characters and converting everything to lowercase. This ensures the palindrome check is case-insensitive and ignores punctuation and spaces.
2. **Two Pointers**: We initialize two pointers (`left` at the beginning of the string and `right` at the end). We compare the characters at these pointers, and if they are the same, we move the pointers closer towards the center.
3. **Termination Condition**: The loop continues as long as `left` is less than `right`. If the characters at both pointers are unequal, the function returns `false`. If we traverse the whole string without a mismatch, the function returns `true`.

### Example Test Cases:

- `"A man, a plan, a canal, Panama"` → **true** (ignoring spaces and punctuation, it's a palindrome)
- `"racecar"` → **true**
- `"hello"` → **false**
- `"Madam, in Eden, I'm Adam"` → **true**
- `"12321"` → **true**

### Next Steps:

1. You can run this program and verify if the logic works for various palindrome test cases.
2. You can also add more test cases for edge cases, like empty strings or strings with special characters.

---

### Project Structure:

```
learn-algorithms/
│
├── docs/                # Documentation related to algorithms
├── src/                 # Source code for algorithms
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── tsa/
│   │               └── Palindrome2p/
│   │                   ├── Palindrome.java
│   │                   └── PalindromeChecker.java
│   └── test/
│       └── java/
│           └── com/
│               └── tsa/
│                   └── Palindrome2p/
│                       └── PalindromeTest.java
├── .gitignore           # Files or directories to ignore in Git (e.g., .class files, IDE settings)
├── LICENSE              # License for your code
├── README.md            # Project description, setup instructions, and usage
├── build.gradle         # Gradle build configuration
└── settings.gradle      # Gradle settings
```

### 1. `build.gradle` File:

The `build.gradle` file will define the project dependencies and the tasks needed to compile and run the code.

```groovy
plugins {
    id 'java'
}

group 'com.tsa.algorithm'  // Your package namespace
version '1.0-SNAPSHOT'

repositories {
    mavenCentral()  // For dependencies
}

dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.7.2'
    testImplementation 'org.junit.jupiter:junit-jupiter-engine:5.7.2'
}

test {
    useJUnitPlatform()  // Enable JUnit 5
}

task run(type: JavaExec) {
    main = 'com.tsa.algorithm.Palindrome'  // Main class to run
    classpath = sourceSets.main.runtimeClasspath
}
```

This `build.gradle` configuration:

- Applies the `java` plugin for Java-based projects.
- Defines project dependencies, in this case, JUnit for testing.
- Configures the `run` task to execute the `Palindrome` class.

### 2. `settings.gradle` File:

```groovy
rootProject.name = 'learn-algorithms'
```

This is a basic Gradle settings file to define the project name.

### 3. Java Files with Packages:

#### `Palindrome.java` (Main class for checking palindrome)

```java
package com.tsa.algorithm;

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
```

- This file contains the `Palindrome` class with the `main` method to test various strings for palindrome checks.
- We delegate the palindrome checking logic to a separate class, `PalindromeChecker`.

#### `PalindromeChecker.java` (Utility class to check for palindrome)

```java
package com.tsa.algorithm;

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
                return false;  // Characters don't match
            }
            left++;   // Move left pointer to the right
            right--;  // Move right pointer to the left
        }

        return true;  // All characters matched, it's a palindrome
    }
}
```

- `PalindromeChecker` contains the logic for checking if a string is a palindrome using the two-pointer technique.
- It removes non-alphanumeric characters and compares characters from both ends of the string.

#### `PalindromeTest.java` (JUnit test cases for palindrome checking)

```java
package com.tsa.algorithm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {

    @Test
    public void testPalindromeWithValidCases() {
        assertTrue(PalindromeChecker.isPalindrome("A man, a plan, a canal, Panama"));
        assertTrue(PalindromeChecker.isPalindrome("racecar"));
        assertTrue(PalindromeChecker.isPalindrome("Madam, in Eden, I'm Adam"));
        assertTrue(PalindromeChecker.isPalindrome("12321"));
    }

    @Test
    public void testPalindromeWithInvalidCases() {
        assertFalse(PalindromeChecker.isPalindrome("hello"));
        assertFalse(PalindromeChecker.isPalindrome("not a palindrome"));
    }
}
```

- `PalindromeTest` contains unit tests for the `PalindromeChecker` class.
- We use JUnit 5 to test both valid and invalid palindrome cases.

### Running the Project:

1. **Build the Project**: You can build the project using Gradle by running:

   ```bash
   ./gradlew build
   ```

2. **Run the Program**: To execute the `Palindrome` class (which contains the `main` method), run:

   ```bash
   ./gradlew run
   ```

   This will output whether each test string is a palindrome or not.

3. **Run Tests**: To run the JUnit tests, use:

   ```bash
   ./gradlew test
   ```

   This will execute all tests and show the results in the console.

---

### Next Steps:

- You can now easily add more algorithms following the same structure (create new classes in `src/main/java` and add test cases in `src/test/java`).
- Gradle makes it simple to manage dependencies and automate tasks like building and testing.

Let me know if you'd like further customization or additional features in this setup!

---

Certainly! Let's integrate the provided problem statement, constraints, and a solution in the code. I will add the full statement, the constraints, and modify the code to meet the requirements effectively. Here's the updated setup.

### Updated **Problem Statement**:

#### **Statement**:

Write a function that takes a string, `s`, as an input and determines whether or not it is a palindrome.

A **palindrome** is a word, phrase, or sequence of characters that reads the same backward as forward.

#### **Constraints**:

- \( 1 \leq s.length \leq 2 \times 10^5 \)
- The string `s` will not contain any whitespace and will only consist of ASCII characters (letters and digits).

### Updated **Code Implementation**:

#### **Palindrome.java** (Main class)

```java
package com.tsa.algorithm;

public class Palindrome {

    public static void main(String[] args) {
        // Test cases
        String[] testStrings = {
            "AmanaplanacanalPanama",  // Valid palindrome
            "racecar",                // Valid palindrome
            "hello",                  // Invalid palindrome
            "MadamInEdenImAdam",      // Valid palindrome
            "12321"                   // Valid palindrome
        };

        // Check each test case
        for (String testString : testStrings) {
            boolean result = PalindromeChecker.isPalindrome(testString);
            System.out.println("\"" + testString + "\" is palindrome: " + result);
        }
    }
}
```

- This is the main class to execute the palindrome check using `PalindromeChecker`.

#### **PalindromeChecker.java** (Utility class)

```java
package com.tsa.algorithm;

public class PalindromeChecker {

    // Function to check if a string is a palindrome
    public static boolean isPalindrome(String s) {
        // Remove non-alphanumeric characters and convert to lowercase
        // Although the problem guarantees no whitespace and only ASCII characters, we ensure the check is case insensitive
        s = s.toLowerCase();

        // Initialize two pointers
        int left = 0;
        int right = s.length() - 1;

        // Traverse the string from both ends
        while (left < right) {
            // Compare characters at both pointers
            if (s.charAt(left) != s.charAt(right)) {
                return false;  // If characters don't match, return false
            }
            left++;   // Move left pointer to the right
            right--;  // Move right pointer to the left
        }

        return true;  // If all characters match, return true
    }
}
```

- The `PalindromeChecker` contains the logic to check whether the string is a palindrome using two pointers (from left and right).
- We convert the string to lowercase before performing checks to ensure case insensitivity.

#### **PalindromeTest.java** (JUnit test cases)

```java
package com.tsa.algorithm;

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
```

- `PalindromeTest` includes the JUnit test cases to verify both valid and invalid palindrome strings.

### **Explanation of Changes**:

1. **Main Functionality**:
   - The `isPalindrome` method in `PalindromeChecker` verifies if the string is a palindrome by iterating from both ends of the string towards the center using two pointers. The string is first converted to lowercase to handle case insensitivity.
2. **Constraints**:

   - The problem specifies a string length constraint up to \( 2 \times 10^5 \). Our approach handles this efficiently with a time complexity of \( O(n) \), which is optimal for the given constraint.

3. **Edge Cases**:

   - Strings with even or odd lengths are handled by the two-pointer approach.
   - The string length could go up to \( 2 \times 10^5 \), which the algorithm can process efficiently in linear time.

4. **JUnit Tests**:

   - The test cases verify both palindromes and non-palindromes. They test strings with mixed cases, valid palindromes, and invalid strings.

5. **No Whitespace**:
   - Since the problem guarantees no whitespace and only ASCII characters, we do not need to remove spaces or handle non-ASCII characters. However, the code includes a `.toLowerCase()` to ensure the solution works for cases like `MadamInEdenImAdam`.

---

### **Running the Project**:

1. **Building the Project**:

   ```bash
   ./gradlew build
   ```

2. **Running the Program** (for the main class):

   ```bash
   ./gradlew run
   ```

   This will print the result for each string, indicating whether it is a palindrome or not.

3. **Running the Tests**:

   ```bash
   ./gradlew test
   ```

   This will run the JUnit tests and show the results in the console.

---

This setup ensures that the problem is solved efficiently while adhering to the problem's constraints. If you need further customizations or additions, feel free to ask!
