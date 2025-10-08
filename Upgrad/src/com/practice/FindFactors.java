package com.practice;

public class FindFactors {

    public static void main(String[] args) {
        int number =60;

        findFactorsDivBy2(number);
        System.out.println();
        findFactorsBySqrt(number);
    }

    static void findFactorsDivBy2(int number){
        for (int i = 1; i <= number/2; ++i) {
            if (number % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.print(number + " ");
    }

    static void findFactorsBySqrt(int number){
        for (int i = 1; i *i<= number; ++i) {
            if (number % i == 0) {
                System.out.print(i + " " +(number/i) + " ");
            }
        }
       // System.out.print(number + " ");
    }
}
