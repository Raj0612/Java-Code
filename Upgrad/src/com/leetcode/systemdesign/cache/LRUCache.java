package com.leetcode.systemdesign.cache;

import java.util.HashMap;
import java.util.Map;
//Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
/*
    Implement the LRUCache class:
    # LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    # int get(int key) Return the value of the key if the key exists, otherwise return -1.
    # void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
        If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 */
//The functions get and put must each run in O(1) average time complexity

/*
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
 */
public class LRUCache {

    HashMap<Integer, Info> cache;
    int capacity;
    int timeStamp;

    public LRUCache(int capacity){
        cache = new HashMap<>();
        this.capacity = capacity;
    }

    public void put(int key, int value){
        if(cache.containsKey(key)){
            cache.put(key, new Info(value, timeStamp));
            timeStamp++;
            return;
        }

        if(cache.size() == capacity){

            int minm = Integer.MAX_VALUE;
            Map.Entry<Integer,Info> lru_entry = null;

            for (Map.Entry<Integer,Info> entry : cache.entrySet()){

                Info info = entry.getValue();
                if(info.time < minm){
                    minm = info.time;
                    lru_entry = entry;
                }
            }
            cache.remove(lru_entry.getKey());
        }
        cache.put(key, new Info(value, timeStamp));
        timeStamp++;
    }

    public int get(int key) {

        if(!cache.containsKey(key)){
            return -1;
        }

        int val = cache.get(key).val;

        cache.put(key, new Info(val, timeStamp));
        timeStamp++;
        return val;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        lRUCache.put(1, 1);
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3);
        System.out.println("cache map1 " + lRUCache.cache);
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4);
        System.out.println("cache map2 " + lRUCache.cache);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));
        System.out.println("cache map3 " + lRUCache.cache);
    }
}

class Info{
    int val;
    int time;

    @Override
    public String toString() {
        return "Info{" +
                "val=" + val +
                ", time=" + time +
                '}';
    }

    public Info(int val, int time) {
        this.val = val;
        this.time = time;
    }
}
