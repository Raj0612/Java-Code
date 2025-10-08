package com.leetcode.dynamicprogramming;

import java.util.Arrays;

//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
//Note: You can only move either down or right at any point in time.
/*
Example 1s:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:
Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        input1();
    }
    static void input1(){
        int [][] grid ={{1,3,1},{1,5,1},{4,2,1}};
      //  System.out.println("input1: minPathSumWODP " + minPathSumWODP(grid));
        System.out.println("input1: minPathSumDP " + minPathSumDP(grid));
        System.out.println("input1: minPathSumDPTabulation " + minPathSumDPTabulation(grid));
    }

    public static int minPathSumWODP(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result;
        result = minPathSumWODPRightDown(0, 0, grid, m, n);
   //     result = minPathSumWODPLeftUP(m-1, n-1, grid, m, n);
        return result;
    }

    public static int minPathSumWODPRightDown(int i, int j,int[][] grid, int m , int n) {
        if(i == m-1 && j == n-1)
            return grid[i][j];

        if(i>=m || j >=n)
            return Integer.MAX_VALUE;

        int right = minPathSumWODPRightDown(i, j+1, grid, m, n);
        int down = minPathSumWODPRightDown(i+1, j, grid, m , n);

        return grid[i][j] + Math.min(right, down);
    }

    public static int minPathSumWODPLeftUP(int i, int j,int[][] grid, int m , int n) {
        if(i == 0 && j == 0)
            return grid[i][j];

        if(i <0 || j <0)
            return Integer.MAX_VALUE;

        int left = minPathSumWODPLeftUP(i, j-1, grid, m, n);
        int up = minPathSumWODPLeftUP(i-1, j, grid, m , n);

        return grid[i][j] + Math.min(left, up);
    }

    public static int minPathSumDP(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for(int i=0; i< m; i++){
            Arrays.fill(dp[i], -1);
        }
        return minPathSumDP(0, 0, grid, m, n, dp);
    }

    public static int minPathSumDP(int i, int j,int[][] grid, int m , int n, int[][] dp) {
        if(i == m-1 && j == n-1)
            return grid[i][j];

        if(i>=m || j >=n)
            return Integer.MAX_VALUE;

        if(dp[i][j] !=-1)
            return dp[i][j];

        int right = minPathSumDP(i, j+1, grid, m, n, dp);
        int down = minPathSumDP(i+1, j, grid, m , n, dp);

        dp[i][j] = grid[i][j] + Math.min(right, down);
        return dp[i][j];
    }

    public static int minPathSumDPTabulation(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m][n];

        dp[0][0] = grid[0][0];

        for(int i=1; i< m; i++){
           dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for(int j=1; j< n; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for(int i =1; i<m; i++){
            for(int j= 1;j<n;j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[m-1][n-1];
    }
}
