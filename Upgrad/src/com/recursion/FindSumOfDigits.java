package com.recursion;

public class FindSumOfDigits {

    public static void main(String[] args) {

        int n = 5013;

        int sumByWhile = findSumOfDigitsByWhile(n);
        System.out.println("findSumOfDigitsByWhile " + sumByWhile);
        int sumOfDigitsByRecursion =  findSumOfDigitsByRecursion(n);
        System.out.println("sumOfDigitsByRecursion " + sumOfDigitsByRecursion);
    }

    static int findSumOfDigitsByWhile(int num) {
        int sum = 0;
        while (num != 0) {
            int rem = num % 10;
            num = num / 10;
            sum = sum + rem;
        }
        return sum;
    }

    static int findSumOfDigitsByRecursion(int num) {

        if(num ==0 )
            return 0;

        int digit = num % 10;

        return digit + findSumOfDigitsByRecursion(num/10);
    }
}
