package com.leetcode.binary;

public class BinaryToDecimal {

    public static void main(String[] args) {
        System.out.println("input: " + binaryToDecimal("101"));
        System.out.println("input: " + binaryToDecimal("111001"));

        int val = 's' - '0';
        System.out.println("val " + val);
    }

    public static int binaryToDecimal(String s){

        int pow =0;
        int ans =0;

        for(int i= s.length() -1; i>=0; i--){

            int val = Character.getNumericValue(s.charAt(i));
            ans = ans +  (val *(int)Math.pow(2, pow));
                   ;
            pow++;
        }

        return ans;
    }
}
