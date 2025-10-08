package com.leetcode.systemdesign.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheListNode {
    int capacity;
    Map<Integer, ListNode> hashmap;
    ListNode head;
    ListNode tail;

    public LRUCacheListNode(int capacity) {
        this.capacity = capacity;
        hashmap = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!hashmap.containsKey(key)) {
            return -1;
        }

        ListNode node = hashmap.get(key);
        remove(node);
        add(node);
        return node.val;
    }

    public void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void put(int key, int value) {
        if (hashmap.containsKey(key)) {
            ListNode oldNode = hashmap.get(key);
            remove(oldNode);
        }

        ListNode node = new ListNode(key, value);
        hashmap.put(key, node);
        add(node);

        if (hashmap.size() > capacity) {
            ListNode nodeToDelete = head.next;
            remove(nodeToDelete);
            hashmap.remove(nodeToDelete.key);
        }
    }

    public void add(ListNode node) {
        ListNode previousEnd = tail.prev;
        previousEnd.next = node;
        node.prev = previousEnd;
        node.next = tail;
        tail.prev = node;
    }

    public static void main(String[] args) {
        LRUCacheListNode lRUCache = new LRUCacheListNode(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        System.out.println("cache map " + lRUCache.hashmap);
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3);
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));
    }
}
class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "key=" + key +
                ", val=" + val +
                '}';
    }
}
