package com.leetcode.recursion;

public class TailAndNonTail {

    public static void main(String[] args) {
        int n = 5;

      //  tailRecursion(5);
        nonTailRecursion(5);
    }


    static void nonTailRecursion(int n) {
        if(n == 0)
            return;
        nonTailRecursion(n-1);
        System.out.print(n + " ");
    }

    static void tailRecursion(int n) {
        if(n == 0)
            return;
        System.out.print(n + " ");
        tailRecursion(n-1);
    }
}
