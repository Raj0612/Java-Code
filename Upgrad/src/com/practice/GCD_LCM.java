package com.practice;

public class GCD_LCM {

    public static void main(String[] args) {
        System.out.println("GCD " + gcd(3, 6));
        System.out.println("LCM " + lcm(2, 7));
    }


    //GCD(a,b) = GCD(remainder(b,a),a)
    static int gcd(int a, int b){
        if(a==0)
            return  b;
        return  gcd(b%a, a);
    }

    static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }
}
