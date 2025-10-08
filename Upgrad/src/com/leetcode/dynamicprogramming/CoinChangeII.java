package com.leetcode.dynamicprogramming;

import java.util.Arrays;

//You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
//Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
//You may assume that you have an infinite number of each kind of coin. The answer is guaranteed to fit into a signed 32-bit integer.
/*
Example 1:
Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

Example 2:
Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.

Example 3:
Input: amount = 10, coins = [10]
Output: 1
 */
public class CoinChangeII {

    static int count =0;
    public static void main(String[] args) {
        input1();
        input2();
    }

    static void input1(){
        count = 0;
       int[] coins = {1,2,5};
       int amount = 5;
       System.out.println("input1: changeGlobalCounter " + changeGlobalCounter(amount, coins));
       System.out.println("input1: changeWODP " + changeWODP(amount, coins));
        System.out.println("input1: changeDP " + changeDP(amount, coins));
    }

    static void input2(){
        count = 0;
        int[] coins = {2};
        int amount = 3;
        System.out.println("input2: changeGlobalCounter " + changeGlobalCounter(amount, coins));
        System.out.println("input2: changeWODP " + changeWODP(amount, coins));
        System.out.println("input2: changeDP " + changeDP(amount, coins));
    }

    public static int changeGlobalCounter(int amount, int[] coins) {

        changeGlobalCounter(0, amount, coins);
        return count;
    }

    public static void changeGlobalCounter(int i, int sum, int[] coins) {

        if(sum == 0) {
            count++;
            return;
        }

        if(i == coins.length)
            return ;

        if(coins[i] > sum) {
            changeGlobalCounter(i + 1, sum, coins);
            return;
        }
        changeGlobalCounter(i+1, sum, coins); //Not Pick
        changeGlobalCounter(i, sum-coins[i], coins); // Pick the coin

    }


    public static int changeWODP(int amount, int[] coins) {
        return changeWODP(0, amount, coins);
    }

    public static int changeWODP(int i, int sum, int[] coins) {
        if(sum == 0) {
           return 1;
        }

        if(i == coins.length)
            return 0 ;

        if(coins[i] > sum) {
            return changeWODP(i + 1, sum, coins);
        }

        int notPick =  changeWODP(i+1, sum, coins); //Not Pick
        int pick = changeWODP(i, sum-coins[i], coins); // Pick the coin

        return notPick + pick;
    }

    public static int changeDP(int amount, int[] coins) {

        int dp[][] = new int[coins.length+1][amount+1];
        for(int i=0; i<= coins.length; i++){
            Arrays.fill(dp[i], -1 );
        }
        return changeDP(0, amount, coins, dp);
    }

    public static int changeDP(int i, int sum, int[] coins, int[][] dp) {
        if(sum == 0) {
            return 1;
        }

        if(i == coins.length)
            return 0 ;

        if(coins[i] > sum) {
            dp[i][sum] = changeWODP(i + 1, sum, coins);
        }

        if(dp[i][sum] !=-1){
            return dp[i][sum];
        }

        int notPick =  changeWODP(i+1, sum, coins); //Not Pick
        int pick = changeWODP(i, sum-coins[i], coins); // Pick the coin

        dp[i][sum] = notPick + pick;
        return dp[i][sum];
    }
}
