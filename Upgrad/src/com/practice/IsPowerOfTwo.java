package com.practice;

public class IsPowerOfTwo {

    public static void main(String[] args) {
        int n = 32;
        System.out.println("isPowerOfTwo " + n + " is " + isPowerOfTwo(n));

    }

    static boolean isPowerOfTwo(int n){

        while(n !=1){
            if(n%2 !=0){
               return false;
            }
            n = n/2;
        }
        return true;

    }
}
