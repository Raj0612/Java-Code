package com.leetcode.binary;
//Given two binary strings a and b, return their sum as a binary string.

/*Example 1:
        Input: a = "11", b = "1"
        Output: "100"
Example 2:
        Input: a = "1010", b = "1011"
        Output: "10101"*/
public class AddBinary {

    public static void main(String[] args) {
        input1();
        input2();
        input3();
    }

    static String addBinary(String a , String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        System.out.println("i " + i + " j :" + j);
        int carry = 0;
        int x = 0;
        int y = 0;

        StringBuilder ans = new StringBuilder("");

        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0)
                carry += a.charAt(i--) - '0';
            if (j >= 0)
                carry += b.charAt(j--) - '0';
            ans.append(carry % 2);
            carry /= 2;

        }
        return ans.reverse().toString();
    }

    static String addBinary1(String a , String b){
        int x = convertToDecimal(a);
        int y= convertToDecimal(b);

        int res = x + y;
        System.out.println("Binary of  a " + x + " b " + y + " res " + res);
        String result = Integer.toBinaryString(res);

        return result;
    }

    static int convertToDecimal(String a){

        int ans =0;
        int pow =0;
        for(int i=a.length()-1; i>=0; i--){
            char ch = a.charAt(i);
            int x = ch - '0';
            ans = ans + (x * (int)Math.pow(2, pow));
            pow ++;
        }
        System.out.println("ans " + ans);
        return ans;
    }

    static void input1(){
        String a = "11";
        String b = "1";
       System.out.println("input1 addBinary " + addBinary(a, b));
        System.out.println("input1 addBinary1 " + addBinary1(a, b));
    }

    static void input2(){
        String a = "1010";
        String b = "1011";
        System.out.println();
        System.out.println("input2 addBinary " + addBinary(a, b));
    }

    static void input3(){
        String a = "1011";
        String b = "111";
        System.out.println();
        System.out.println("input3 addBinary " + addBinary(a, b));
    }
}
