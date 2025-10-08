package com.leetcode.dynamicprogramming;

import java.util.Arrays;

//You are given the weights and values of items, and you need to put these items in a knapsack of capacity to achieve the maximum total value in the knapsack.
// Each item is available in only one quantity.
//In other words, you are given two integer arrays val[] and wt[], which represent the values and weights associated with items, respectively.
// You are also given an integer capacity, which represents the knapsack capacity.
// Your task is to find the maximum sum of values of a subset of val[] such that the sum of the weights of the corresponding subset is less than or equal to capacity.
// You cannot break an item; you must either pick the entire item or leave it (0-1 property).
/*
Example1:
Input: capacity = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1]
Output: 3
Explanation: Choose the last item, which weighs 1 unit and has a value of 3.

Example2:
Input: capacity = 3, val[] = [1, 2, 3], wt[] = [4, 5, 6]
Output: 0
Explanation: Every item has a weight exceeding the knapsack's capacity (3).

Example3:
Input: capacity = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 6, 3]
Output: 50
Explanation: Choose the second item (value 40, weight 4) and the fourth item (value 50, weight 3) for a total weight of 7, which exceeds the capacity.
Instead, pick the last item (value 50, weight 3) for a total value of 50.
 */
public class ZeroOneKnapsack {

    public static void main(String[] args) {
        input1();
        input2();
        input3();
        input4();

    }

    static void input1(){
        int W = 4;
        int val[] = {1, 2, 3};
        int wt[] = {4, 5, 1};
        System.out.println("input1: knapsackByRecursion " + knapsackByRecursion(W, val, wt));
    }

    static void input2(){
        int W = 4;
        int val[] = {1, 2, 3};
        int wt[] = {4, 5, 6};
        System.out.println("input2: knapsackByRecursion " + knapsackByRecursion(W, val, wt));
    }

    static void input3(){
        int capacity = 5;
        int val[] = {10, 40, 30, 50};
        int wt[] = {5, 4, 6 , 3};
        System.out.println("input3: knapsackByRecursion " + knapsackByRecursion(capacity, val, wt));
    }

    static void input4(){
        int W = 3;
        int val[] = {1, 2, 3};
        int wt[] = {4, 5, 6};
        System.out.println("input3: knapsackByRecursion " + knapsackByRecursion(W, val, wt));
    }

    static int knapsackByRecursion(int capacity, int[] val, int[] wt){

       int result = knapsackByRecursion(capacity, wt, val, val.length);
       return result;
    }

    static int knapsackByRecursion(int W, int[] wt, int[] val, int n){
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        if (wt[n - 1] > W)
            return knapsackByRecursion(W, wt, val, n - 1);
        else
            return Math.max(knapsackByRecursion(W, wt, val, n - 1),
                    val[n - 1] + knapsackByRecursion(W - wt[n-1], wt, val, n-1));
    }

    static int knapsackByMemoziation(int W, int[] wt, int[] val) {
        int n = wt.length;
        int[][] memo = new int[n][W + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return knapsackByMemoziation(W, wt, val, n - 1, memo);
    }

    public static int knapsackByMemoziation(int W, int[] wt, int[] val, int index, int[][] memo) {

        // Base condition
        if (index < 0)
            return 0;

        if (memo[index][W] != -1)
            return memo[index][W];

        // Store the value in the table before return
        if (wt[index] > W) {
            memo[index][W] = knapsackByMemoziation(W, wt, val, index - 1, memo);
        } else {
            memo[index][W] = Math.max(val[index] + knapsackByMemoziation(W - wt[index], wt, val, index - 1, memo),
                    knapsackByMemoziation(W, wt, val, index - 1, memo));
        }

        return memo[index][W];
    }


    public static int knapTabulation(int W, int[] wt, int[] val) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        // Build table dp[][] in bottom-up manner
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



