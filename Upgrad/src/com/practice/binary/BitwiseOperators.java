package com.practice.binary;

public class BitwiseOperators {

    public static void main(String[] args) {
        input1();
    }

    static void bitwiseOperators(int a, int b){
        System.out.println("a: "+ a + " b: " + b);
        System.out.println("a & b " + (a & b));
        System.out.println("a | b " + (a | b));
        System.out.println("a ^ b " + (a ^ b));

        System.out.println("a ^ 0 " + (a ^ 0));
        System.out.println("a ^ a " + (a ^ a));

        System.out.println("a & 0 " + (a & 0));
        System.out.println("a & a " + (a & a));

    }
    static void input1(){
        int a = 5;
        int b = 9;
        bitwiseOperators(a, b);
    }
}
