# Remove Nth Node from End of List

To solve the "Remove Nth Node from End of List" problem, you can use a two-pointer approach. Here’s a step-by-step solution in Java:

## Approach

1. **Two-Pointer Technique**:

   - Start with two pointers, both initially pointing to the head of the linked list.
   - Move the first pointer `n` steps ahead.
   - Then move both pointers one step at a time until the first pointer reaches the end of the list.
   - At this point, the second pointer will be at the node just before the one you need to remove.

2. **Edge Cases**:
   - If the head node needs to be removed, adjust the `head` reference directly.
   - Handle lists with only one node, or when `n` equals the length of the list.

### Solution Code

```java
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to handle edge cases like removing the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        // Move first pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers until first pointer reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Skip the nth node from the end
        second.next = second.next.next;

        // Return the head of the modified list
        return dummy.next;
    }
}
```

### Explanation of the Code

1. **Dummy Node**: A dummy node is created and points to the head of the list. This helps handle cases where the head itself needs to be removed.
2. **Advance `first` Pointer**: Move the `first` pointer `n + 1` steps forward, which ensures there is a gap of `n` nodes between the `first` and `second` pointers.
3. **Move Both Pointers**: Now move both `first` and `second` pointers one step at a time until `first` reaches the end. The `second` pointer will be right before the node to be removed.
4. **Remove Node**: Change `second.next` to skip the `n`th node from the end.
5. **Return Result**: Return `dummy.next` which points to the potentially new head of the list.

### Complexity Analysis

- **Time Complexity**: \(O(k)\), where \(k\) is the number of nodes in the list, since we only traverse the list once.
- **Space Complexity**: \(O(1)\), as no additional space is used other than a few pointers.

### Example

```java
public static void main(String[] args) {
    // Create a sample list 1 -> 2 -> 3 -> 4 -> 5
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    RemoveNthFromEnd solution = new RemoveNthFromEnd();
    int n = 2;  // Remove the 2nd node from the end

    ListNode modifiedHead = solution.removeNthFromEnd(head, n);

    // Print the modified list
    ListNode current = modifiedHead;
    while (current != null) {
        System.out.print(current.val + " -> ");
        current = current.next;
    }
    // Expected Output: 1 -> 2 -> 3 -> 5 ->
}
```

This approach handles all constraints effectively and efficiently.

Here’s a test case Java file for the "Remove Nth Node from End of List" solution. This file will test various cases, including removing nodes from different positions in the list.

### Test Case File (RemoveNthFromEndTest.java)

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RemoveNthFromEndTest {

    // Helper method to create a linked list from an array
    public ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;  // Return the head of the list
    }

    // Helper method to convert the linked list to a string for easier verification
    public String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(" -> ");
            head = head.next;
        }
        return sb.toString();
    }

    @Test
    public void testRemoveNthFromEnd() {
        RemoveNthFromEnd solution = new RemoveNthFromEnd();

        // Test Case 1: Remove 2nd node from the end in a list of 5 elements
        ListNode head = createList(new int[]{1, 2, 3, 4, 5});
        ListNode result = solution.removeNthFromEnd(head, 2);
        assertEquals("1 -> 2 -> 3 -> 5", listToString(result));

        // Test Case 2: Remove the head node (1st from the end) in a list of 5 elements
        head = createList(new int[]{1, 2, 3, 4, 5});
        result = solution.removeNthFromEnd(head, 5);  // Removing the first node
        assertEquals("2 -> 3 -> 4 -> 5", listToString(result));

        // Test Case 3: Remove the last node (5th from the end) in a list of 5 elements
        head = createList(new int[]{1, 2, 3, 4, 5});
        result = solution.removeNthFromEnd(head, 1);  // Removing the last node
        assertEquals("1 -> 2 -> 3 -> 4", listToString(result));

        // Test Case 4: Remove 1st node from the end in a list of 1 element
        head = createList(new int[]{1});
        result = solution.removeNthFromEnd(head, 1);  // Removing the only node
        assertNull(result);  // The list should become empty

        // Test Case 5: Remove the 1st node from the end in a list of 2 elements
        head = createList(new int[]{1, 2});
        result = solution.removeNthFromEnd(head, 2);  // Removing the first node
        assertEquals("2", listToString(result));

        // Test Case 6: Remove the last node in a list of 2 elements
        head = createList(new int[]{1, 2});
        result = solution.removeNthFromEnd(head, 1);  // Removing the last node
        assertEquals("1", listToString(result));

        // Test Case 7: Remove node from a larger list
        head = createList(new int[]{10, 20, 30, 40, 50, 60});
        result = solution.removeNthFromEnd(head, 4);  // Remove 4th node from the end (40)
        assertEquals("10 -> 20 -> 30 -> 50 -> 60", listToString(result));
    }
}
```

### Explanation of the Test Case Code

1. **Helper Methods**:

   - `createList(int[] arr)`: Converts an array of integers into a linked list.
   - `listToString(ListNode head)`: Converts a linked list into a string format (for easier comparison).

2. **Test Cases**:
   - **Test Case 1**: Removes the 2nd node from the end in a list of 5 elements (removes node `4`).
   - **Test Case 2**: Removes the 5th node from the end (removes node `1`, i.e., the head node).
   - **Test Case 3**: Removes the 1st node from the end (removes node `5`).
   - **Test Case 4**: Removes the only node in the list (head node), expecting the list to be empty (`null`).
   - **Test Case 5**: Removes the 2nd node from the end in a list of 2 elements (removes node `1`).
   - **Test Case 6**: Removes the last node (removes node `2`).
   - **Test Case 7**: Removes the 4th node from the end in a list of 6 elements (removes node `40`).

### How to Run the Tests

To run the tests, you can use a testing framework like **JUnit 5**. If you are using **Gradle**, make sure to include the JUnit dependency in your `build.gradle` file:

```gradle
dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.7.2'
    testImplementation 'org.junit.jupiter:junit-jupiter-engine:5.7.2'
}
```

Run the tests using the following command:

```bash
gradle test
```

### Expected Output

For each test case, the expected output will be printed based on the assertions. If the assertions are true, the test will pass; otherwise, it will fail.

For example:

- **Test Case 1**: Should output `1 -> 2 -> 3 -> 5` after removing the 2nd node from the end.
- **Test Case 2**: Should output `2 -> 3 -> 4 -> 5` after removing the 1st node from the end.
- **Test Case 4**: Should result in `null`, as the list becomes empty after removal.

This setup will verify that the solution works under different scenarios.
