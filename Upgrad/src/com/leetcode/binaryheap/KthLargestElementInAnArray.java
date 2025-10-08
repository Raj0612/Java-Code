package com.leetcode.binaryheap;

import java.util.Arrays;
import java.util.PriorityQueue;

//Given an integer array nums and an integer k, return the kth largest element in the array.
//Note that it is the kth largest element in the sorted order, not the kth distinct element.
//Can you solve it without sorting?
public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        input1();
        input2();
    }

    public static int findKthLargestByPriorityQueue(int[] nums, int k) {
        System.out.println("findKthLargestByPriorityQueue nums " + Arrays.toString(nums) + " k: " + k);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.add(num);
            if(pq.size() > k){
                pq.remove();
            }
        }
        return pq.peek();
    }
    public static int findKthLargestByPriorityQueue1(int[] nums, int k) {
        System.out.println("findKthLargestByPriorityQueue1 nums " + Arrays.toString(nums) + " k: " + k);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<k; i++){ //O(klogk) ==>O(k)
            pq.add(nums[i]);
        }
        System.out.println("findKthLargestByPriorityQueue1 pq " + pq);
        for(int i=k; i<nums.length; i++){ //n-k times logk = O(n-k * logk)
            if(nums[i] > pq.peek()){
                pq.poll();
                pq.add(nums[i]);
                System.out.println("findKthLargestByPriorityQueue1 " + pq);
            }
        }
        return pq.peek();
    }



    //Time: O(n * k)
    public static int findKthLargestWithoutSortByBruteForce(int[] nums, int k) {
        int n = nums.length;
        for(int i = 0; i < k; i++) {
            int largestIndex = findLargestIndex(nums, n-i);

            int temp = nums[largestIndex];
            nums[largestIndex] = nums[n-i-1];
            nums[n-i-1] = temp;
        }

        return nums[n-k];
    }


    //Time : 0(n)
    static int findLargestIndex(int[] nums, int last_index){

        int largest = Integer.MIN_VALUE;
        int largestIndex  = 0;
        for(int i=0; i<last_index; i++){
            if(nums[i] > largest){
                largest = nums[i];
                largestIndex = i;
            }
        }
        return largestIndex;
    }
    public static int findKthLargestWithoutSortByBruteForce1(int[] nums, int k) {
        System.out.println("findKthLargestWithoutSortByBruteForce1 " + Arrays.toString(nums));
        int kth_largest =0;
        int i, largestIndex =0;
        for(i = 0; i < k; i++) {
            kth_largest = Integer.MIN_VALUE;
            int  previous_largest  = 0;
            largestIndex = 0;
            for(int j =0 ; j<nums.length; j++){
                kth_largest = Math.max(kth_largest, nums[j]);
                if(kth_largest > previous_largest) {
                    previous_largest = kth_largest;
                    largestIndex = j;
                }
            }
            if(i!=k)
                nums[largestIndex] = 0;

            System.out.println("findKthLargestWithoutSortByBruteForce1 after iterate" + Arrays.toString(nums));

        }

        return kth_largest;
    }

    public static int findKthLargestBySort(int[] nums, int k) {
        System.out.println("findKthLargestBySort nums " + Arrays.toString(nums) + " k: " + k);
        int n = nums.length;
        Arrays.sort(nums);
        System.out.println("findKthLargestBySort after sort " + Arrays.toString(nums) + " k: " + k);
        return nums[n - k];
    }
    static void input1(){
        int[] nums = {3,2,1,5,6,4, 7, 2, 3};
        int k = 3;
       // System.out.println("input1 findKthLargestBySort " +findKthLargestBySort(nums, k));

        System.out.println("input1 findKthLargestWithoutSortByBruteForce " +findKthLargestWithoutSortByBruteForce(nums, k));
        System.out.println("input1 findKthLargestByPriorityQueue " +findKthLargestByPriorityQueue(nums, k));
       System.out.println("input1 findKthLargestByPriorityQueue1 " +findKthLargestByPriorityQueue1(nums, k));
    }

    static void input2(){
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        //System.out.println("input2 findKthLargestBySort " +findKthLargestBySort(nums, k));
        System.out.println();
        //System.out.println("input2 findKthLargestWithoutSortByBruteForce " +findKthLargestWithoutSortByBruteForce(nums, k));
        System.out.println("input2 findKthLargestByPriorityQueue " +findKthLargestByPriorityQueue(nums, k));
    }

}

