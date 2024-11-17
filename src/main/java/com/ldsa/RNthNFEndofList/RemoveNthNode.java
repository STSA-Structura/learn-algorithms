package com.ldsa.RNthNFEndofList;

public class RemoveNthNode {

    // Method to remove the nth node from the end of the list
    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        LinkedListNode right = head;
        LinkedListNode left = head;

        // Move `right` pointer `n` steps ahead
        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        // If `right` is null, the head node is the one to be removed
        if (right == null) {
            return head.next;
        }

        // Move both pointers until `right` reaches the end
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }

        // Remove the nth node from end
        left.next = left.next.next;

        return head;
    }
}
