package com.leetcode.recursion;

public class RecursionBasic {

    public static void main(String[] args) {
            methodOne();
    }

    static void methodOne(){
        methodTwo();
        System.out.println("One");
    }
    static void methodTwo(){
        methodThree();
        System.out.println("Two");
    }
    static void methodThree(){
        methodFour();
        System.out.println("Three");
    }

    static void methodFour(){
        System.out.println("Four");
    }
}
