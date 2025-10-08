package com.leetcode.recursion;

public class GCDorHCF {
    public static void main(String[] args) {
        // find GCD between n1 and n2
        int n1 = 81, n2 = 153, gcd;

        gcd = findHCF(n1, n2);
        System.out.println("GCD of " + n1 +" and " + n2 + " is " + gcd);
        gcd = gcdByRecursion(n1, n2);
        System.out.println("GCD of " + n1 +" and " + n2 + " is by recursion " + gcd);

        gcd = getHCFByRecursion(n1, n2);
        System.out.println("GCD of " + n1 +" and " + n2 + " is by getHCFByRecursion " + gcd);
    }

    static int findHCF(int n1, int n2){
        // initially set to gcd
        int gcd = 1;

        for (int i = 1; i <= n1 && i <= n2; ++i) {
            // check if i perfectly divides both n1 and n2
            if (n1 % i == 0 && n2 % i == 0)
                gcd = i;
        }
        return gcd;
    }

    static int gcdByRecursion(int a, int b){

        System.out.println("gcdByRecursion a "+ a +" b " + b);
        if(a>b)
            System.out.println("gcdByRecursion ("+a+"-"+b+"): " + (a-b));
        if(b>a)
            System.out.println("gcdByRecursion ("+b+"-"+a+"): " + (b-a));

        if (a == 0)
            return b;
        if (b == 0)
            return a;
        if (a == b)
            return a;
        if (a > b)
            return gcdByRecursion(a-b, b);
        return gcdByRecursion(a, b-a);
    }

    static int getHCFByRecursion(int a, int b) {
        if(a!=0 && b!=0) {
            System.out.println("getHCF mod of a " + a +" and b " + b + " is " + (a%b));
        }
        return b == 0 ? a : getHCFByRecursion(b, a % b);
    }
}
