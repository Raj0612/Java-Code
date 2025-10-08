package com.test.character;

public class CharConversion {

    public static void main(String[] args) {


        int a = 5;
       // char ch = a + '0';
        char ch = (char)a;

        System.out.println("Char " + ch);

        char ch1 = '5';

        int num = ch1 + '0';
        int num1 = ch1 - '0';
        System.out.println("num " + num + " num1 " + num1);

    }
}
