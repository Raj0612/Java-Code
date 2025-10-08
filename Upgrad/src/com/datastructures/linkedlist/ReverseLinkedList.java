package com.datastructures.linkedlist;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
      //  list1.next.next.next = new ListNode(4);

        ListNode.printList("reverseListByRecursion input", list1);
        ListNode.printList("reverseListByRecursion result", reverseListByRecursion(list1));
    }


    static ListNode reverseListByRecursion(ListNode head) {
        ListNode.printList("reverseListByRecursion head", head);
        if (head.next == null) {
            return head;
        }

        ListNode reverseList = reverseListByRecursion(head.next);
        ListNode.printList("reverseListByRecursion reverseList", reverseList);
        ListNode.printList("reverseListByRecursion head1", head);
        head.next.next = head;
        System.out.println("reverseListByRecursion head val " + head.next.next.val);
        head.next = null;

        ListNode.printList("reverseListByRecursion head2", head);
        ListNode.printList("reverseListByRecursion reverseList1", reverseList);
        System.out.println();
        return reverseList;
    }

    static ListNode reverseListWORecursion(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr!= null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode.printList("reverseList ", prev);
        return prev;
    }
}
