package com.leetcode.linkedlist;

import java.util.ArrayList;

//Given the head of a singly linked list, return true if it is a  palindrome or false otherwise.
/*Example 1:
        Input: head = [1,2,2,1]
        Output: true
Example 2:
        Input: head = [1,2]
        Output: false*/
public class PalindromeLinkedList {

    public static void main(String[] args) {
        input1();
        input2();
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        System.out.println("isPalindrome mid" + mid);
        ListNode headSecond = reverseList(mid);
        ListNode.printList("isPalindrome headSecond", headSecond );
        ListNode.printList("isPalindrome head", head );
        while(head!=null && headSecond !=null){
            if(head.val != headSecond.val){
                System.out.println();
                return false;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        return true;
    }

    public static ListNode reverseList(ListNode head){
        ListNode.printList("reverseList", head);
        if(head == null){
            return head;
        }
        ListNode current = head;
        ListNode prev = null;
        ListNode next = head.next;

        while(current!=null){
            current.next = prev;
            prev = current;
            current = next;
            if(next!= null){
                next = next.next;
            }
        }

        return prev;
    }
    public static ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast!= null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static boolean isPalindromeByArrayList(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();

        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        System.out.println("isPalindromeByArrayList list " + list);
        int i = 0;
        int j = list.size()-1;
        while(i<j){
            if(list.get(i) != list.get(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    static void input1(){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);
         ListNode.printList("input1" ,node);
        System.out.println("input1 isPalindrome " + isPalindrome(node));
        System.out.println();
       // System.out.println("input11 isPalindromeByArrayList " + isPalindromeByArrayList(node));
    }

    static void input2(){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        System.out.println("input2 isPalindrome " + isPalindrome(node));
       // System.out.println("input2 isPalindromeByArrayList " + isPalindromeByArrayList(node));
    }
}
