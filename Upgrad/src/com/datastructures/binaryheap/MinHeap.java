package com.datastructures.binaryheap;

import java.util.Arrays;

public class MinHeap {
    private int[] heapArray;
    private int capacity;

    @Override
    public String toString() {
        return Arrays.toString(heapArray);
    }

    private int current_heap_size;
    public MinHeap(int n) {
        capacity = n;
        heapArray = new int[capacity];
        current_heap_size = 0;
    }

    // Returns the minimum key (key at root) from min heap
    public int getMin() {
        return heapArray[0];
    }
    public boolean insertKey(int key) {
        if (current_heap_size == capacity) {
            return false;
        }

        int i = current_heap_size;
        heapArray[i] = key;
        current_heap_size++;

        // Fix the min heap property if it is violated
        while (i != 0 && heapArray[i] < heapArray[parent(i)]) {
            swap(heapArray, i, parent(i));
            i = parent(i);
        }
        return true;
    }

    //This function deletes key at the given index. It first reduced value to minus infinite, then calls extractMin()
    public void deleteKey(int key) {
        decreaseKey(key, Integer.MIN_VALUE);
        int extractMin = extractMin();
        System.out.println("deleteKey key " + key + " extractMin " + extractMin);
    }

    // Decreases value of given key to new_val. It is assumed that new_val is smaller  than heapArray[key].
    public void decreaseKey(int key, int new_val) {
        heapArray[key] = new_val;

        while (key != 0 && heapArray[key] < heapArray[parent(key)]) {
            swap(heapArray, key, parent(key));
            key = parent(key);
        }
    }

    // Increases value of given key to new_val. It is assumed that new_val is greater than heapArray[key]. Heapify from the given key
    public void increaseKey(int key, int new_val) {
        heapArray[key] = new_val;
        MinHeapify(key);
    }

    // Changes value on a key
    public void changeValueOnAKey(int key, int new_val) {
        if (heapArray[key] == new_val) {
            return;
        }
        if (heapArray[key] < new_val) {
            increaseKey(key, new_val);
        } else {
            decreaseKey(key, new_val);
        }
    }

    //Method to remove minimum element (or root) from min heap
    public int extractMin() {
        System.out.println("extractMin heapArray " + Arrays.toString(heapArray));
        if (current_heap_size <= 0) {
            return Integer.MAX_VALUE;
        }

        if (current_heap_size == 1) {
            current_heap_size--;
            return heapArray[0];
        }

        // Store the minimum value, and remove it from heap
        int root = heapArray[0];

        heapArray[0] = heapArray[current_heap_size - 1];
        current_heap_size--;
        MinHeapify(0);

        return root;
    }

    // A recursive method to heapify a subtree with the root at given index This method assumes that the subtrees are already heapified
    private void MinHeapify(int key) {
        int l = left(key);
        int r = right(key);

        int smallest = key;
        if (l < current_heap_size && heapArray[l] < heapArray[smallest]) {
            smallest = l;
        }
        if (r < current_heap_size && heapArray[r] < heapArray[smallest]) {
            smallest = r;
        }

        if (smallest != key) {
            swap(heapArray, key, smallest);
            MinHeapify(smallest);
        }
    }

    // Get the Left Child index for the given index
    private int left(int key) {
        return 2 * key + 1;
    }

    // Get the Right Child index for the given index
    private int right(int key) {
        return 2 * key + 2;
    }

    private int parent(int key) {
        return (key - 1) / 2;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {

        input1();
     //   input2();

    }

    static void input1() {
        MinHeap h = new MinHeap(11);
        h.insertKey(3);
        h.insertKey(2);
        h.insertKey(15);
        h.insertKey(5);
        h.insertKey(4);
        h.insertKey(45);
        h.insertKey(1);

        System.out.println("MinHeap h " + h);
        h.deleteKey(5);
        System.out.println("MinHeap h " + h);
        h.insertKey(6);
        //System.out.println("MinHeap h " + h);
        // System.out.print(h.extractMin() + " ");
        // System.out.print(h.getMin() + " ");

        //  h.decreaseKey(2, 1);
        // System.out.print(h.getMin());
    }

   public static void input2(){
        MinHeap h = new MinHeap(8);
        h.insertKey(5);
        h.insertKey(3);
        h.insertKey(4);
        h.insertKey(6);
        h.insertKey(1);

        h.deleteKey(3);
        System.out.println("MinHeap h " + h);
    }
}
