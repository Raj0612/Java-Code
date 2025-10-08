package com.leetcode.dynamicprogramming;
//Given N items where each item has some weight and profit associated with it and also given a bag with capacity W, [i.e., the bag can hold at most W weight in it].
// The task is to put the items into the bag such that the sum of profits associated with them is the maximum possible.
//Note: The constraint here is we can either put an item completely into the bag or cannot put it at all [It is not possible to put a part of an item into the bag].
/*
Input: N = 3, W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1}
Output: 3
Explanation: There are two items which have weight less than or equal to 4. If we select the item with weight 4, the possible profit is 1. And if we select the item with weight 1, the possible profit is 3. So the maximum possible profit is 3. Note that we cannot put both the items with weight 4 and 1 together as the capacity of the bag is 4.

Input: N = 3, W = 3, profit[] = {1, 2, 3}, weight[] = {4, 5, 6}
Output: 0
 */
public class ZeroOneKnapSackII {
    public static void main(String[] args) {
        input1();
        input2();
    }

    static void input1(){
        int N = 3;
        int W = 50;
        int profit[] = {60, 100, 120};
        int weight[] = {10, 20, 30 };
        System.out.println("input1: knapsack " + knapsack(W, weight, profit, N));
    }
    static void input2(){
        int N = 3;
        int W = 3;
        int profit[] = {1, 2, 3};
        int weight[] = {4, 5, 6};
        System.out.println("input2: knapsack " + knapsack(W, weight, profit, N));
    }


    static int knapsack(int W, int wt[], int val[], int n){
        if (n == 0 || W == 0)
            return 0;

        if (wt[n - 1] > W)
            return knapsack(W, wt, val, n - 1);
        else{
           int notPick = knapsack(W, wt, val, n - 1);
           int pick = val[n - 1] + knapsack(W - wt[n-1], wt, val, n-1);

           return Math.max(notPick, pick);
          //  return Math.max(knapsack(W, wt, val, n - 1),
//                    val[n - 1] + knapsack(W - wt[n-1], wt, val, n-1));
        }
//
    }

    static int knapsackDP(int W, int wt[], int val[], int index, int[][] dp){
        if (index < 0)
            return 0;

        if (dp[index][W] != -1)
            return dp[index][W];

        if (wt[index] > W) {
            dp[index][W] = knapsackDP(W, wt, val, index - 1, dp);
        } else {
            dp[index][W] = Math.max(val[index] + knapsackDP(W - wt[index], wt, val, index - 1, dp),
                    knapsackDP(W, wt, val, index - 1, dp));
        }

        return dp[index][W];
    }

    public static int knapSackTabulation(int W, int[] wt, int[] val) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        return dp[n][W];
    }
}
