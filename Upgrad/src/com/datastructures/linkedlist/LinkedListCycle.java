package com.datastructures.linkedlist;

import java.util.HashSet;
import java.util.Set;

//Given head, the head of a linked list, determine if the linked list has a cycle in it.
//There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
// Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
//Return true if there is a cycle in the linked list. Otherwise, return false.
/*
Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
*/
public class LinkedListCycle {

    public static void main(String[] args) {
        input1();
    }

    public  static boolean hasCycleByBruteForce(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public  static boolean hasCycleByBruteForce1(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == -100000000) {
                return true;
            }
            curr.val = -100000000;
            curr = curr.next;
        }
        return false;
    }

    public  static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    static void input1(){
        ListNode node = new ListNode(3);
        node.next = new ListNode(2);
        node.next.next = new ListNode(0);
        node.next.next.next = node;
      //  ListNode.printList("input1" ,node);
        System.out.println("input1 hasCycle " + hasCycle(node));
        System.out.println("input1 hasCycleByBruteForce " + hasCycleByBruteForce(node));
        System.out.println("input1 hasCycleByBruteForce1 " + hasCycleByBruteForce1(node));
    }
}
