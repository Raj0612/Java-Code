package com.practice.binary;

public class BinaryToDecimal {

    public static void main(String[] args) {

        String str = "1110";
        System.out.println("binaryToDecimal " + binaryToDecimal(str));

    }

    static int binaryToDecimal(String s){

        int pow =0;
        int ans =0;

        for(int i =s.length()-1; i>=0; i--){
            ans = ans + ((s.charAt(i) - '0') * (int)Math.pow(2, pow) );
            pow++;
        }
        return ans;
    }
}
