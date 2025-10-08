package com.leetcode.recursion;

public class Factorial {

    public static void main(String[] args) {
        int num = 4;

        System.out.printf("Factorial of %d = %d /n", num, findFactorial(num));

        System.out.printf("Factorial of %d = %d", num, findFactorialByRecursionNonTail(num));

      //  System.out.printf("Factorial of %d = %d", num, findFactorialByRecursionTail(num));
    }

    static long findFactorial(int num){
        long factorial = 1;
        for (int i = 1; i <= num; ++i) {
            // factorial = factorial * i;
            factorial *= i;
        }
        return factorial;
    }

    static long findFactorialByRecursionNonTail(int num){

        if(num == 1)
            return 1;
        else
            return  (num * findFactorialByRecursionNonTail(num-1));

    }

    static long findFactorialByRecursionTail(int num, int a){
        if(num==1)
            return a;
        return  findFactorialByRecursionTail(num-1, num *a);
    }
}
