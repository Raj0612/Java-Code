package com.leetcode.zothers;

//A perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself.
// A divisor of an integer x is an integer that can divide x evenly.

//Given an integer n, return true if n is a perfect number, otherwise return false.

/*
Input: num = 28
Output: true
Explanation: 28 = 1 + 2 + 4 + 7 + 14
1, 2, 4, 7, and 14 are all divisors of 28.
 */
public class PerfectNumber {

    public static void main(String[] args) {
        int num = 28;

        System.out.println("checkPerfectNumber " + checkPerfectNumber(num));
        System.out.println("checkPerfectNumber1 " + checkPerfectNumber1(num));
    }

    static boolean checkPerfectNumber(int num){
        int sum = 1;
        for(int i= 2; i <=num/2; i++){
            if(num % i ==0){
             //   if(i !=num/i)
                    sum = sum + i;
            }
        }
        System.out.println("Sum " + sum);
        if(sum == num)
            return true;
        else
            return false;
    }

    static boolean checkPerfectNumber1(int num){
        int sum = 1;
        for(int i= 2; i *i <=num; i++){
            if(num % i ==0){
                  if(i *i == num )
                     sum = sum + i;
                  else
                      sum = sum + i + (num/i);
            }
        }
        System.out.println("checkPerfectNumber1 Sum " + sum);
        if(sum == num)
            return true;
        else
            return false;
    }
}
