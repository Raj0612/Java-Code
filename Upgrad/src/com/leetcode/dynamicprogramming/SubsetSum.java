package com.leetcode.dynamicprogramming;

import java.util.Arrays;

//Given an array arr[] of non-negative integers and a value sum, the task is to check if there is a subset of the given array whose sum is equal to the given sum.
/*
Examples:
Input: arr[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True
Explanation: There is a subset (4, 5) with sum 9.

Input: arr[] = {3, 34, 4, 12, 5, 2}, sum = 30
Output: False
Explanation: There is no subset that add up to 30.
 */
public class SubsetSum {

    public static void main(String[] args) {
       // input1();
      //  input2();
       // input3();
        input4();
    }

    static void input1(){
        int arr[] = {34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println("input1: isSubsetSumWODP " + isSubsetSumWODP(arr.length, arr, sum));
        System.out.println("input1: isSubsetSumDP " + isSubsetSumDP(arr.length, arr, sum));
    }

    static void input2(){
        int arr[] = {3, 34, 4, 12, 5, 2};
        int sum = 30;
        System.out.println("input2: isSubsetSumWODP " + isSubsetSumWODP(arr.length, arr, sum));
        System.out.println("input2: isSubsetSumDP " + isSubsetSumDP(arr.length, arr, sum));
    }

    static void input3(){
        int arr[] = {5, 7, 1, 10};
        int sum = 17;
        System.out.println("input3: isSubsetSumWODP " + isSubsetSumWODP(arr.length, arr, sum));
        System.out.println("input3: isSubsetSumDP " + isSubsetSumDP(arr.length, arr, sum));
    }

    static void input4(){
        int arr[] = {4, 12, 5, 4};
        int sum = 9;
        System.out.println("input4: isSubsetSumWODP " + isSubsetSumWODP(arr.length, arr, sum));
        System.out.println("input4: isSubsetSumDP " + isSubsetSumDP(arr.length, arr, sum));
    }

    public static boolean isSubsetSumWODP(int n, int arr[], int sum){
        return isSubsetSumWODP(0, n, arr, sum);
    }

    public static boolean isSubsetSumWODP(int i, int n, int arr[], int sum){
        if(sum==0)
            return true;

        if(sum < 0 || i == n)
            return false;

        boolean exclude = isSubsetSumWODP(i+1, n, arr, sum);
        boolean include = isSubsetSumWODP(i+1, n, arr, sum-arr[i]);
        return exclude || include;
    }

    public static boolean isSubsetSumDP(int n, int arr[], int sum){

        int dp[][] = new int[n+1][sum+1];

        for(int i=0; i< n; i++){
            Arrays.fill(dp[i], -1);
        }
        return isSubsetSumDP(0, n, arr, sum, dp);
    }

    public static boolean isSubsetSumDP(int i, int n, int arr[], int sum, int[][] dp){

        if(sum==0)
            return true;

        if(sum < 0 || i == n){
            return false;
        }

        if(dp[i][sum]!=-1){
            if(dp[i][sum] == 1)
                return true;
            else
                return false;
        }
        boolean exclude = isSubsetSumDP(i+1, n, arr, sum, dp);
        boolean include = isSubsetSumDP(i+1, n, arr, sum-arr[i], dp);

        boolean ans = exclude || include;

        if(ans)
            dp[i][sum] = 1;
        else
            dp[i][sum] = 0;
        return ans;
    }
}
