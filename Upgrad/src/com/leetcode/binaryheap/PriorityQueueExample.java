package com.leetcode.binaryheap;

import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(4);
        pq.add(13);
        pq.add(11);
        System.out.println("pq " + pq);
        pq.poll();
        System.out.println("pq " + pq);
    }
}
