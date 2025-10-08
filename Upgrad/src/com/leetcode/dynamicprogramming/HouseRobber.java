package com.leetcode.dynamicprogramming;

/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,the only constraint
  stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police
  if two adjacent houses were broken into on the same night.*/

//Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
/*
Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 */
import java.util.Arrays;

public class HouseRobber {

    public static void main(String[] args) {
       //input1();
        System.out.println();
       // input2();
        System.out.println();
      //  input3();
        System.out.println();
      //  input4();
        System.out.println();
         input7();
    }

    public static int robWithoutDP(int[] nums) {
        return robWithoutDP(0,nums);
    }

    public static int robWithoutDP(int i, int[] nums) {
        if(i>=nums.length)
            return 0;

        int pick = robWithoutDP(i+2, nums) +  nums[i];
     //   System.out.println("robWithoutDP pick: " + pick+ " i: " + i);
        int noPick = robWithoutDP(i+1, nums);
      //  System.out.println("robWithoutDP noPick: " + noPick + " i: " + i);

        return Math.max(pick, noPick);
    }

    public static int robByTabulation(int[] nums) {
        if(nums.length <2) return nums[0];

        int dp[] = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i=2;i<nums.length;i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        System.out.println("rob arr " + Arrays.toString(dp));
        return dp[nums.length-1];
    }

    public static int robByDPMemoizationBackwards(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n+1];
        Arrays.fill(arr, -1);
        return robByDPMemoizationBackwards(n-1,nums, arr);
    }

    public static int robByDPMemoizationBackwards(int i, int[] nums, int[] arr) {
        if(i==0) return nums[0];
        if(i<0) return 0;

        if(arr[i]!=-1)
            return arr[i];

        int pick = nums[i] + robByDPMemoizationBackwards(i-2,nums,arr);
        int noPick = robByDPMemoizationBackwards(i-1,nums,arr);
        return arr[i] = Math.max(pick,noPick);
    }

    public static int robByDPMemoizationUpgrad(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];
        Arrays.fill(arr, -1);
        int result = robByDPMemoizationUpgrad(0,nums, arr);
        System.out.println("robByDPMemoizationUpgrad " + Arrays.toString(arr));
        return result;
    }

    public static int robByDPMemoizationUpgrad(int i, int[] nums, int[] arr) {
        if (i >= nums.length)
            return 0;

        if (arr[i] != -1) {
            System.out.println("robByDPMemoizationUpgrad " + Arrays.toString(arr)   + " i: " + i);
            return arr[i];
        }

        int pick = nums[i] + robByDPMemoizationUpgrad(i + 2, nums, arr);
      //  System.out.println("robByDPMemoizationUpgrad pick: " + pick + " i: " + i);
        int noPick = robByDPMemoizationUpgrad(i + 1, nums, arr);
     //   System.out.println("robByDPMemoizationUpgrad pick: " + pick + " noPick: " + noPick + " i: " + i);
        //arr[i] = Math.max(robByDPMemoization1(i+2,nums,arr) + nums[i] ,robByDPMemoization1(i+1,nums,arr));
        //return arr[i];
        //System.out.println("robByDPMemoizationUpgrad arr " + Arrays.toString(arr));
        return arr[i] = Math.max(pick, noPick);
    }

    public static int robWORecursion(int[] nums) {
        int prevNoRob = 0;
        int prevRob = 0;
        for (int currentHouseValue : nums) {
            int tempPrevNoRob = Math.max(prevNoRob, prevRob);
            prevRob = prevNoRob + currentHouseValue;
            prevNoRob = tempPrevNoRob;
        }
        return Math.max(prevNoRob, prevRob);
    }

    static void input1(){
        int[] nums = {1,7,9,5,1,3,4};
        System.out.println("input1  " + Arrays.toString(nums));
        System.out.println("input1 robWithoutDP " + robWithoutDP(nums));
        System.out.println("input1 robByTabulation " + robByTabulation(nums));
        System.out.println("input1 robByDPMemoizationBackwards " + robByDPMemoizationBackwards(nums));
        System.out.println("input1 robByDPMemoizationUpgrad " + robByDPMemoizationUpgrad(nums));
    }

    static void input2(){
        int[] nums = {1,2,3,1};
        System.out.println("input2  " + Arrays.toString(nums));
        System.out.println("input2 robWithoutDP " + robWithoutDP(nums));
        System.out.println("input2 robByTabulation " + robByTabulation(nums));
        System.out.println("input2 robByDPMemoizationBackwards " + robByDPMemoizationBackwards(nums));
        System.out.println("input2 robByDPMemoizationUpgrad " + robByDPMemoizationUpgrad(nums));
    }

    static void input3(){
        int[] nums = {2,7,9,3,1};
        System.out.println("input3 " + Arrays.toString(nums));
        System.out.println("input3 robWithoutDP " + robWithoutDP(nums));
        System.out.println("input3 robByTabulation " + robByTabulation(nums));
        System.out.println("input3 robByDPMemoizationBackwards " + robByDPMemoizationBackwards(nums));
        System.out.println("input3 robByDPMemoizationUpgrad " + robByDPMemoizationUpgrad(nums));
    }


    static void input4(){
        int[] nums = {10,3,5,20};
        System.out.println("input4  " + Arrays.toString(nums));
        System.out.println("input4 robWithoutDP " + robWithoutDP(nums));
        System.out.println("input4 robByTabulation " + robByTabulation(nums));
        //System.out.println("input4 robByDPMemoizationBackwards " + robByDPMemoizationBackwards(nums));
      //  System.out.println("input4 robByDPMemoizationUpgrad " + robByDPMemoizationUpgrad(nums));
        //System.out.println("input5 robWORecursion " + robWORecursion(nums));
    }

    static void input5(){
        int[] nums = {5,7};
        System.out.println("input5  " + Arrays.toString(nums));
        System.out.println("input5 robWithoutDP " + robWithoutDP(nums));
        //System.out.println("input5 robByTabulation " + robByTabulation(nums));
        //System.out.println("input5 robByDPMemoizationBackwards " + robByDPMemoizationBackwards(nums));
        //  System.out.println("input5 robByDPMemoizationUpgrad " + robByDPMemoizationUpgrad(nums));
        System.out.println("input5 robWORecursion " + robWORecursion(nums));
    }

    static void input6(){
        int[] nums = {2,10, 3};
        System.out.println("input6  " + Arrays.toString(nums));
        System.out.println("input6 robWithoutDP " + robWithoutDP(nums));
        //System.out.println("input6 robByTabulation " + robByTabulation(nums));
        //System.out.println("input6 robByDPMemoizationBackwards " + robByDPMemoizationBackwards(nums));
        //  System.out.println("input6 robByDPMemoizationUpgrad " + robByDPMemoizationUpgrad(nums));
       // System.out.println("input6 robWORecursion " + robWORecursion(nums));
    }

    static void input7(){
      //  int[] nums = {100, 5, 8, 9, 11, 12, 200};
        int[] nums = {100, 5, 8, 9, 50};
        System.out.println("input7  " + Arrays.toString(nums));
        System.out.println("input7 robWithoutDP " + robWithoutDP(nums));
        System.out.println("input5 robByTabulation " + robByTabulation(nums));
        //System.out.println("input5 robByDPMemoizationBackwards " + robByDPMemoizationBackwards(nums));
         System.out.println("input5 robByDPMemoizationUpgrad " + robByDPMemoizationUpgrad(nums));
       // System.out.println("input6 robWORecursion " + robWORecursion(nums));
    }

}
