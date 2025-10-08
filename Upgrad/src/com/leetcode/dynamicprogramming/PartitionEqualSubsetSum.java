package com.leetcode.dynamicprogramming;

import java.util.Arrays;

//Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
/*
Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        input1();
        input2();
        input3();
        input4();
    }

    static void input1(){
        int[] arr = {1, 5, 11, 5};
        System.out.println("input1: canPartitionWODP " + canPartitionWODP(arr));
    }

    static void input2(){
        int[] arr = {1, 2, 3, 5};
        System.out.println("input2: canPartitionWODP " + canPartitionWODP(arr));
    }

    static void input3(){
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("input2: canPartitionWODP " + canPartitionWODP(arr));
    }

    static void input4(){
        int[] arr = {2, 4, 6, 10};
        System.out.println("input4: canPartitionWODP " + canPartitionWODP(arr));
    }

    public static boolean canPartitionWODP(int[] nums) {

        int totalSum = 0;
        for(int num: nums){
            totalSum += num;
        }

        if(totalSum % 2 ==1)
            return false;

        return subset_SumWODP(0, nums, totalSum/2);

    }

    static boolean subset_SumWODP(int i, int[] nums, int sum){
        if(sum ==0)
            return true;
        if(sum< 0 || i== nums.length)
            return false;

        boolean exclude = subset_SumWODP(i+1, nums, sum);
        boolean include = subset_SumWODP(i+1, nums, sum- nums[i]);
        return exclude || include;
    }

    public static boolean canPartitionDP(int[] nums) {

        int totalSum = 0;
        for(int num: nums){
            totalSum += num;
        }

        if(totalSum % 2 ==1)
            return false;

        int dp[][] = new int[nums.length+1][totalSum/2 + 1];

        for(int i=0; i<=nums.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return subset_SumDP(0, nums, totalSum/2, dp);

    }

    static boolean subset_SumDP(int i, int[] nums, int sum, int[][] dp){
        if(sum ==0)
            return true;
        if(sum< 0)
            return false;

        if(i== nums.length)
            return false;

        if(dp[i][sum] !=-1){
            if(dp[i][sum] == 1)
                return true;
            else return false;

        }
        boolean ans =  subset_SumDP(i+1, nums, sum, dp) || subset_SumDP(i+1, nums, sum- nums[i], dp);

        if(ans)
            dp[i][sum] = 1;
        else
            dp[i][sum] = 0;

        return ans;
    }
}
