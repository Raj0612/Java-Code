package com.practice;

import java.util.Scanner;

public class PrimeCheck {

    public static void main(String[] args) {
      //  Scanner scan = new Scanner(System.in);
        //int number = scan.nextInt();
        int number = 47;
        if(isPrime(number)) {
            System.out.println(number + " is prime number");
        }
        else{
            System.out.println(number + " is a non-prime number");
        }

        System.out.println(number + " is prime? " + isPrimeBySqrt(number));
    }

    static  boolean isPrime(int num) {
        if(num<=1) {
            return false;
        }
        for(int i=2;i<=num/2;i++)  {
            if((num%i)==0)
                return  false;
        }
        return true;
    }


    static  boolean isPrimeBySqrt(int num) {
        if(num<=1) {
            return false;
        }
        for(int i=2;i *i<=num;i++)  {
            if((num%i)==0)
                return  false;
        }
        return true;
    }
}
