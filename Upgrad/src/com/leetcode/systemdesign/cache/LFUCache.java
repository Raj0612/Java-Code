package com.leetcode.systemdesign.cache;

//Design and implement a data structure for a Least Frequently Used (LFU) cache.
/*
Implement the LFUCache class:

   # LFUCache(int capacity) Initializes the object with the capacity of the data structure.
   # int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
   # void put(int key, int value) Update the value of the key if present, or inserts the key if not already present.
    When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item.
    For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
 */

//To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

//When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation).
// The use counter for a key in the cache is incremented either a get or put operation is called on it.
//The functions get and put must each run in O(1) average time complexity.

/*
Input
["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, 3, null, -1, 3, 4]

Explanation
// cnt(x) = the use counter for key x
// cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
LFUCache lfu = new LFUCache(2);
lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
lfu.get(1);      // return 1
                 // cache=[1,2], cnt(2)=1, cnt(1)=2
lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
                 // cache=[3,1], cnt(3)=1, cnt(1)=2
lfu.get(2);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,1], cnt(3)=2, cnt(1)=2
lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
                 // cache=[4,3], cnt(4)=1, cnt(3)=2
lfu.get(1);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,4], cnt(4)=1, cnt(3)=3
lfu.get(4);      // return 4
                 // cache=[4,3], cnt(4)=2, cnt(3)=3
 */

import java.util.HashMap;
import java.util.PriorityQueue;
public class LFUCache {
    private HashMap<Integer, Node> heads;
    private HashMap<Integer, Node> tails;
    private HashMap<Integer, Node> data;
    private PriorityQueue<Integer> freqs;
    private int capacity;

    boolean increaseFlag = true;

    boolean putFlag = true;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        heads = new HashMap<Integer, Node>();
        tails = new HashMap<Integer, Node>();
        heads.put(0, new Node(-1, -1));
        tails.put(0, new Node(-1, -1));
        heads.get(0).next = tails.get(0);
        tails.get(0).pre = heads.get(0);
        data = new HashMap<Integer, Node>();
        freqs = new PriorityQueue<Integer>();
    }


    public int get(int key) {
        if (!data.containsKey(key) || capacity == 0) {
            return -1;
        }
        Node n = data.get(key);
        increase(n);
        return n.val;
    }

    private void increase(Node n) {
        if(increaseFlag) System.out.println("increase freqs " + freqs + " Node " + n);
        freqs.remove(n.freq);
        if(increaseFlag) System.out.println("increase freqs1 " + freqs);
        n.freq ++;
        freqs.add(n.freq);
        if(increaseFlag)  {
            System.out.println("increase freqs2 " + freqs);
            System.out.println("increase heads " + heads);
            System.out.println("increase tails " + tails);
        }
        remove(n);
        if (!heads.containsKey(n.freq)) {
            heads.put(n.freq, new Node(-1, -1));
            tails.put(n.freq, new Node(-1, -1));
            heads.get(n.freq).next = tails.get(n.freq);
            tails.get(n.freq).pre = heads.get(n.freq);
        }
        if(increaseFlag) {
            System.out.println("increase heads1 " + heads);
            System.out.println("increase tails1 " + tails);
        }
        // Node head = heads.get(n.freq);
        Node tail = tails.get(n.freq);
        if(increaseFlag)  {
            System.out.println("increase tail " + tail);
            System.out.println("increase n " + n);
        }
        n.pre = tail.pre;
        tail.pre = n;
        n.pre.next = n;
        n.next = tail;
    }

    private void remove(Node n) {
        Node pre = n.pre;
        Node next = n.next;
        pre.next = next;
        next.pre = pre;
    }

    public void put(int key, int value) {
        System.out.println();
        if (capacity == 0) {
            return;
        }
        if (data.containsKey(key)) {
            data.get(key).val = value;
            increase(data.get(key));
            return;
        }
        if (data.size() == capacity) {
            int freq = freqs.poll();
            Node n = heads.get(freq).next;
            remove(n);
            data.remove(n.key);
        }
        Node n = new Node(key, value);
        data.put(key, n);
        if(putFlag)  System.out.println("put data1 " + data);
        heads.get(0).next = n;
        n.pre = heads.get(0);
        tails.get(0).pre = n;
        n.next = tails.get(0);
        if(putFlag)   {
            System.out.println("put heads " + heads);
            System.out.println("put tails " + tails);
        }
        increase(n);
    }

    private class Node {
        public Node pre;
        public Node next;
        public int key;
        public int val;
        public int freq;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.pre = null;
            this.next = null;
            this.freq = 0;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", val=" + val +
                    ", freq=" + freq +
                    '}';
        }

    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1,1);
        lfuCache.put(2,2);
       /* lfuCache.get(1);
        lfuCache.put(3,3);
        lfuCache.get(2);
        lfuCache.get(3);
        lfuCache.put(4,4);
        lfuCache.get(1);*/
    }
}




