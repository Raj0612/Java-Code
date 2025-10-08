package com.datastructures.linkedlist;

//Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

/*
Example1:
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
Example2:
Input: head = [1,1,1,2,3]
Output: [2,3]
*/
public class RemoveDuplicateFromSortedListII {

    public static void main(String[] args) {
        input1();
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;


        while (head != null) {
            ListNode.printList("deleteDuplicates prev", prev);
            ListNode.printList("deleteDuplicates head", head);

            while (head.next != null && head.val == head.next.val) {
                head = head.next;
                //ListNode.printList("deleteDuplicates while  prev", prev);
                ListNode.printList("deleteDuplicates while head", head);
            }
            ListNode.printList("deleteDuplicates head1", head);
            ListNode.printList("deleteDuplicates prev", prev);
            if (prev.next == head) {
                prev = prev.next;
                ListNode.printList("deleteDuplicates if prev", prev);
            } else {
                prev.next = head.next;
                ListNode.printList("deleteDuplicates else prev", prev);
            }
            head = head.next;
            System.out.println();
        }

        return dummy.next;
    }
    static void input1(){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next.next = new ListNode(5);
        ListNode.printList("input1 ", node);
        ListNode.printList("input1 deleteDuplicate",deleteDuplicates(node));
    }
}
