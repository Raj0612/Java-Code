package com.leetcode.zothers;

public class SumOfDigits {

    public static void main(String[] args) {
        input1();
    }

    static int sumOfNum(int n){
        int sum =0;
        while(n!=0){
            int rem = n%10;
            sum =sum+ rem;
            n = n/10;
        }
        return sum;
    }

    static void input1(){
        int n = 5013;
        System.out.println("input1 sumOfNum " +sumOfNum(n) );
    }
}
