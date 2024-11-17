package com.ldsa.RNthNFEndofList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RemoveNthNodeTest {

    @Test
    public void testRemoveNthLastNode() {
        // Test cases input
        int[][] inputs = {
                { 23, 89, 10, 5, 67, 39, 70, 28 },
                { 34, 53, 6, 95, 38, 28, 17, 63, 16, 76 },
                { 288, 224, 275, 390, 4, 383, 330, 60, 193 },
                { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 69, 8, 49, 106, 116, 112, 104, 129, 39, 14, 27, 12 }
        };

        // n values for each test case
        int[] nValues = { 4, 1, 6, 9, 11 };

        // Expected outputs after removing nth node from the end
        int[][] expectedOutputs = {
                { 23, 89, 10, 5, 39, 70, 28 },
                { 34, 53, 6, 95, 38, 28, 17, 63, 16 },
                { 288, 224, 275, 4, 383, 330, 60, 193 },
                { 2, 3, 4, 5, 6, 7, 8, 9 },
                { 69, 49, 106, 116, 112, 104, 129, 39, 14, 27, 12 }
        };

        for (int i = 0; i < inputs.length; i++) {
            // Create linked list from input array
            LinkedList<Integer> linkedList = new LinkedList<>();
            linkedList.createLinkedList(inputs[i]);

            // Remove nth node from the end
            LinkedListNode updatedHead = RemoveNthNode.removeNthLastNode(linkedList.head, nValues[i]);

            // Verify output against expected output
            LinkedListNode current = updatedHead;
            int[] expected = expectedOutputs[i];
            int j = 0;

            while (current != null && j < expected.length) {
                assertEquals(expected[j], current.data, "Test case " + (i + 1) + " failed.");
                current = current.next;
                j++;
            }

            // Ensure both lists end at the same time
            assertNull(current, "List has additional elements. Test case " + (i + 1) + " failed.");
            assertEquals(j, expected.length, "List is shorter than expected. Test case " + (i + 1) + " failed.");
        }
    }
}
