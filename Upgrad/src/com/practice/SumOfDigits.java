package com.practice;

public class SumOfDigits {

    public static void main(String[] args) {

        int num = 5403;

        int count =0;

        while(num!=0){
            int rem = num%10;
            count += rem;

            num = num /10;
        }

        System.out.println("Answer " + count);
    }
}
