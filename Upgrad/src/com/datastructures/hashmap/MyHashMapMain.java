package com.datastructures.hashmap;

import java.util.ArrayList;
import java.util.Objects;

public class MyHashMapMain {
    public static void main(String args[]) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
      /*  map.add("this", 1);
        map.add("thsi", 2);
        map.add("sthi", 3);*/
        //map.add("", 5);
        map.add("this", 1);
        map.add("test", 2);
        map.add("abc", 3);
        //System.out.println("Map size " + map.size());
        System.out.println();
       // System.out.println("Map get " + map.get("sthi"));
        System.out.println(map.remove("this"));
      //  System.out.println(map.remove("this"));
      //  System.out.println(map.size());
      //  System.out.println(map.isEmpty());
    }
}

class MyHashMap<K, V> {
    private ArrayList<HashNode<K, V>> bucketArray;

    // Current capacity of array list
    private int numBuckets;

    // Current size of array list
    private int size;

    // Constructor (Initializes capacity, size and
    // empty chains.
    public MyHashMap() {
        bucketArray = new ArrayList<>();
        numBuckets = 10;
        size = 0;

        // Create empty chains
        for (int i = 0; i < numBuckets; i++)
            bucketArray.add(null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private final int hashCode(K key) {
        return Objects.hashCode(key);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    // This implements hash function to find index for a key
    private int getBucketIndex(K key) {
        int hashCode = hashCode(key);
        int index = hashCode % numBuckets;
        // key.hashCode() could be negative.
        System.out.println("getBucketIndex key " + key + " hashCode " + hashCode + " numBuckets " + numBuckets + " index " + index);
        index = index < 0 ? index * -1 : index;
        return index;
    }

    // Method to remove a given key
    public V remove(K key) {
        System.out.println("******Remove*******");
        // Apply hash function to find index for given key
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);

        // Get head of chain
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        System.out.println("remove key " + key + " bucketIndex " + bucketIndex + " hashCode " + hashCode + " head " + head);
        // Search for key in its chain
        HashNode<K, V> prev = null;
        while (head != null) {
            // If Key found
            if (head.key.equals(key) && hashCode == head.hashCode)
                break;

            // Else keep moving in chain
            prev = head;
            head = head.next;
        }
        System.out.println("remove prev " + prev + " head " + head);
        // If key was not there
        if (head == null)
            return null;

        // Reduce size
        size--;

        // Remove key
        if (prev != null)
            prev.next = head.next;
        else
            bucketArray.set(bucketIndex, head.next);
        System.out.println("remove head.value " + head.value);
        return head.value;
    }

    // Returns value for a key
    public V get(K key) {
        System.out.println("******Get*******");
        System.out.println("get key " + key);
        // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        System.out.println("get bucketIndex " + bucketIndex + " hashCode " + hashCode);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        System.out.println("get head " + head);
        // Search key in chain
        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode)
                return head.value;
            head = head.next;
        }

        // If key not found
        return null;
    }

    // Adds a key value pair to hash
    public void add(K key, V value) {
        // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        System.out.println("add hashCode " + hashCode);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        System.out.println("add bucketIndex " + bucketIndex + " hashCode " + hashCode + " head " + head);
        // Check if key is already present
        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        // Insert key in chain
        size++;
        head = bucketArray.get(bucketIndex);
        System.out.println( "add head1 " + head);
        HashNode<K, V> newNode
                = new HashNode<K, V>(key, value, hashCode);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);

        System.out.println("add size " + size + " numBuckets " + numBuckets  + " Load check " + ((1.0 * size) / numBuckets) + " bucketArray size " + bucketArray.size());
        // If load factor goes beyond threshold, then double hash table size
        if ((1.0 * size) / numBuckets >= 0.9) {
            System.out.println();
            ArrayList<HashNode<K, V>> temp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;

            size = 0;
            System.out.println("add  numBuckets " + numBuckets + " size " + size);
            for (int i = 0; i < numBuckets; i++)
                bucketArray.add(null);
            System.out.println("add  bucketArray size " + bucketArray.size());
            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

}

class HashNode<K, V> {
    K key;
    V value;

    @Override
    public String toString() {
        return "HashNode{" +
                "key=" + key +
                ", value=" + value +
                ", hashCode=" + hashCode +
                ", next=" + next +
                '}';
    }

    final int hashCode;

    // Reference to next node
    HashNode<K, V> next;

    // Constructor
    public HashNode(K key, V value, int hashCode) {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }
}
