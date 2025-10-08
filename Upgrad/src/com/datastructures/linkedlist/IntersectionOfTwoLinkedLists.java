package com.datastructures.linkedlist;
//Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
/*
Example1:
    4 --> 1 -
              \
                8 --> 4 --> 5
               /
 5 --> 6 --> 1

Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A;
There are 3 nodes before the intersected node in B.
- Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references.
In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.

Example2:
Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Intersected at '2'
Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4].
There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 */


public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
      //  input1();
        input2();
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        while (pointerA != pointerB) {
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }
        return pointerA;
    }

    static void input1(){
        ListNode node1 = new ListNode(4);
        node1.next = new ListNode(8);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(1);
        node2.next.next.next = node1.next.next;
        /*node2.next.next.next.next = new ListNode(4);
        node2.next.next.next.next.next = new ListNode(5);*/
        ListNode result = getIntersectionNode(node1, node2);
        System.out.println("input1 " + result.val);

    }

    static void input2(){
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(9);
        node1.next.next = new ListNode(1);
        node1.next.next.next = new ListNode(2);
        //node1.next.next.next.next = new ListNode(4);

        ListNode node2 = new ListNode(3);
        //node2.next = node1.next.next.next;
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(4);

        ListNode result = getIntersectionNode(node1, node2);
        System.out.println("input2 " + result);

    }

}
