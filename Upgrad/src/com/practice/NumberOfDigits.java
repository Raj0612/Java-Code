package com.practice;

public class NumberOfDigits {

    public static void main(String[] args) {

        int num = 5402;
       // int num =5;
        int count = 0;

        while(num!=0){
            System.out.println(" num " + num);
            num /= 10;

            count++;
        }

        System.out.println("Count " + count);
        System.out.println("Div " + 5/10);

    }
}
