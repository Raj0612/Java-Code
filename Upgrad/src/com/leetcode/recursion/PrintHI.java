package com.leetcode.recursion;

public class PrintHI {

    public static void main(String[] args) {

        int n= 0;

        printHi(n);
    }

    static void printHi(int n){
        if(n==0)
            return;
        else
            printHi(n-1);
    }
}
