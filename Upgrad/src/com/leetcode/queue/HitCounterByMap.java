package com.leetcode.queue;

import java.util.HashMap;
import java.util.Map;

//Design a  hit counter which counts the number of hits received in the past 5 minutes.
//Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order
// (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.
//It is possible that several hits arrive roughly at the same time.
/*
HitCounter counter = new HitCounter();

// hit at timestamp 1.
counter.hit(1);
// hit at timestamp 2.
counter.hit(2);
// hit at timestamp 3.
counter.hit(3);
// get hits at timestamp 4, should return 3.
counter.getHits(4);
// hit at timestamp 300.
counter.hit(300);
// get hits at timestamp 300, should return 4.
counter.getHits(300);
// get hits at timestamp 301, should return 3.
counter.getHits(301);
 */
public class HitCounterByMap {
    private Map<Integer, Integer> hitCounts;

    public HitCounterByMap() {
        hitCounts = new HashMap<>();
    }

    public void hit(int timestamp) {
        hitCounts.put(timestamp, hitCounts.getOrDefault(timestamp, 0) + 1);
    }

    public int getHits(int timestamp) {
        int hits = 0;
        for (Map.Entry<Integer, Integer> entry : hitCounts.entrySet()) {
            if (timestamp - entry.getKey() < 300) {
                hits += entry.getValue();
            }
        }
        System.out.println("getHits timestamp " +hits);
        return hits;
    }

    public static void main(String[] args) {
        HitCounterByMap obj = new HitCounterByMap();
        obj.hit(1);
        obj.hit(2);
        obj.hit(3);
        obj.getHits(4);
        obj.hit(300);
        obj.getHits(300);
        obj.hit(301);
        obj.getHits(301);
        obj.hit(302);
        obj.getHits(303);
    }
}
