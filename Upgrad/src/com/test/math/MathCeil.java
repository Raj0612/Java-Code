package com.test.math;

public class MathCeil {

    public static void main(String[] args) {
        int num = 23;
        int k = 16;
        int result = (int) Math.ceil(num/k);
        int result1 = (int) Math.ceil((float)num/(float)k);
        System.out.println("Result " + result + " ---- result by float " + result1);
    }
}
