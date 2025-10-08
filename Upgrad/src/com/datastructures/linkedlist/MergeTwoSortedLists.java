package com.datastructures.linkedlist;
//You are given the heads of two sorted linked lists list1 and list2.
//Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
//Return the head of the merged linked list.

/*
Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Exmaple 2:
Input: list1 = [], list2 = []
Output: []
* */
public class MergeTwoSortedLists {
    static int counter =0;
    public static void main(String[] args) {
        input1();
    }

    public static ListNode mergeTwoListsByRecursion(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val <= list2.val) {
            list1.next = mergeTwoListsByRecursion(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoListsByRecursion(list1, list2.next);
            return list2;
        }
    }

    public static ListNode mergeTwoListsByRecursion1(ListNode list1, ListNode list2) {
        System.out.println();
        ListNode.printList("mergeTwoListsByRecursion1 list1",list1);
        ListNode.printList("mergeTwoListsByRecursion1 list2",list2);
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        if (list1.val > list2.val) {
            ListNode temp = list1;
            //ListNode.printList("mergeTwoListsByRecursion1 temp",temp);
            list1 = list2;
            //ListNode.printList("mergeTwoListsByRecursion1 list1",list1);
            list2 = temp;
            //ListNode.printList("mergeTwoListsByRecursion1 list2",list2);
        }

        list1.next = mergeTwoListsByRecursion1(list1.next, list2);
       // counter ++;
        //System.out.println("mergeTwoListsByRecursion1 counter " + counter);
        //ListNode.printList("mergeTwoListsByRecursion1 after recursion call", list1);
        return list1;
    }
    public static ListNode mergeTwoListsByDummyNodes(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode();
        ListNode tail = dummyNode;

        while (true) {
            ListNode.printList("mergeTwoListsByDummyNodes list1",list1);
            ListNode.printList("mergeTwoListsByDummyNodes list2",list2);
            if (list1 == null) {
                tail.next = list2;
                break;
            }
            if (list2 == null) {
                tail.next = list1;
                break;
            }

            if (list1.val <= list2.val) {
                tail.next = list1;
                ListNode.printList("mergeTwoListsByDummyNodes if tail",tail);
                list1 = list1.next;
                ListNode.printList("mergeTwoListsByDummyNodes if list1",list1);
            } else {
                tail.next = list2;
                ListNode.printList("mergeTwoListsByDummyNodes else tail",tail);
                list2 = list2.next;
                ListNode.printList("mergeTwoListsByDummyNodes if list2",list2);
            }

            tail = tail.next;
            ListNode.printList("mergeTwoListsByDummyNodes last tail",tail);
            ListNode.printList("mergeTwoListsByDummyNodes dummyNode",dummyNode);
            System.out.println();
        }
        ListNode.printList("mergeTwoListsByDummyNodes dummyNode1",dummyNode);
        return dummyNode.next;
    }

    public static ListNode mergeTwoListsByReverse(ListNode list1, ListNode list2) {
        list1 = reverseListByRecursion(list1);
        list2 = reverseList(list2);
        ListNode.printList("mergeTwoListsByReverse reverse List1", list1);
        ListNode.printList("mergeTwoListsByReverse reverse List2", list2);
        ListNode res = null;
        ListNode temp = null;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                temp = list1.next;

                list1.next = res;
                res = list1;

                list1 = temp;
            } else {

                temp = list2.next;
                list2.next = res;
                res = list2;
                list2 = temp;
            }
        }
        ListNode.printList("mergeTwoListsByReverse", list1);
        return list1;
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
        System.out.println("reverseListByRecursion head " + head.next.next.val);
        head.next = null;

        ListNode.printList("reverseListByRecursion head2", head);
        ListNode.printList("reverseListByRecursion reverseList1", reverseList);
        System.out.println();
        return reverseList;
    }


    static ListNode reverseList(ListNode head) {

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
    static void input1(){

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);
        ListNode.printList("input1", list1);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);


        reverseListByRecursion(list2);
        ListNode.printList("mergeTwoListsByRecursion",mergeTwoListsByRecursion(list1, list2));
       ListNode.printList("mergeTwoListsByRecursion1",mergeTwoListsByRecursion1(list1, list2));
      // ListNode.printList("mergeTwoListsByDummyNodes",mergeTwoListsByDummyNodes(list1, list2));

        // Not Working
        //  ListNode.printList("mergeTwoListsByReverse",mergeTwoListsByReverse(list1, list2));

    }
}
