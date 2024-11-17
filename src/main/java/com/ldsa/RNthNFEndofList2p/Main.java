package com.ldsa.RNthNFEndofList2p;

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {
                { 23, 89, 10, 5, 67, 39, 70, 28 },
                { 34, 53, 6, 95, 38, 28, 17, 63, 16, 76 },
                { 288, 224, 275, 390, 4, 383, 330, 60, 193 },
                { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 69, 8, 49, 106, 116, 112, 104, 129, 39, 14, 27, 12 }
        };

        int[] n = { 4, 1, 6, 9, 11 };

        // Process each test case
        for (int i = 0; i < inputs.length; i++) {
            LinkedList<Integer> inputLinkedList = new LinkedList<>();
            inputLinkedList.createLinkedList(inputs[i]);
            System.out.print((i + 1) + ". Linked List: ");
            PrintList.printListWithForwardArrow(inputLinkedList.head);
            System.out.println("n = " + n[i]);
            System.out.print("Updated Linked List: ");
            PrintList.printListWithForwardArrow(RemoveNthNode.removeNthLastNode(inputLinkedList.head, n[i]));
            System.out.println(new String(new char[50]).replace('\0', '-'));
        }
    }
}
