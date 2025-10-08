package com.leetcode.linkedlist;
//You are given an array of k linked-lists lists, each linked-
//Merge all the linked-lists into one sorted linked-list and return it.

import java.util.PriorityQueue;

/*
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {

    public static void main(String[] args) {
        input1();
    }

    //Time Complexity: O(N*K*LogK)
    //Auxiliary Space: O(K)
    public static ListNode mergeKListsUsingPriorityQueue(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a, b)->{
            return a.val-b.val;
        });

        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }
        System.out.println("mergeKListsUsingPriorityQueue pq " + pq);
        pq.forEach(
                q -> {
                ListNode.printList("mergeKListsUsingPriorityQueue q", q);
                }
        );

        if(pq.isEmpty()) return null;

        ListNode dummy=new ListNode(-1);
        ListNode last=dummy;
        while(!pq.isEmpty()){

            ListNode curr=pq.remove();
            ListNode.printList("mergeKListsUsingPriorityQueue curr", curr);
            last.next=curr;
            last=last.next;
            ListNode.printList("mergeKListsUsingPriorityQueue last", last);
            if(curr.next!=null){
                pq.add(curr.next);
            }
            pq.forEach(
                    q -> {
                        ListNode.printList("mergeKListsUsingPriorityQueue q", q);
                    }
            );
        }
        return dummy.next;
    }
    //Time Complexity: O(N * K * log K), As outer while loop in function mergeKLists() runs log K times and every time it processes N*K elements.
    //Auxiliary Space: O(N * K), Because recursion is used in SortedMerge() and to merge the final 2 linked lists of size N/2, N recursive calls will be made.
    public static ListNode mergeKListsUsingDivideAndConquer(ListNode[] lists) {

        int last = lists.length;
        while (last != 0) {
            int i = 0, j = last;
            while (i < j) {
                lists[i] = SortedMerge(lists[i], lists[j]);
                i++;
                j--;

                if (i >= j)
                    last = j;
            }
        }

        return lists[0];
    }
    public static ListNode SortedMerge(ListNode a, ListNode b){
        ListNode result = null;
        if (a == null)
            return b;
        else if (b == null)
            return a;

        if (a.val <= b.val) {
            result = a;
            result.next = SortedMerge(a.next, b);
        }else {
            result = b;
            result.next = SortedMerge(a, b.next);
        }
        return result;
    }
    static void printList(ListNode head){
        while(head!=null){
            System.out.print(head.val+" -> ");
            head=head.next;
        }
    }
    static void input1(){
        int k=3;
        ListNode[] arr=new ListNode[k];
        arr[0]=new ListNode(3);
        arr[0].next=new ListNode(5);
        arr[0].next.next=new ListNode(7);
        System.out.print("List1: ");
        printList( arr[0]);
        System.out.println();
        arr[1]=new ListNode(0);
        arr[1].next=new ListNode(6);
        System.out.print("List2: ");
        printList( arr[1]);
        System.out.println();
        arr[2]=new ListNode(1);
        arr[2].next=new ListNode(6);
        arr[2].next.next=new ListNode(28);
        System.out.print("List3: ");
        printList( arr[2]);
        System.out.println();


        ListNode head=mergeKListsUsingPriorityQueue(arr);
        System.out.print("Final List: ");
        printList(head);

    }

    static void input2(){
        int k=3;
        ListNode[] arr=new ListNode[k];
        arr[0]=new ListNode(1);
        arr[0].next=new ListNode(3);
        arr[0].next.next=new ListNode(5);
        arr[0].next.next.next=new ListNode(7);
        System.out.print("List1: ");
        printList( arr[0]);
        System.out.println();
        arr[1]=new ListNode(2);
        arr[1].next=new ListNode(4);
        arr[1].next.next=new ListNode(6);
        arr[1].next.next=new ListNode(8);
        System.out.print("List2: ");
        printList( arr[1]);
        System.out.println();
        arr[2]=new ListNode(0);
        arr[2].next=new ListNode(9);
        arr[2].next.next=new ListNode(10);
        arr[2].next.next.next=new ListNode(11);
        System.out.print("List3: ");
        printList( arr[2]);
        System.out.println();


        ListNode head=mergeKListsUsingPriorityQueue(arr);
        System.out.print("Final List: ");
        printList(head);

    }
}

