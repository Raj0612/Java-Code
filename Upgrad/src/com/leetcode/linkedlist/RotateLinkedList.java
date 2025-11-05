package com.leetcode.linkedlist;
//Given the head of a linked list, rotate the list to the right by k places.
/*Example1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]
*/

import java.util.Stack;

public class RotateLinkedList {

    public static void main(String[] args) {
        input1();
        input2();
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        int length = 1;
        ListNode tail = head;
        ListNode.printList("rotateRight tail", tail);
        for (; tail.next != null; tail = tail.next)
            ++length;

        System.out.println("rotateRight length " + length);
        tail.next = head; // Circle the list

        final int t = length - k % length;
        System.out.println("rotateRight t " + t);
        System.out.println("rotateRight tail " +tail);
        for (int i = 0; i < t; ++i) {
            tail = tail.next;
        }
        System.out.println("rotateRight tail " +tail);
        ListNode newHead = tail.next;
        tail.next = null;

        return newHead;
    }

    public static ListNode rotateRightByStack(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        Stack<ListNode> stack = new Stack<>();

        ListNode temp = head;

        int size =1;
        while(temp.next!=null){
            stack.push(temp);
            size++;
            temp = temp.next;
        }
        System.out.println("rotateRightByStack stack " + stack + " size " + size );
        int count =0;
        System.out.println("rotateRightByStack k " + k);
        while(count< k && stack.size() >0){
            ListNode curr = stack.pop();
            ListNode.printList("rotateRightByStack curr", curr);
            curr.next.next = head;
            head = curr.next;
            System.out.println("rotateRightByStack head " + head.val );
            curr.next = null;
            ListNode.printList("rotateRightByStack head", head);
            count++;
        }
        return head;
    }

    public static ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        System.out.println("rotateRight1 length " + length );
        k %= length;
        System.out.println("rotateRight1 k " + k);
        if (k == 0) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        ListNode.printList("rotateRight1 fast",fast);
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode.printList("rotateRight1 fast1",fast);
        ListNode.printList("rotateRight1 slow",slow);
        ListNode newHead = slow.next;
        fast.next = head;
        slow.next = null;
        return newHead;
    }

    static void input1(){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        //node.next.next.next.next.next = new ListNode(6);

        int k = 2;
        //ListNode.printList("input1 rotateRight",rotateRight(node, k));
       // ListNode.printList("input1 rotateRight1",rotateRight1(node, k));
        ListNode.printList("input1 rotateRightByStack",rotateRightByStack(node, k));
    }


    static void input2(){
        ListNode node = new ListNode(0);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);

        int k = 4;
        //ListNode.printList("input2 rotateRight",rotateRight(node, k));
      //  ListNode.printList("input2 rotateRight1",rotateRight1(node, k));
        //ListNode.printList("input2 rotateRightByStack",rotateRightByStack(node, k));
    }
}
