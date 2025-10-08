package com.leetcode.recursion;

public class IsSequenceRecursion {
    static String S , T;
    public static void main(String[] args) {
        String a = "abc" , b = "mnagbcd";

        System.out.println((isSubsequence(a , b) ? "true" : "false"));
    }

    static boolean isSubsequence(String s, String t) {
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
}
