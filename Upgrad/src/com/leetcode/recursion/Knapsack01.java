package com.leetcode.recursion;

public class Knapsack01 {
    public static void main(String args[]){
        input1();
        input2();
    }
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }
    static int knapSackGeekForGeeks(int W, int wt[], int val[], int n){
        if (n == 0 || W == 0)
            return 0;
        if (wt[n - 1] > W)
            return knapSackGeekForGeeks(W, wt, val, n - 1);
        else
            return max(val[n - 1]
                            + knapSackGeekForGeeks(W - wt[n - 1], wt,
                            val, n - 1),
                    knapSackGeekForGeeks(W, wt, val, n - 1));
    }

    static void input1(){
        int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = profit.length;
        System.out.println(knapSackGeekForGeeks(W, weight, profit, n));
    }

    static void input2(){
        int profit[] = new int[] { 1, 2, 3 };
        int weight[] = new int[] { 4, 5, 1 };
        int W = 4;
        int n = profit.length;
        System.out.println(knapSackGeekForGeeks(W, weight, profit, n));
    }
}
