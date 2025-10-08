package com.leetcode.dynamicprogramming;

import java.util.Arrays;

//You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
//Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1
//You may assume that you have an infinite number of each kind of coin.
/*
Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0
 */
public class CoinChange {

    public static void main(String[] args) {
        input1();
        input2();
        input3();
    }

    public static int coinChangeUpgrad(int sum, int[] coins){
        if(sum ==0){
            return 0;
        }

        int result = Integer.MAX_VALUE;
        boolean is_solution = false;

        for(int i=0; i< coins.length; i++){
            if(coins[i] <= sum){
                int count = coinChangeUpgrad(sum -coins[i], coins);

                if(count != -1 &&(count+1 < result)){
                    result = count+1;
                    is_solution = true;
                }

            }
        }
        if(is_solution == false)
            return -1;
        else
            return result;
    }
    public static int coinChangeUpgrad1(int[] coins, int amount){
        int result = coinChangeUpgrad1Recursion(amount, coins);
        if(result == Integer.MAX_VALUE)
            return -1;
        else
            return result;
    }

    public static int coinChangeUpgrad1Recursion(int sum, int[] coins){
        if(sum ==0){
            return 0;
        }

        int result = Integer.MAX_VALUE;

        for(int i=0; i< coins.length; i++){
            if(coins[i] <= sum){
                result = Math.min(result, 1+ coinChangeUpgrad1Recursion(sum - coins[i], coins));
            }
        }
        return result;
    }

    public static int coinChangeUpgradDP(int[] coins, int amount){

        int dp[] = new int[amount+1];
        Arrays.fill(dp, -1);
        int result = coinChangeUpgradDP(amount, coins, dp);
        if(result == Integer.MAX_VALUE)
            return -1;
        else
            return result;
    }

    public static int coinChangeUpgradDP( int sum, int[] coins, int[] dp){

        if(sum ==0){
            return 0;
        }

        if(dp[sum] != -1){
            return dp[sum];
        }
        int result = Integer.MAX_VALUE;

        for(int i=0; i< coins.length; i++){
            if(coins[i] <= sum){
                result = Math.min(result, 1+ coinChangeUpgradDP(sum - coins[i], coins, dp));
            }
        }
        dp[sum] =  result;

        return dp[sum];
    }


    public static int coinChangeUpgrad(int[] coins, int amount){
        return coinChangeUpgrad(amount, coins);
    }

    static void input1(){
        int[] coins = {1,2,5};
        int amount = 6;
        System.out.println("input1 coinChangeUpgrad " + coinChangeUpgrad(coins, amount));
        System.out.println("input1 coinChangeUpgrad1 " + coinChangeUpgrad1(coins, amount));
    }

    static void input2(){
        int[] coins = {2};
        int amount = 3;
        System.out.println("input2 coinChangeUpgrad " + coinChangeUpgrad(coins, amount));
        System.out.println("input2 coinChangeUpgrad1 " + coinChangeUpgrad1(coins, amount));
    }

    static void input3(){
        int[] coins = {1};
        int amount = 0;
        System.out.println("input3 coinChangeUpgrad " + coinChangeUpgrad(coins, amount));
        System.out.println("input3 coinChangeUpgrad1 " + coinChangeUpgrad1(coins, amount));
    }
}
