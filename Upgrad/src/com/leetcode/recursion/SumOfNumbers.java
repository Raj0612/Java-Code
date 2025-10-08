package com.leetcode.recursion;

public class SumOfNumbers {

    public static void main(String[] args) {

        int n = 5013;

        System.out.println("sumOfNumberWORecursion " + sumOfNumberWORecursion(n));
        System.out.println("sumOfNumberWithRecursion " + sumOfNumberWithRecursion(n));

    }

    static int sumOfNumberWORecursion(int number){
        int sum = 0;
        while(number!=0){
            int digit = number%10;
            sum = sum + digit;
            number = number/10;
            System.out.println("digit: " + digit + " number: " + number);
        }
        return sum;
    }


    static int sumOfNumberWithRecursion(int number){
        if(number==0)
            return 0;
        int digit = number%10;
        number = number/10;
        return digit + sumOfNumberWithRecursion(number);
    }
}
