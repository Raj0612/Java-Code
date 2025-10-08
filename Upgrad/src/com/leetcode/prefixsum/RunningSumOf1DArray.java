package com.leetcode.prefixsum;

import java.util.Arrays;

//Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
//Return the running sum of nums.
/*
Example 1:
Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

Example 2:
Input: nums = [1,1,1,1,1]
Output: [1,2,3,4,5]
Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].

Example 3:
Input: nums = [3,1,2,10,1]
Output: [3,4,6,16,17]
 */
public class RunningSumOf1DArray {
    public static void main(String[] args) {
        input1();
        input2();
    }

    static public int[] runningSum(int[] nums){
        int result[] = new int[nums.length];
        int curr_sum =0;
        if(nums.length==0)
            return result;

        for(int i=0; i< nums.length; i++){
            curr_sum = curr_sum + nums[i];
            result[i] = curr_sum;
        }
        return  result;
    }

    public static int[] runningSum1(int[] nums) {
        int[] res= new int[nums.length];
        if(nums.length==0)
            return res;
        res[0]=nums[0];
        for(int i=1;i<nums.length;i++)  {
            res[i]=res[i-1]+ nums[i];
        }
        return res;
    }

    //Time-O(n*n) Space-O(n)
    public static int[] runningSumNotOptimized(int[] nums) {
        int[] res= new int[nums.length];
        if(nums.length==0)
            return res;
        for(int i=0;i<nums.length;i++)  {
            int sum_till_ith_index = 0;
            for(int j=0;j<=i;j++)  {
                sum_till_ith_index += nums[j];
            }
            res[i] = sum_till_ith_index;
        }
        return res;
    }

    static void input1(){
        int nums[] = {1,2,3,4};
        System.out.println("input1: " + Arrays.toString(nums));
        System.out.println("input1 runningSumNotOptimized: " + Arrays.toString(runningSumNotOptimized(nums)));
        System.out.println("input1 runningSum: " + Arrays.toString(runningSum(nums)));
        System.out.println("input1 runningSum1: " + Arrays.toString(runningSum1(nums)));
    }
    static void input2(){
        int nums[] = {1,1,1,1,1};
        System.out.println("input2: " + Arrays.toString(nums));
        System.out.println("input2 runningSumNotOptimized: " + Arrays.toString(runningSumNotOptimized(nums)));
        System.out.println("input2 runningSum: " + Arrays.toString(runningSum(nums)));
        System.out.println("input2 runningSum1: " + Arrays.toString(runningSum1(nums)));
    }

}
