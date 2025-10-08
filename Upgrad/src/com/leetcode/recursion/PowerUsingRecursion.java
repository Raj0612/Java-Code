package com.leetcode.recursion;

public class PowerUsingRecursion {

    public static void main(String[] args) {
        int base = 3, powerRaised = 4;
        int result = power(base, powerRaised);

        System.out.println(base + "^" + powerRaised + "=" + result);
    }

    public static int power(int base, int powerRaised) {
        if (powerRaised == 0)
            return 1;
        else
            return (base * power(base, powerRaised - 1));

    }
}
