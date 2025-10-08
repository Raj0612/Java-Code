package com.leetcode.dynamicprogramming;

import java.util.Arrays;

//There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
// The robot can only move either down or right at any point in time.
//Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
//The test cases are generated so that the answer will be less than or equal to 2 * 109.
/*
Example1:
Input: m = 3, n = 7
Output: 28

Example 2:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 */
public class UniquePaths {

    static int count =0;
    public static void main(String[] args) {
        input1();
        input2();
    }

    static void input1(){
        int m = 3;
        int n = 3;
      //  System.out.println("input1: uniQuePathsWoDPRightDown " + uniQuePathsWoDPRightDown(m, n));
        System.out.println("input1: uniQuePathsWoDPRightDown1 " + uniQuePathsWoDPRightDown1(m, n));
        System.out.println("input1: uniQuePathsDPRightDown " + uniQuePathsDPRightDown(m, n));
      //  System.out.println("input1: uniQuePathsWoDPLeftUp " + uniQuePathsWoDPLeftUp(m, n));
      //  System.out.println("input1: uniQuePathsWoDPLeftUp1 " + uniQuePathsWoDPLeftUp1(m, n));
        System.out.println("input1: uniQuePathDPMemoLeftUp " + uniQuePathDPMemoLeftUp(m, n));
        System.out.println("input1: uniQuePathDPMemoRightDown " + uniQuePathDPMemoRightDown(m, n));

    }

    static void input2(){
        int m = 3;
        int n = 7;
        System.out.println("input2: uniQuePathsDPRightDown " + uniQuePathsDPRightDown(m, n));
       // System.out.println("input2: uniQuePathsWoDPRightDown " + uniQuePathsWoDPRightDown(m, n));
       // System.out.println("input2: uniQuePathsWoDPRightDown1 " + uniQuePathsWoDPRightDown1(m, n));
       // System.out.println("input2: uniQuePathsWoDPLeftUp " + uniQuePathsWoDPLeftUp(m, n));
      //  System.out.println("input2: uniQuePathsWoDPLeftUp1 " + uniQuePathsWoDPLeftUp1(m, n));
        System.out.println("input2: uniQuePathDPMemoLeftUp " + uniQuePathDPMemoLeftUp(m, n));
        System.out.println("input2: uniQuePathDPMemoRightDown " + uniQuePathDPMemoRightDown(m, n));
    }

    public static int uniQuePathsWoDPRightDown(int m, int n){
        count = 0;
        uniQuePathsWoDPRightDown(0, 0, m, n);
        return count;
    }

    public static int uniQuePathsWoDPRightDown1(int m, int n){
        return uniQuePathsWoDPRightDown1(0, 0, m, n, 0);
    }

    public static int uniQuePathsDPRightDown(int m, int n){
        int[][]  dp= new int[m][n];
        for(int i=0; i< m; i++){
            Arrays.fill(dp[i], -1);
        }
        return  uniQuePathsDPRightDown(0, 0, m, n, dp);
    }

    public static  void uniQuePathsWoDPRightDown(int i, int j, int m, int n){
        if(i == m-1 && j == n-1)
            count++;

        if(i>=m || j>=n)
            return;
        uniQuePathsWoDPRightDown(i, j+1, m, n);
        uniQuePathsWoDPRightDown(i+1, j, m, n);
    }

    public static  int uniQuePathsWoDPRightDown1(int i, int j, int m, int n, int sum){
        if(i == m-1 && j == n-1)
            return 1;

        if(i>=m || j>=n)
            return 0;
        int right = uniQuePathsWoDPRightDown1(i, j+1, m, n, sum);
        int down = uniQuePathsWoDPRightDown1(i+1, j, m, n, sum);

        return right + down;
    }


    public static  int uniQuePathsDPRightDown(int i, int j, int m, int n, int[][] dp){
        if(i == m-1 && j == n-1)
            return 1;

        if(i>=m || j>=n)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];

        int right = uniQuePathsDPRightDown(i, j+1, m, n, dp);
        int down = uniQuePathsDPRightDown(i+1, j, m, n, dp);

        dp[i][j] = right + down;
        return dp[i][j];
    }

    public static int uniQuePathsWoDPLeftUp(int m, int n){
        count = 0;
        uniQuePathsWoDPLeftUpRecursive(m-1, n-1);
        return count;
    }

    public static  void uniQuePathsWoDPLeftUpRecursive(int m, int n){
        if(m == 0 && n == 0)
            count++;

        if(m < 0 || n <0 )
            return;
        uniQuePathsWoDPLeftUpRecursive(m, n-1);
        uniQuePathsWoDPLeftUpRecursive(m-1, n);
    }

    public static int uniQuePathsWoDPLeftUp1(int m, int n){
        int result = uniQuePathsWoDPLeftUpRecursive1( m-1, n-1);
        return result;
    }
    public static int uniQuePathsWoDPLeftUpRecursive1(int m, int n){
        if(m == 0 && n == 0)
            return 1;

        if(m < 0 || n < 0)
            return 0;
        int left = uniQuePathsWoDPLeftUpRecursive1(m, n-1);
        int up = uniQuePathsWoDPLeftUpRecursive1(m-1, n);

        return left + up;
    }


    public static int uniQuePathDPMemoRightDown(int m, int n){

        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        return uniQuePathDPMemoRightDown( 0, 0, dp.length, dp[0].length,dp);
    }


    public static  int uniQuePathDPMemoRightDown(int i, int j, int row, int col,  int[][] dp){
        if(i == row-1 && j == col-1)
            return 1;
        if(i >= row || j >= col)
            return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int right = uniQuePathDPMemoRightDown(i, j+1, row, col, dp);
        int down = uniQuePathDPMemoRightDown(i+1, j, row, col, dp);

        dp[i][j] = right + down;

        return dp[i][j];
    }
    public static int uniQuePathDPMemoLeftUp(int m, int n){

        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            Arrays.fill(dp[i], -1);
        }
        return uniQuePathDPMemoLeftUp( m-1, n-1, dp);
    }


    public static  int uniQuePathDPMemoLeftUp(int m, int n, int[][] dp){
        if(m == 0 && n == 0)
            return 1;
        if(m < 0 || n < 0)
            return 0;

        if(dp[m][n] != -1){
            return dp[m][n];
        }
        int left = uniQuePathDPMemoLeftUp(m, n-1, dp);
        int up = uniQuePathDPMemoLeftUp(m-1, n, dp);

        dp[m][n] = left + up;

        return dp[m][n];
    }

}
