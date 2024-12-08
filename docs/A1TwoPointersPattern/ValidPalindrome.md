# Valid Palindrome

Let's implement the `Palindrome` algorithm using the Two Pointers pattern in `Palindrome.java`.

## Problem: Check if a String is a Palindrome

A `palindrome` is a string that reads the same backward as forward. The two-pointer technique can be used to efficiently check if a string is a palindrome by comparing characters from both ends of the string.

## Plan

> 1. We will use two pointers:
>    - One starting from the beginning (`left`).
>    - One starting from the end (`right`).
> 1. Move the pointers towards the center, comparing characters at each step. If at any point the characters don't match, return `false`.
> 1. If the pointers meet or cross each other and all characters match, return `true`.

### Time Complexity

- **O(n)**, where `n` is the length of the string, because we only make a single pass through the string.

### Project Structure

```text
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

### 1. `build.gradle` File

The `build.gradle` file will define the project dependencies and the tasks needed to compile and run the code.

```groovy
plugins {
    id 'java'
}

group 'com.ldsa.Palindrome2p'  // Your package namespace
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
    main = 'com.ldsa.Palindrome2p.Palindrome'  // Main class to run
    classpath = sourceSets.main.runtimeClasspath
}
```

### 2. `settings.gradle` File

```groovy
rootProject.name = 'learn-algorithms'
```

### 3. Java Files with Packages

#### `Palindrome.java` (Main class for checking palindrome)

```java
package com.ldsa.Palindrome2p;

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

#### `PalindromeChecker.java` (Utility class to check for palindrome)

```java
package com.ldsa.Palindrome2p;

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

        return true;  // All characters matched, it's a palindrome
    }
}
```

#### `PalindromeTest.java` (JUnit test cases for palindrome checking)

```java
package com.ldsa.Palindrome2p;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {

    @Test
    public void testPalindromeWithValidCases() {
        assertTrue(PalindromeChecker.isPalindrome("AmanaplanacanalPanama"));
        assertTrue(PalindromeChecker.isPalindrome("racecar"));
        assertTrue(PalindromeChecker.isPalindrome("MadamInEdenImAdam"));
        assertTrue(PalindromeChecker.isPalindrome("12321"));
    }

    @Test
    public void testPalindromeWithInvalidCases() {
        assertFalse(PalindromeChecker.isPalindrome("hello"));
        assertFalse(PalindromeChecker.isPalindrome("not a palindrome"));
    }
}
```

### Explanation

1. **Input Preprocessing**: The string is cleaned by converting everything to lowercase. This ensures the palindrome check is case-insensitive.
2. **Two Pointers**: We initialize two pointers (`left` at the beginning of the string and `right` at the end). We compare the characters at these pointers, and if they are the same, we move the pointers closer towards the center.
3. **Termination Condition**: The loop continues as long as `left` is less than `right`. If the characters at both pointers are unequal, the function returns `false`. If we traverse the whole string without a mismatch, the function returns `true`.

### Example Test Cases

- `"AmanaplanacanalPanama"` → **true** (ignoring case, it's a palindrome)
- `"racecar"` → **true**
- `"hello"` → **false**
- `"MadamInEdenImAdam"` → **true**
- `"12321"` → **true**

### Running the Project

1. **Build the Project**: You can build the project using Gradle by running:

   ```bash
   ./gradlew build

   gradle build
   ```

2. **Run the Program**: To execute the `Palindrome` class (which contains the `main` method), run:

   ```bash
   ./gradlew runAll

   gradle runAll
   ```

   This will output whether each test string is a palindrome or not.

3. **Run Tests**: To run the JUnit tests, use:

   ```bash
   ./gradlew test

   gradle test
   ```

4. **Stop Gradle**: To run the JUnit tests, use:

   ```bash
   ./gradlew stop

   gradle stop
   ```

   This will execute all tests and show the results in the console.
