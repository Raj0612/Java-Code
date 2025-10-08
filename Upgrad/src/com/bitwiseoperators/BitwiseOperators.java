package com.bitwiseoperators;

public class BitwiseOperators {

    public static void main(String[] args) {
         int a =5, b=9;

        System.out.println("AND Operator " + (a&b));
        System.out.println("OR Operator " + (a|b));
        System.out.println("XOR Operator " + (a^b));

        System.out.println();

        System.out.println("OR Operator " + (a|0));
        System.out.println("AND Operator " + (a&0));
        System.out.println("XOR Operator " + (a^0));

        System.out.println();

        System.out.println("OR Operator " + (a|a));
        System.out.println("AND Operator " + (a&a));
        System.out.println("XOR Operator " + (a^a));

        System.out.println();

        System.out.println("OR Operator " + (a|a|a));
        System.out.println("AND Operator " + (a&a&a));
        System.out.println("XOR Operator " + (a^a^a));
    }
}
