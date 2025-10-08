package com.leetcode.dynamicprogramming;

import com.leetcode.linkedlist.AddTwoNumbers;

import java.util.Arrays;

//Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
//You have the following three operations permitted on a word:
//1. Insert a character , 2. Delete a character, 3. Replace a character
public class EditDistance {

    public static void main(String[] args) {
        input1();
        input2();
    }

    public static int minDistanceDPUpgrad(String word1, String word2) {
        int dp[][] = new int[word1.length()+1][word2.length()+1];

        for(int i=0; i<= word1.length(); i++){
            Arrays.fill(dp[i], -1);
        }

        return  minDistanceDPUpgrad(0, 0, word1, word2, dp);
    }

    public static int minDistanceDPUpgrad(int i, int j, String word1, String word2, int dp[][]) {
        if(i==word1.length())
            return word2.length() -j;
        if(j==word2.length())
            return word1.length()-i;

        if(dp[i][j] !=-1){
            return dp[i][j];
        }
        if(word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = minDistanceDPUpgrad(i + 1, j + 1, word1, word2, dp);

        } else {
            int insert = minDistanceDPUpgrad(i, j+1,word1, word2, dp);
            int delete = minDistanceDPUpgrad(i+1, j, word1, word2, dp);
            int replace = minDistanceDPUpgrad(i+1, j+1,word1, word2, dp);

            dp[i][j]
                    = 1 + Math.min(insert, Math.min(delete, replace));
           // return dp[i][j];
        }
        return dp[i][j];

    }

    //Time  - We are traversing through a matrix of size n*m where n and m are lengths of the two strings. So the overall complexity for the algorithm is O(n*m).
    //Space - We are creating a matrix of size n*m where n and m are lengths of the two strings to store the result for the sub-problems.
    // So the space complexity for the algorithm is O(n*m).
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i)
            dp[i][0] = i;
        for (int j = 1; j <= n; ++j)
            dp[0][j] = j;

        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j)
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;

        return dp[m][n];

    }

    static int min(int x, int y, int z) {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }

   // Time Complexity: O(m x n)
    //Auxiliary Space: O(m x n)
    public static int minDistanceRecursion(int i, int j, String word1, String word2) {

        if(i==word1.length())
            return word2.length() -j;
        if(j==word2.length())
            return word1.length()-i;
        if (word1.charAt(i) == word2.charAt(j))
            return minDistanceRecursion(i + 1, j + 1,word1, word2);

        /*return 1
                + min(minDistanceRecursion(i, j+1,word1, word2),//Insert
                minDistanceRecursion(i+1, j, word1, word2),//Remove
                minDistanceRecursion(i+1, j+1,word1, word2) );//Replace*/

        int insert = minDistanceRecursion(i, j+1,word1, word2);
        int delete = minDistanceRecursion(i+1, j, word1, word2);
        int replace = minDistanceRecursion(i+1, j+1,word1, word2);

        return 1+ Math.min(insert, Math.min(delete, replace) );
       /* return 1
                + Math.min(minDistanceRecursion(i, j+1,word1, word2),//Insert
                Math.min(minDistanceRecursion(i+1, j, word1, word2),//Remove
                        minDistanceRecursion(i+1, j+1,word1, word2)) );//Replace*/
    }

    public static int minDistanceByMemoization(int i, int j, String word1, String word2, int[][] dp) {
        if (i == 0)
            return j;
        if (j == 0)
            return i;

        if (dp[i][j] != -1)
            return dp[i][j];
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            dp[i][j] = minDistanceByMemoization(i - 1, j - 1, word1, word2, dp);
            return dp[i][j];
        } else {
            int insert = minDistanceByMemoization(i, j - 1, word1, word2, dp);
            int delete = minDistanceByMemoization(i - 1, j, word1, word2, dp);
            int replace = minDistanceByMemoization(i - 1, j - 1, word1, word2, dp);

            return dp[i][j]
                    = 1 + Math.min(insert, Math.min(delete, replace));
        }
    }

    public static int minDistanceByMemoization(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++)
            Arrays.fill(dp[i], -1);
       return minDistanceByMemoization(n, m,  str1, str2, dp);
    }
    static void input1(){
        String word1 = "horse";
        String word2 = "ros";
        //horse -> rorse (replace 'h' with 'r')
        //rorse -> rose (remove 'r')
        //rose -> ros (remove 'e')
        System.out.println("input1 minDistance " + minDistance(word1, word2));
        System.out.println("input1 minDistanceDPUpgrad " + minDistanceDPUpgrad(word1, word2));
        System.out.println("input1 minDistanceRecursion " + minDistanceRecursion(0, 0,word1, word2));
    }

    static void input2(){
        String word1 = "intention";
        String word2 = "execution";
        //intention -> inention (remove 't')
        //inention -> enention (replace 'i' with 'e')
        //enention -> exention (replace 'n' with 'x')
        //exention -> exection (replace 'n' with 'c')
        //exection -> execution (insert 'u')
        System.out.println("input2 minDistance " + minDistance(word1, word2));
        System.out.println("input2 minDistanceRecursion " + minDistanceRecursion(0, 0,word1, word2));
        System.out.println("input2 minDistanceDPUpgrad " + minDistanceDPUpgrad(word1, word2));
        System.out.println("input2 minDistanceByMemoization " + minDistanceByMemoization(word1, word2));
    }
}
