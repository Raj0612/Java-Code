package com.leetcode.backtracking;

public class Test {

    public static void main(String[] args) {
        char[] arr = new char[]{'(','(',')','(',')',')'};
        System.out.println("testValidParentheses " + testValidParentheses(arr));
    }


    static  boolean testValidParentheses(char[] arr) {
        int open = 0;
        int close =0;
        for(int i =0; i<arr.length; i++){
            if(arr[i]=='(')
                open++;
            else
                close++;

            if(open < close)
                return false;
        }
        if(open ==close){
            return true;
        }
        return false;
    }
}
