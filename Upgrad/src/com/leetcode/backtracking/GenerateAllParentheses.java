package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateAllParentheses {

    public static void main(String[] args) {
        input1();
    }
    static List<String> generateParentheses(int n){
        List<String> list = new ArrayList<String>();
//        char arr[] = new char[ n*2];
//        for(int i=0; i<arr.length; i++){
//
//            if(i%2==0)
//                arr[i]= '(';
//            else
//                arr[i] = ')';
//        }
        char arr[] = new char[2];
        arr[0]= '(';
        arr[1]= ')';
        char newArr[] = new char[ n*2];
        System.out.println("generateParentheses array " + Arrays.toString(arr));
     //   backtrack(list, 0, arr, new String(arr));
        backtrack(list, 0, arr, newArr);
        return list;
    }

    public static void backtrack(List<String> list, int index, char[] arr, String str){

        if(index == arr.length){
            String str1 =new String(arr);
            list.add(str1);
            return;
        }

        for(int i =0; i<arr.length; i++){
             arr[index] = str.charAt(i);
             backtrack(list, index+1, arr, str);
        }
    }

    public static void backtrack(List<String> list, int index, char[] arr, char[] newArr){

        if(index == newArr.length){
            String str1 =new String(newArr);
            list.add(str1);
            return;
        }

        for(int i =0; i<arr.length; i++){
            newArr[index] = arr[i];
            backtrack(list, index+1, arr, newArr);
        }
    }

    static void input1(){
        int n = 3;
        int result = 1;
        List<String> list = generateParentheses(n);
        System.out.println("input1 " + list);
        System.out.println("input1 list count " + list.size());
        for(int i=1;i <=n*2; i++){
            result = result* (n*2);
            if(i== n*2)
                System.out.println("powver  " + result );
        }
    }
}
