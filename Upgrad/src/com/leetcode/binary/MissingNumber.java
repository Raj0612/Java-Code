package com.leetcode.binary;

//Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

import java.util.Arrays;

/*
Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 */
public class MissingNumber {

    public static void main(String[] args) {
        input1();
        input2();
    }

    public static int missingNumber(int[] nums) {
        int ans = nums.length;
        for(int i=0;i<nums.length;i++){
            ans ^= i ^ nums[i];
        }
        return ans;
    }

    public static int missingNumberNonOptimized(int[] nums) {
        int arrLen = nums.length;
        int sum =0;
        int total = (arrLen *(arrLen+1))/2;
        for(int i=0;i<nums.length;i++){
            sum += nums[i] ;
        }
        return total - sum;
    }
    public static int missingNumberNonOptimized1(int[] nums) {
        int sum = nums.length;
        int total = 0;
        for(int i=0;i<nums.length;i++){
            sum += i;
            total += nums[i] ;
        }
        return sum - total;
    }
    static void input1(){
        int[] nums = {3,0,1};
        System.out.println("input1  " + Arrays.toString(nums));
        System.out.println("input1 missingNumber " + missingNumber(nums));
        System.out.println("input1 missingNumberNonOptimized " + missingNumberNonOptimized(nums));
    }

    static void input2(){
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println();
        System.out.println("input2  " + Arrays.toString(nums));
        System.out.println("input2 missingNumber " + missingNumber(nums));
        System.out.println("input2 missingNumberNonOptimized " + missingNumberNonOptimized(nums));
    }
}
