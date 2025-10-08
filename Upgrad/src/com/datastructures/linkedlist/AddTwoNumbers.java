package com.datastructures.linkedlist;

//You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
/*Example1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
*/
public class AddTwoNumbers {

    public static void main(String[] args) {
        input1();
        input2();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int sum = 0;

        while (l1 != null || l2 != null || sum > 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
                System.out.println("li " + l1);
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            System.out.println("addTwoNumbers Sum " + sum);
            curr.next = new ListNode(sum % 10);
            sum /= 10;
            curr = curr.next;
        }

        return dummy.next;
    }
    static void input1(){
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(3);


        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(7);
        list2.next.next = new ListNode(4);
        list2.next.next.next = new ListNode(5);
        ListNode.printList("input1 list1", list1);
        ListNode.printList("input1 list2", list2);
        ListNode.printList("input1 addTwoNumbers", addTwoNumbers(list1,list2));

    }

    static void input2(){

    }
}
