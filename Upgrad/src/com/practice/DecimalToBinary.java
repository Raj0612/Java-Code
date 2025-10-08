package com.practice;

import java.util.Arrays;

public class DecimalToBinary {

    public static void main(String[] args) {
        int n =14;
        String s = decimalToBinary(n);
        System.out.println("Binary of " + n + " is " + s);
        System.out.println("reverse of " + "12345" + " is " + reverse("12345"));
    }

    static String decimalToBinary(int n){
        StringBuilder str = new StringBuilder();

        while (n!=0){
            int remainder = n%2;
            n = n/2;
            str =str.append(remainder);
        }

        return str.reverse().toString();
    }

    static String reverse(String str){
        String string = new String();
        char arr[] = new char[str.length()];
        System.out.println("Char arra " + Arrays.toString(arr));
        for(int i=0, j =str.length()-1; i<=j; i++, j--){
            char temp = str.charAt(i);
            arr[i] = str.charAt(j);
            arr[j] = temp;
        }

        return string.valueOf(arr);
    }
}
