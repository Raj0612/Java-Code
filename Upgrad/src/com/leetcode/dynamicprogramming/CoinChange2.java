package com.leetcode.dynamicprogramming;

import java.util.Arrays;

//You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
//Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
//You may assume that you have an infinite number of each kind of coin.
//The answer is guaranteed to fit into a signed 32-bit integer.
public class CoinChange2 {
   static int count =0;
    public static void main(String[] args) {
        input1();
    }

    //Time - The time complexity of the above code is O(N*amount) since, for each coin, we are iterating for the amount number of times.
    //Space - The space complexity of the above code is O(amount)since we’re creating a linear dynamic programming array of size amount.
    static int change(int amount, int coins[]){
        int dp[] = new int[amount+1];
        for(int i=0;i<=amount;i++){
            dp[i] = 0;
        }
        System.out.println("change dp " + Arrays.toString(dp));
        dp[0] = 1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j] += dp[j-coins[i]];
            }
        }
        System.out.println("change dp final " + Arrays.toString(dp));
        return dp[amount];
    }

    static int changeByRecursion(int amount, int coins[]){

       changeByRecursion(0,amount,coins);
       return count;
    }

    static void changeByRecursion(int i, int amount, int coins[]){
        if(amount==0) {
            count++;
            return;
        }

        if(i==coins.length)
            return;

        if(coins[i]>amount){
            changeByRecursion(i+1, amount, coins); // not pick
            return;
        }

        changeByRecursion(i+1, amount, coins);//not pick
        changeByRecursion(i, amount-coins[i],coins); // pick

    }
    static int changeByRecursion1(int amount, int coins[]){
       return changeByRecursion1(0,amount,coins);
    }
    static int changeByRecursion1(int i, int amount, int coins[]){
        if(amount ==0)
            return 1;

        if(i == coins.length)
            return 0;
        if(coins[i] > amount){
            return changeByRecursion1(i+1, amount, coins); // Not Pick
        }

        return changeByRecursion1(i+1, amount, coins) +  changeByRecursion1(i, amount - coins[i], coins);
    }

    static int changeByDPMemoization(int amount, int coins[]){
        int dp[][] = new int[coins.length+1][amount+1];

       // Arrays.fill(dp, -1);
        return changeByDPMemoization(0,amount,coins, dp);
    }

    static int changeByDPMemoization(int i, int amount, int coins[], int dp[][]){
        if(amount ==0)
            return 1;

        if(i == coins.length)
            return 0;

        if(dp[i][amount]!=-1)
            return dp[i][amount];

        if(coins[i] > amount){
            dp[i][amount] = changeByDPMemoization(i+1, amount, coins, dp);
            return dp[i][amount];
        }
        dp[i][amount] = changeByDPMemoization(i+1, amount, coins, dp) +   changeByDPMemoization(i, amount-coins[i], coins, dp);
        return dp[i][amount];
    }
    static void input1(){
        int amount =5;
        int coins[] = {1,2,5};
        System.out.println("input1 change " + change(amount, coins));
        System.out.println("input1 changeByRecursion " + changeByRecursion(amount, coins));
        System.out.println("input1 changeByRecursion1 " + changeByRecursion1(amount, coins));
        System.out.println("input1 changeByDPMemoization " + changeByDPMemoization(amount, coins));
    }
}
