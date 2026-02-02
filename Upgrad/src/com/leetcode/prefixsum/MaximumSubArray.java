package com.leetcode.prefixsum;
//Given an integer array nums, find the subarray with the largest sum, and return its sum.
/*
Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 */
//Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
public class MaximumSubArray {
    public static void main(String[] args) {
        input1();
        //input2();
       // input3();
       // input4();
       // input5();
    }

    static void input1(){
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("input1 maxSubArrayNonOptimized: " + maxSubArrayNonOptimized(nums));
        System.out.println("input maxSubArray: " + maxSubArray(nums));
        System.out.println("input maxSubArray1: " + maxSubArray1(nums));
    }

    static void input2(){
        int nums[] = {1};
        System.out.println("input2 maxSubArrayNonOptimized: " + maxSubArrayNonOptimized(nums));
        System.out.println("input2 maxSubArray: " + maxSubArray(nums));
    }

    static void input3(){
        int nums[] = {5,4,-1,7,8};
        System.out.println("input3 maxSubArrayNonOptimized: " + maxSubArrayNonOptimized(nums));
        System.out.println("input3 maxSubArray: " + maxSubArray(nums));
    }


    static void input4(){
        int nums[] = {5,4,1,7,8};
        System.out.println("input4 maxSubArrayNonOptimized: " + maxSubArrayNonOptimized(nums));
        System.out.println("input4 maxSubArray: " + maxSubArray(nums));
    }


    static void input5(){
        int nums[] = {-5,-4,-1,-7,8};
        System.out.println("input5 maxSubArrayNonOptimized: " + maxSubArrayNonOptimized(nums));
        System.out.println("input5 maxSubArray: " + maxSubArray(nums));
    }

    // Using Kadane’s Algorithm – O(n) Time and O(1) Space
    static int maxSubArray(int nums[]){
        int maxSoFar = nums[0];
        int currentMax = nums[0];
        for(int i=1; i< nums.length; i++){
            currentMax = Math.max(currentMax, 0) + nums[i]; //Kadane's Algorithm
           // currentMax = Math.max(currentMax +  nums[i],  nums[i]) ;
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        return maxSoFar;
    }

    static int maxSubArray1(int nums[]){
        int maxSoFar = 0;
        int currentMax = 0;
        for(int i=0; i< nums.length; i++){
            currentMax = Math.max(currentMax, 0) + nums[i]; //Kadane's Algorithm
            // currentMax = Math.max(currentMax +  nums[i],  nums[i]) ;
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        return maxSoFar;
    }


    //O(n*n)
    static int maxSubArrayNonOptimized(int nums[]){

        int ans = -1000000;
        for(int i=0; i<nums.length; i++){
            int sum =0;
            for(int j =i; j< nums.length; j++){
                sum = sum + nums[j];
                ans = Math.max(ans, sum);
            }
        }
        return  ans;
    }
}
