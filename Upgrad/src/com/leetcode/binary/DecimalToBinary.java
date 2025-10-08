package com.leetcode.binary;

public class DecimalToBinary {

    public static void main(String[] args) {


        System.out.println("input: " + decimalToBinary(5));
        System.out.println("input: " + decimalToBinary(14));
    }


    public static String decimalToBinary(int n){

        String s = "";

        while (n!=0){

            if(n%2==0){
                s = s + "0";
            }else{
                s = s + "1";
            }

            n = n/2;

        }
        return  s;
    }
}
