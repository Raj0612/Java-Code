package com.geekforgeeks;

import java.util.Arrays;

//Given n items where each item has some weight and profit associated with it and also given a bag with capacity W, [i.e., the bag can hold at most W weight in it].
// The task is to put the items into the bag such that the sum of profits associated with them is the maximum possible.
public class ZeroKnapsack {

    public static void main(String[] args) {
        input1();
    }

    static int knapsackRec(int W, int[] val, int[] wt, int n) {
        if (n == 0 || W == 0)
            return 0;

        int pick = 0;
        if (wt[n - 1] <= W)
            pick = val[n - 1] + knapsackRec(W - wt[n - 1], val, wt, n - 1);

        int notPick = knapsackRec(W, val, wt, n - 1);
        return Math.max(pick, notPick);
    }

    static int knapsackTabulation(int W, int[] val, int[] wt, int n) {
        int[][] dp = new int[n + 1][W + 1];
        System.out.println("knapsackTabulation dp " + Arrays.deepToString( dp));
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    int pick = 0;
                    if (wt[i - 1] <= j)
                        pick = val[i - 1] + dp[i - 1][j - wt[i - 1]];
                    int notPick = dp[i - 1][j];

                    dp[i][j] = Math.max(pick, notPick);
                }

            }
        }
        System.out.println("knapsackTabulation dp Final " + Arrays.deepToString( dp));
        return dp[n][W];
    }


    static void  input1(){
        int N = 3;
        int W = 4;
        int profit[] = {1, 2, 3};
        int weight[] = {4, 5, 1};

        System.out.println("knapsackRec " + knapsackRec(W, profit, weight, N));
        System.out.println("knapsackTabulation " + knapsackTabulation(W, profit, weight, N));
    }
}