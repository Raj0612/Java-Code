package com.leetcode.dynamicprogramming;
//Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

//A subsequence of a string is a new string generated from the original string with some characters (can be none)
// deleted without changing the relative order of the remaining characters.
//For example, "ace" is a subsequence of "abcde".
//A common subsequence of two strings is a subsequence that is common to both strings.
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        input1();
    }

    //Time Complexity: O(nm)
    //Space Complexity :O(nm)
    public static int longestCommonSubsequenceDP(String text1, String text2) {
        int [][]dp = new int[text1.length()+1][text2.length()+1];
        for(int i= text1.length()-1;i>=0;i--){
            for(int j = text2.length()-1;j>=0;j--){
                char ch1 = text1.charAt(i);
                char ch2 = text2.charAt(j);
                if(ch1==ch2) // diagnal
                    dp[i][j]= 1+dp[i+1][j+1];
                else// left,down
                    dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j]);

            }
        }
        return dp[0][0];
    }

    public static int longestCommonSubsequenceDP11(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // dp[i][j] := LCS's length of text1[0..i) and text2[0..j)
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                dp[i + 1][j + 1] = text1.charAt(i) == text2.charAt(j)
                        ? 1 + dp[i][j]
                        : Math.max(dp[i][j + 1], dp[i + 1][j]);

        return dp[m][n];
    }
    public static int longestCommonSubsequenceRecursionUpgrad(String text1, String text2) {
        return longestCommonSubsequenceRecursionUpgrad(0, 0,text1, text2);
    }

    public static int longestCommonSubsequenceRecursionUpgrad1(String text1, String text2) {
        return longestCommonSubsequenceRecursionUpgrad1(text1.length()-1, text2.length()-1,text1, text2);
    }

    public static int longestCommonSubsequenceRecursionUpgrad(int i, int j, String text1, String text2) {
        if(i==text1.length() || j == text2.length())
            return 0;

        if(text1.charAt(i) == text2.charAt(j))
            return 1+ longestCommonSubsequenceRecursionUpgrad(i+1, j+1, text1, text2);
        else
           return Math.max(longestCommonSubsequenceRecursionUpgrad(i+1, j, text1, text2), longestCommonSubsequenceRecursionUpgrad(i, j+1, text1, text2));
    }

    public static int longestCommonSubsequenceRecursionUpgrad1(int i, int j, String text1, String text2) {
        if(i<0  || j <0)
            return 0;

        if(text1.charAt(i) == text2.charAt(j))
            return 1+ longestCommonSubsequenceRecursionUpgrad1(i-1, j-1, text1, text2);
        else
            return Math.max(longestCommonSubsequenceRecursionUpgrad1(i-1, j, text1, text2), longestCommonSubsequenceRecursionUpgrad1(i, j-1, text1, text2));
    }
    static void input1(){
        String str1 = "kgf";
        String str2 = "apkfngpk";
       // System.out.println("input1 longestCommonSubsequenceDP " + longestCommonSubsequenceDP(str1, str2));
      //  System.out.println("input1 longestCommonSubsequenceDP11 " + longestCommonSubsequenceDP11(str1, str2));
        System.out.println("input1 longestCommonSubsequenceRecursionUpgrad " + longestCommonSubsequenceRecursionUpgrad(str1, str2));
        System.out.println("input1 longestCommonSubsequenceRecursionUpgrad1 " + longestCommonSubsequenceRecursionUpgrad1(str1, str2));
    }

    static void input2(){
        String str1 = "abcd";
        String str2 = "kbpch";
        //System.out.println("input2 longestCommonSubsequenceDP " + longestCommonSubsequenceDP(str1, str2));
       // System.out.println("input2 longestCommonSubsequenceDP11 " + longestCommonSubsequenceDP11(str1, str2));
        System.out.println("input2 longestCommonSubsequenceRecursionUpgrad " + longestCommonSubsequenceRecursionUpgrad(str1, str2));
    }
}
