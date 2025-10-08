package com.leetcode.zothers;

//Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
//A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing
// the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

/*
Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false
 */
public class IsSubSequence {
    static String S , T;
    public static void main(String[] args) {
        input1();
        input2();
    }

    static boolean isSubsequenceRecursion(String s, String t) {
        S = s;
        T = t;
        System.out.println("s Lenghth " + s.length() + " t length " + t.length());
        return checkSubsequenceRecursion((int)s.length() - 1 , (int)t.length() - 1);
    }

    static boolean checkSubsequenceRecursion(int i , int j) {
        if(i == -1)
            return true;
        if(j == -1)
            return false;
        if(S.charAt(i) == T.charAt(j))
            return checkSubsequenceRecursion(i - 1 , j - 1);
        return checkSubsequenceRecursion(i , j - 1);
    }

    static boolean isSubsequence(String s, String t) {
        int i=0;
        int j=0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else {
                j++;
            }
        }
        if(i==s.length())
            return true;
        else if(j==t.length())
            return false;

        return true;
    }

    static void input1(){
        String a = "abc" , b = "mnagbcd";

        System.out.println((isSubsequenceRecursion(a , b) ? "true" : "false"));
        System.out.println((isSubsequence(a , b) ? "true" : "false"));
    }

    static void input2(){
        System.out.println();
        String a = "axc" , b = "ahbgdc";

        System.out.println((isSubsequenceRecursion(a , b) ? "true" : "false"));
        System.out.println((isSubsequence(a , b) ? "true" : "false"));
    }
}
