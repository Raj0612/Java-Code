package com.leetcode.binaryheap;

import java.util.PriorityQueue;

public class KthSmallestElementInAnArray {
    public static void main(String[] args) {
        input1();
        input2();
    }


    public static int findKthSmallestByPriorityQueue(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
        }

        for (int i = 1; i < k; i++) {
            minHeap.poll();
        }

        return minHeap.peek();
    }

    static void input1(){
        int[] nums = {3,2,1,5,6,4, 7, 2, 3};
        int k = 3;
        System.out.println("input1 findKthSmallestByPriorityQueue " +findKthSmallestByPriorityQueue(nums, k));
    }

    static void input2(){
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println("input2 findKthSmallestByPriorityQueue " +findKthSmallestByPriorityQueue(nums, k));
    }
}
