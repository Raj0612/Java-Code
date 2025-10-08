package com.leetcode.recursion;

public class LCM {

    public static void main(String[] args) {
        int n1 = 72, n2 = 120, lcm;
        lcm = findLCM(n1, n2);
        System.out.println("findLCM " + lcm);
        lcm = lcmByRecursion(n1, n2);
        System.out.println("lcmByRecursion " + lcm);

    }

    static int findLCM(int n1, int n2){
        // maximum number between n1 and n2 is stored in lcm
        int  lcm = (n1 > n2) ? n1 : n2;
        System.out.println("lcm " + lcm);
        // Always true
        while(true) {
            if( lcm % n1 == 0 && lcm % n2 == 0 ) {
                System.out.printf("The LCM of %d and %d is %d.", n1, n2, lcm);
                break;
            }
            ++lcm;
        }
        return lcm;
    }

    static int lcmByRecursion(int n1, int n2){

        int hcf = getHCF(n1, n2);
        System.out.println("The HCF: " + hcf);

        int lcm = (n1 * n2) / hcf;
        System.out.println("The LCM: " + lcm);


        return lcm;
    }

    static int getHCF(int a, int b) {
        if(a!=0 && b!=0) {
            System.out.println("getHCF mod of a " + a +" and b " + b + " is " + (a%b));
        }
        return b == 0 ? a : getHCF(b, a % b);
    }
}
