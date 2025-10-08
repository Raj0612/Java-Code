package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
/*
Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        input1();
       // input2();
    }

    static List<String> generateParentheses(int n){
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    public static void backtrack(List<String> list, String str, int open, int close, int n){
        if(str.length() == n*2){
            list.add(str);
            return;
        }
        if(open < n){
            backtrack(list, str+"(", open+1, close, n);
        }
        if(close < open){
            backtrack(list, str+")", open, close+1, n);
        }
    }

    static List<String> upgradGenerateParentheses(int n){
        List<String> list = new ArrayList<String>();
        char[] arr = new char[n*2];
//        arr[0] = '(';
//        arr[1] =')';
      //  upgradHelper(0, n*2, arr, list);
        upgradHelper1(0, n*2, arr, list, 0, 0);
        return list;
    }

    static void upgradHelper(int index, int len, char[] arr,  List<String> list ){

        if(index == len){
            if(is_valid(arr)){
                String str = new String(arr);
                list.add(str);
            }
            return;
        }
        for(int i=0; i<arr.length; i++){
            upgradHelper(index+1, len, arr, list);
        }

//        arr[index] = '(';
//        upgradHelper(index+1, len, arr, list);
//        arr[index] = ')';
//        upgradHelper(index+1, len, arr, list);
    }


    static void upgradHelper1(int index, int len, char[] arr,  List<String> list , int open , int close){

        if((open+close==len) && ((open < close) || (open>close)))
            return;

        if(index == len){
            if(is_valid(arr)){
                String str = new String(arr);
                list.add(str);
            }
            return;
        }

        arr[index] = '(';
        upgradHelper1(index+1, len, arr, list, open+1, close);
        arr[index] = ')';
        upgradHelper1(index+1, len, arr, list, open, close+1);
    }

    static boolean is_valid(char[] arr){
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

    static void input1(){
        int n = 3;
      //  System.out.println("generateParentheses " + generateParentheses(n));
        System.out.println("upgradGenerateParentheses " + upgradGenerateParentheses(n));
    }

    static void input2(){
        int n = 2;
        System.out.println("input2 generateParentheses " + generateParentheses(n));
        System.out.println("input2 upgradGenerateParentheses " + upgradGenerateParentheses(n));
    }
}
