package com.datastructures.priorityqueue;

import java.util.PriorityQueue;

public class PriorityQueueEx {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(4); //O(log n)
        pq.add(3);
        pq.add(2);
        pq.add(1);
        pq.add(10);
        pq.add(14);

        System.out.println("pq " + pq);
    }
}
