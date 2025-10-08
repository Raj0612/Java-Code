package com.leetcode.linkedlist;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }

    static void printList(String method, ListNode node){
        System.out.print(method + " ListNode: ");
        while(node!=null){
            System.out.print(node.val + "-->");
            node = node.next;
        }
        System.out.println();
    }
}
