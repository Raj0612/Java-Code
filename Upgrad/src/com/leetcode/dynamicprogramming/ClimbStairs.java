package com.leetcode.dynamicprogramming;

//You are climbing a staircase. It takes n steps to reach the top.
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
public class ClimbStairs {
    int[] cache = new int[46];

    public static void main(String[] args) {
        input1();
    }

    //Brute-Force Approach
    //Time complexity: O(2^n) - since size of recursion tree will be 2^n
    //Space Complexity: O(n) - space required for the recursive function call stack.
    public static int climbStairsRecursion(int n) {
        if(n <= 2)
            return n;
        else
            return climbStairsRecursion(n - 1) + climbStairsRecursion(n - 2);
    }

    //Time: complexity: O(n)
    //Space: Complexity: O(n)
    public int climbStairsTopDownByDP(int n) {
        if(n <= 2)
            return n;
        else if(cache[n] != 0)
            return cache[n];
        else
            return cache[n] = climbStairsTopDownByDP(n - 1) + climbStairsTopDownByDP(n - 2);
    }

    public int climbStairsBottomUpByDP(int n) {
        if(n <= 2)
            return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++)  {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //Time complexity: O(n)
    //Space Complexity: O(1)
    public int climbStairsByFibonacci(int n) {
        if(n <= 2)
            return n;

        int a = 1;
        int b = 2;

        for(int i = 3; i <= n; i++)  {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    static void input1(){
        int n  = 2;
        System.out.println("input1 climbStairsRecursion " +  climbStairsRecursion(n));
    }
}
