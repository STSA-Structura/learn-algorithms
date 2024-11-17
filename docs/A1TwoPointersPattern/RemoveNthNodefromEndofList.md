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
