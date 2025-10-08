package com.leetcode.zothers;

//Given an integer n, return true if n has exactly three positive divisors. Otherwise, return false.
//An integer m is a divisor of n if there exists an integer k such that n = k * m.

/*
Input: n = 2
Output: false
Explantion: 2 has only two divisors: 1 and 2.

Input: n = 4
Output: true
Explantion: 4 has three divisors: 1, 2, and 4.
 */
public class ThreeDivisors {

    public static void main(String[] args) {
      //  input1();
      //  input2();
        input3();
    }

    static boolean isThree(int n){
        int count =0;
        for(int i=1; i<=n; i++){
            if(n%i ==0){
                count++;
            }
            if(count >3)
                return false;
        }

        if(count == 3)
            return true;

        return false;
    }

    static boolean isThreeOptimized(int n){
        int count =2;
        for(int i=2; i*i<=n; i++){
            if(n%i ==0){
                 if (i*i !=n)
                   count = count+2;
                 else
                     count++;
            }
            if(count >3)
                return false;
        }
        if(count == 3)
            return true;

        return false;
    }

    static boolean isThreeOptimizedByPrime(int num){
        double sqrt = Math.sqrt(num);
        System.out.println("isThreeOptimizedByPrime sqrt " + sqrt);
        long value = (long)sqrt;
        if(value*value == num){
            System.out.println("isPrime(value) " + isPrime(value));
            if(isPrime(value))
                return true;
            else
                return false;
        }
        return false;
    }

    static boolean isPrime(long num){
        if(num == 1)
            return false;
        for(int i=2; i*i<=num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    static void input1(){
        int n =4;
        System.out.println("input1 num " + n);
        System.out.println("input1 isThree " + isThree(n) );
        System.out.println("input2 isThreeOptimized " + isThreeOptimized(n) );
        System.out.println("input3 isThreeOptimizedByPrime " + isThreeOptimizedByPrime(n) );
    }

    static void input2(){
        System.out.println();
        int n =25;
        System.out.println("input2 num " + n);
        System.out.println("input2 isThree " + isThree(n) );
        System.out.println("input2 isThreeOptimized " + isThreeOptimized(n) );
        System.out.println("input3 isThreeOptimizedByPrime " + isThreeOptimizedByPrime(n) );
    }

    static void input3(){
        System.out.println();
        int n =40;
        System.out.println("input3 num " + n);
        System.out.println("input3 isThree " + isThree(n) );
        System.out.println("input3 isThreeOptimized " + isThreeOptimized(n) );
        System.out.println("input3 isThreeOptimizedByPrime " + isThreeOptimizedByPrime(n) );
    }
}
