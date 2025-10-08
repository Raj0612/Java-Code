package com.recursion;

public class Factorial {

    public static void main(String[] args) {

        int n = 5;

        int result = factorialByRecursion(n);
        System.out.println("result " + result);
    }
    static int factorialByRecursion(int n){

        if(n==1)
            return 1;
        return n * (factorialByRecursion(n-1));
    }
}
