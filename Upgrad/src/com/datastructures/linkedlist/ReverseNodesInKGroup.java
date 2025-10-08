package com.datastructures.linkedlist;
//Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
//k is a positive integer and is less than or equal to the length of the linked list.
// If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
//You may not alter the values in the list's nodes, only nodes themselves may be changed.

/*Example1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example2:
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 */
public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        input1();
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;

        ListNode tail = head;

        for (int i = 0; i < k; ++i) {
            if (tail == null) {
                ListNode.printList("reverseKGroup loop head", head);
                return head;
            }
            tail = tail.next;
        }
        ListNode.printList("reverseKGroup head", head);
        ListNode.printList("reverseKGroup tail", tail);
        ListNode newHead = reverse(head, tail);
        ListNode.printList("reverseKGroup newHead", newHead);
        ListNode.printList("reverseKGroup head", head);
        ListNode.printList("reverseKGroup tail", tail);
        System.out.println();
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    private static ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode.printList("reverse head",head);
        ListNode.printList("reverse tail",tail);
        while (curr != tail) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    static void input1(){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);

        int k = 2;
        ListNode.printList("input1 node ", node);
        ListNode.printList("input1 reverseKGroup",reverseKGroup(node, k));
    }
}
