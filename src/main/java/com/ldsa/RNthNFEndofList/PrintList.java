package com.ldsa.RNthNFEndofList;

public class PrintList {
    public static void printListWithForwardArrow(LinkedListNode head) {
        LinkedListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
            if (temp != null) {
                System.out.print(" → ");
            }
        }
        System.out.println(" → null");
    }
}
