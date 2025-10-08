package com.practice;

public class IsSubSequence {
    static String S , T;
    public static void main(String[] args) {
        String a = "abc" , b = "mnagbcd";

        String c ="mnagcbd";
        //System.out.println((isSubsequence(a , b) ? "true" : "false"));

        System.out.println("checkSubsequence " + (checkSubsequence(a , b) ? "true" : "false"));


       // System.out.println((checkSubsequence1(a , c) ? "true" : "false"));

        //System.out.println((checkSubsequence2(a , c) ? "true" : "false"));

        System.out.println("checkSubsequenceNonOptimized " + (checkSubsequenceNonOptimized(a , b) ? "true" : "false"));
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

    static boolean checkSubsequenceRecursion1(int i , int j) {
        if(i == -1)
            return true;
        if(j == -1)
            return false;
        if(S.charAt(i) == T.charAt(j))
            return checkSubsequenceRecursion(i - 1 , j - 1);
        return checkSubsequenceRecursion(i , j - 1);
    }
    static boolean isSubsequence(String s, String t) {
        S = s;
        T = t;
        System.out.println("s Lenghth " + s.length() + " t length " + t.length());
        //return checkSubsequenceRecursion((int)s.length() - 1 , (int)t.length() - 1);
        return checkSubsequenceRecursion1((int)s.length() - 1 , (int)t.length() - 1);
    }

    static boolean checkSubsequence(String s , String t)  {
        int i = s.length()-1 , j = t.length()-1;

        while(i >= 0 && j >= 0)  {
            if(s.charAt(i) == t.charAt(j)) {
                i--;
                j--;
            }
            else
                j--;
        }
        if(i >= 0)
            return false;
        return true;
    }

    static boolean checkSubsequence1(String s , String t)  {

        int i= 0;
        int j=0;
        String match ="";
        while(i < s.length() && j <t.length())  {
            if(s.charAt(i) == t.charAt(j)) {
                match += String.valueOf(s.charAt(i));
                i++;
                j++;
            }
            else
                j++;
        }
        System.out.println("match " + match);
        if(match.equals(s))
            return true;
        return false;
    }

    static boolean checkSubsequence2(String s , String t)  {

        int i= 0;
        int j=0;
        while(i < s.length() && j <t.length())  {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }
            else
                j++;
        }
        System.out.println("i " + i);
        if(s.length() ==i)
            return true;
        return false;
    }

    static boolean checkSubsequenceNonOptimized(String s , String t)  {
        String match = "";
        for(int i =0; i< s.length(); i++){
            for(int j =0; j< t.length(); j++){
                if(s.charAt(i) == t.charAt(j)){
                    match = match + s.charAt(i);
                    break;
                }
            }
        }
        System.out.println("match " + match);
        if(match.equals(s))
            return true;
        else
            return false;
    }
}
