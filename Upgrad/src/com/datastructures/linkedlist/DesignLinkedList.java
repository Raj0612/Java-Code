package com.datastructures.linkedlist;
//Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
//A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
//If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list.
// Assume all nodes in the linked list are 0-indexed.

/*Implement the MyLinkedList class:
    1. MyLinkedList() Initializes the MyLinkedList object.
    2. int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
    3. void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
    4. void addAtTail(int val) Append a node of value val as the last element of the linked list.
    5. void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list.
            If index equals the length of the linked list, the node will be appended to the end of the linked list.
            If index is greater than the length, the node will not be inserted.
    6. void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 */

/*
Example 1:
Input
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
Output
[null, null, null, null, 2, null, 3]
*/
public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.get(1);
        myLinkedList.deleteAtIndex(1);
        System.out.println("get " +  myLinkedList.get(1));

        ListNode.printList("main " ,myLinkedList.head);
    }
}

class MyLinkedList{
    int size = 0;
    ListNode head;

    public MyLinkedList() {
        this.size = 0;
        head = null;
    }

    public int get(int index) {

        if(index< 0 || index >size)
            return -1;
        int curr_Index =0;
        ListNode curr = head;
        while(curr_Index < index){
            curr = curr.next;
            curr_Index++;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        size++;
        newNode.next = head;
        head = newNode;
    }

    public void addAtTail(int val) {
        ListNode curr = head;
        while(curr.next!=null){
            curr = curr.next;
        }
        ListNode newNode = new ListNode(val);
        curr.next = newNode;

        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index< 0 || index >size)
            return ;
        int curr_Index =0;
        ListNode curr = head;
      /*  while(curr_Index < index-1){
            curr = curr.next;
            curr_Index++;
        }*/

        for(int i=0; i<index-1; i++){
            curr = curr.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index< 0 || index >=size || head == null)
            return ;
        int curr_Index =0;
        ListNode curr = head;
        while(curr_Index < index-1){
            curr = curr.next;
            curr_Index++;
        }
        if(curr.next!=null) {
            curr.next = curr.next.next;
            size--;
        }
    }

}


