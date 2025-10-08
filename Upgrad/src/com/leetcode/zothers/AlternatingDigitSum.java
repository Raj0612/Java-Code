package com.leetcode.zothers;

//You are given a positive integer n. Each digit of n has a sign according to the following rules:
/*
The most significant digit is assigned a positive sign.
Each other digit has an opposite sign to its adjacent digits.
 */
//Return the sum of all digits with their corresponding sign.
/*
Example 1:
Input: n = 521
Output: 4
Explanation: (+5) + (-2) + (+1) = 4.

Example 2:
Input: n = 111
Output: 1
Explanation: (+1) + (-1) + (+1) = 1.

Example 3:
Input: n = 886996
Output: 0
Explanation: (+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0.
 */

public class AlternatingDigitSum {

    public static void main(String[] args) {
            input1();
    }

    static void input1(){
        int n = 886996;
        n = 88;
        System.out.println("input1 " + alternateDigitSum(n));
    }

    static public int alternateDigitSum(int number) {
        int alternatingSum = 0;
        int sign = 1;
        for (char digitChar : String.valueOf(number).toCharArray()) {
            int digit = digitChar - '0';
            alternatingSum += sign * digit;
            sign *= -1;
        }
        return alternatingSum;
    }
}
