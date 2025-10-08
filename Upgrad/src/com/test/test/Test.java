package com.test.test;

public class Test {


    public static void main(String[] args) {
        int totalSum = 0;
        for(int i=1; i<=10; i++) {

            int sum = 7000 * i;
            totalSum = totalSum + sum;
            System.out.println("totalSum " + totalSum);
        }

        System.out.println("Final totalSum " + totalSum);
    }
}
