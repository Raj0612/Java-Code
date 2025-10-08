package com.leetcode.zothers;

//Given two positive integers a and b, return the number of common factors of a and b.
//An integer x is a common factor of a and b if x divides both a and b.
/*
Example 1:
Input: a = 12, b = 6
Output: 4
Explanation: The common factors of 12 and 6 are 1, 2, 3, 6.

Example 2:
Input: a = 25, b = 30
Output: 2
Explanation: The common factors of 25 and 30 are 1, 5.
 */
public class NumberOfCommonFactors {

    public static void main(String[] args) {
        input1();
        input2();
    }

    static void input1(){
       int  a = 12, b = 6;
        System.out.println("input1 : " + commonFactors(a, b));
    }

    static void input2(){
        int a = 25, b = 30;
        System.out.println("input2 : " + commonFactors(a, b));
    }

    public static int commonFactors(int a, int b) {
        int gcdValue = gcd(a, b);
        System.out.println("gcdValue of  " + a + " and  " + b + " is  " + gcdValue);
        int count = 0;
        for (int x = 1; x * x <= gcdValue; ++x) {

            if (gcdValue % x == 0) {
                count += 2;
            }
            if (x * x == gcdValue) {
              count--;
            }
        }
        return count;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
