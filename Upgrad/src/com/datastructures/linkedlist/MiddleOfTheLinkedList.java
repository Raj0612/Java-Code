package com.datastructures.linkedlist;

//Given the head of a singly linked list, return the middle node of the linked list.
//If there are two middle nodes, return the second middle node.
/*Example 1:
        Input: head = [1,2,3,4,5]
        Output: [3,4,5]
        Explanation: The middle node of the list is node 3.
Example 2:
        Input: head = [1,2,3,4,5,6]
        Output: [4,5,6]
        Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.*/
public class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        input1();
        input2();
    }

    //Time - O(n)
    //Space - O(1)

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!= null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    static void input1(){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode.printList("input1" ,node);
        System.out.println("input1 middleNode " + middleNode(node));
        //  System.out.println("input11 isPalindromeByArrayList " + isPalindromeByArrayList(node));
    }

    static void input2(){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(5);
        ListNode.printList("input1" ,node);
        System.out.println("input2 middleNode " + middleNode(node));
        //  System.out.println("input11 isPalindromeByArrayList " + isPalindromeByArrayList(node));
    }
}
