package com.practice;

import java.util.TreeMap;

public class HitCounterMap {
    TreeMap<Integer, Integer> map;
    public HitCounterMap() {
        map = new TreeMap<>();
    }

    public void hit(int timestamp) {
        map.put(timestamp, map.getOrDefault(timestamp, 0) + 1);
        System.out.println("hit timestamp " + timestamp + " map " + map);
    }

    public int getHits(int timestamp) {
        int start = timestamp - 300;
        if (start < 0) {
            start = 0;
        }
        int count = 0;
        for (int key : map.tailMap(start).keySet()) {
            count += map.get(key);
        }
        return count;
    }

    public static void main(String[] args) {
        HitCounterMap obj = new HitCounterMap();
        obj.hit(1);
        obj.hit(2);
        obj.hit(3);
        obj.getHits(4);
        obj.hit(300);
        obj.getHits(300);
        obj.hit(301);
        obj.getHits(301);
    }

}
