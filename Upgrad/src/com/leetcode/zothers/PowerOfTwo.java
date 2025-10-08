package com.leetcode.zothers;
//Given an integer n, return true if it is a power of two. Otherwise, return false.
//An integer n is a power of two, if there exists an integer x such that n == 2x.

/*
Input: n = 1
Output: true
Explanation: 20 = 1

Input: n = 16
Output: true
Explanation: 24 = 16
 */
public class PowerOfTwo {

    public static void main(String[] args) {

        System.out.println("isPowerOfTwoByAnd " + isPowerOfTwoByAnd(38));

        System.out.println("isPowerOfTwoByWhile " + isPowerOfTwoByWhile(38));
    }

    public static boolean isPowerOfTwoByAnd(int n) {
        if (n <= 0){
            return false;
        } else if ((n & (n - 1)) == 0){
            return true;
        }  else {
            return false;
        }
    }

    public static boolean isPowerOfTwoByWhile(int n) {
        if(n<=0) return  false;
        while(n!=1){
            if(n%2 !=0){
                return false;
            }
            n = n/2;
        }
        return true;
    }
}
