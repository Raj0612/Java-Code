package com.datastructures.linkedlist;

//Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
/*
Example1:
Input: head = [1,1,2]
Output: [1,2]

Example 2:
Input: head = [1,1,2,3,3]
Output: [1,2,3]
*/
public class RemoveDuplicateFromSortedList {

    public static void main(String[] args) {
        input1();
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val)
                curr.next = curr.next.next;
            curr = curr.next;
        }

        return head;
    }
    static void input1(){
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(3);

        ListNode.printList("input1 deleteDuplicate",deleteDuplicates(node));
    }
}
