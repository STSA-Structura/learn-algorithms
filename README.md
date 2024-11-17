# Learn Algorithms

I am learning Algorithms from different Video Courses, Books, and Websites.

## Reference(s)

> 1. <https://chatgpt.com>

## Running the Project

### Current Working Directory

```text
D:\TSA-Structura\learn-ds-algorithms>
```

### Build the Project: You can build the project using Gradle by running

```bash
./gradlew build

gradle build
```

### Run the Program: To execute the Palindrome class (which contains the main method), run

```bash
./gradlew run

gradle run --warning-mode all
```

### Run Tests: To run the JUnit tests, use

```bash
./gradlew test --warning-mode all

gradle test --warning-mode all
```

## Folder Structure

```text
learn-algorithms/
│
├── docs/                # Documentation related to algorithms
├── src/                 # Source code for algorithms
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── ldsa/
│   │               └── Palindrome2p/
│   │                   ├── Palindrome.java
│   │                   └── PalindromeChecker.java
│   └── test/
│       └── java/
│           └── com/
│               └── ldsa/
│                   └── Palindrome2p/
│                       └── PalindromeTest.java
├── .gitignore           # Files or directories to ignore in Git (e.g., .class files, IDE settings)
├── LICENSE              # License for your code
├── README.md            # Project description, setup instructions, and usage
├── build.gradle         # Gradle build configuration
└── settings.gradle      # Gradle settings
```

## Additional Details

The error you're seeing indicates that Gradle is unable to find the correct project configuration because you're running the build command from the `src` directory, rather than from the root directory of your Gradle project.

### Steps to resolve the issue:

1. **Ensure you're in the correct directory**:
   Gradle expects the `build.gradle` (or `build.gradle.kts`) and `settings.gradle` files to be in the root of your project directory. It looks like you're running the `gradle build` command from the `src` folder. You should run it from the root directory where your `build.gradle` file and `settings.gradle` file are located.

2. **Navigate to the root project directory**:
   In your case, it seems that the project is in `D:\TSA-Structura\learn-ds-algorithms`. You need to run the Gradle build command from that directory.

   Open a terminal/command prompt and navigate to the root directory:

   ```bash
   cd D:\TSA-Structura\learn-ds-algorithms
   ```

   Then, run the build command:

   ```bash
   gradle build
   ```

3. **Check if `settings.gradle` exists**:
   Ensure that a `settings.gradle` file exists in the root project directory (`D:\TSA-Structura\learn-ds-algorithms`). This file is important for multi-project builds. If you don't have it, you can create an empty `settings.gradle` file if this is a single-project setup.

   Example of a minimal `settings.gradle` file:

   ```gradle
   rootProject.name = 'learn-ds-algorithms'
   ```

4. **Check directory structure**:
   Make sure your project structure is correct. The `src` directory should typically be inside the project root, like this:

   ```
   learn-ds-algorithms/
   ├── build.gradle
   ├── settings.gradle
   └── src/
       ├── main/
       │   └── java/
       └── test/
           └── java/
   ```

5. **Run the build**:
   After following these steps, try running the build again from the root project directory:

   ```bash
   gradle build
   ```

This should resolve the issue and allow Gradle to find the build configuration. Let me know if you encounter any other issues!
