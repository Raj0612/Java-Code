package com.practice;

public class Factorial {

    public static void main(String[] args) {
        int num = 4;

        System.out.printf("Factorial of %d = %d /n", num, findFactorial(num));

    }

    static long findFactorial(int num){
        long factorial = 1;
        for (int i = 1; i <= num; ++i) {
            // factorial = factorial * i;
            factorial *= i;
        }
        return factorial;
    }


}
