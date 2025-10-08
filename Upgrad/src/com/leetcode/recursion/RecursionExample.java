package com.leetcode.recursion;

public class RecursionExample {


    public static void main(String[] args) {

        int n = 10;
        int sum = 0;
        for(int i=1; i<=n; i++){
            sum += i;
        }
        System.out.println("Sum using for Loop : " + sum);

        System.out.println("Sum using for Recursion : " + findSumUsingRecursion(n));
    }

    static int findSumUsingRecursion(int n){

        if(n==0)
            return 0;
        else
            return n + findSumUsingRecursion(n-1);
    }
}
