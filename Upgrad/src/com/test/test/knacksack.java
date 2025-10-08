package com.test.test;

public class knacksack {

    public static void main(String[] args) {

        int values = 60+ 100 + 120;

        int weights = 10 + 20 + 30;

        float singlePrice = (float) values/(float) weights;
        System.out.println("singlePrice " + singlePrice);

        float total = singlePrice * 50;

        System.out.println( " total " + total );

    }
}
