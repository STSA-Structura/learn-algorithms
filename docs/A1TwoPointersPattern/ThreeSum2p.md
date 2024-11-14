# Three Sum / Valid Triplet

To solve the problem of finding whether there are three integers in the given array `nums` whose sum equals the given `target`, we can use an efficient approach based on sorting and the two-pointer technique. Here's how the solution works:

## Approach:

1. **Sort the Array**: Sorting the array helps in efficiently finding triplets using the two-pointer technique.
2. **Iterate Over Each Element**: For each element in the array (starting from the first element), treat it as the first element of the triplet.
3. **Use Two Pointers for the Remaining Elements**: After selecting the first element, use two pointers to find two more elements whose sum along with the selected element equals the target:
   - One pointer starts just after the selected element.
   - The other pointer starts from the end of the array.
4. **Adjust the Pointers**:
   - If the sum of the three numbers is less than the target, move the left pointer to the right (to increase the sum).
   - If the sum is greater than the target, move the right pointer to the left (to decrease the sum).
   - If the sum equals the target, return `TRUE`.
5. **Repeat for All Elements**: Continue this process for all elements in the array.

### Complexity:

- **Time Complexity**: Sorting the array takes \(O(n \log n)\), and for each element, we perform a two-pointer search in \(O(n)\), resulting in an overall time complexity of \(O(n^2)\), which is efficient for `n <= 500`.
- **Space Complexity**: \(O(1)\) extra space since we modify the array in place.

### Solution Code (Java):

```java
import java.util.Arrays;

public class ThreeSum {

    public boolean validTriplet(int[] nums, int target) {
        // Sort the array first
        Arrays.sort(nums);

        // Iterate over each element as the first element of the triplet
        for (int i = 0; i < nums.length - 2; i++) {
            // Avoid duplicates: skip the same number as the previous one
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Two-pointer technique for finding the remaining two elements
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    return true;  // Found a valid triplet
                } else if (sum < target) {
                    left++;  // Need a larger sum, move left pointer to the right
                } else {
                    right--;  // Need a smaller sum, move right pointer to the left
                }
            }
        }

        return false;  // No valid triplet found
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();

        // Test case example
        int[] nums = {-1, 2, 1, -4};
        int target = 2;

        System.out.println(solution.validTriplet(nums, target));  // Output: true
    }
}
```

### Explanation:

- **Sorting**: The array `nums` is sorted to facilitate the two-pointer search for valid triplets.
- **Outer Loop**: The loop iterates through each element in the array. For each element, it is treated as the first number of the triplet.
- **Two Pointers**: For the remaining elements after the current element, we use two pointers (`left` and `right`) to find two numbers whose sum, along with the current element, equals the target.
- **Avoid Duplicates**: The condition `if (i > 0 && nums[i] == nums[i - 1])` ensures we don't consider the same element more than once as the first element of the triplet.

### Example Walkthrough:

For the input:

```java
nums = [-1, 2, 1, -4]
target = 2
```

1. **Sorted Array**: `[-4, -1, 1, 2]`
2. **First Iteration (`i = 0`)**:
   - **Current number**: `-4`
   - **Two-pointer range**: Left pointer at index 1 (`-1`), Right pointer at index 3 (`2`).
     - Sum of `-4 + (-1) + 2 = -3`, which is less than `2`. Move the left pointer.
     - Now left pointer is at index 2 (`1`), and right pointer remains at index 3 (`2`).
     - Sum of `-4 + 1 + 2 = -1`, still less than `2`. Move the left pointer.
     - Left pointer moves beyond right pointer, so move to the next element.
3. **Second Iteration (`i = 1`)**:
   - **Current number**: `-1`
   - **Two-pointer range**: Left pointer at index 2 (`1`), Right pointer at index 3 (`2`).
     - Sum of `-1 + 1 + 2 = 2`, which equals the target. Return `true`.

### Conclusion:

This solution efficiently checks if there exists a triplet whose sum is equal to the target. It works within the time constraints and handles various edge cases such as duplicates and varying input sizes.
