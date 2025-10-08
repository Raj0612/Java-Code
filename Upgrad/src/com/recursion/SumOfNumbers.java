package com.recursion;

public class SumOfNumbers {

    public static void main(String[] args) {
        int n = 10;

        findSumOfNumbers(n);
        System.out.println("findSumOfNumbersByRecursion " + findSumOfNumbersByRecursion(n));
    }

    static  void findSumOfNumbers(int n){
        int sum = 0;
        for(int i=1; i<=n; i++){
            sum = sum +i;
        }
        System.out.println((n*(n+1))/2);
        System.out.println("findSumOfNumbers " + sum);
    }

    static int  findSumOfNumbersByRecursion(int n){
        if(n==0)
            return 0;
        return  n + (findSumOfNumbersByRecursion(n-1));
    }
}
