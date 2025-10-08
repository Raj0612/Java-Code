package com.practice;

import java.util.Arrays;
//Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
/*
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 */
public class CountingBits {

    public static void main(String[] args) {

        System.out.println("countBits " + Arrays.toString(countBits(10)));
        System.out.println("upgradCountBits " + Arrays.toString(upgradCountBits(10)));
        System.out.println("test " + test(7));
    }
    public static int[] countBits(int num) {
        int[] result = new int[num+1];

        result[0] = 0;
        int nearest = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i-1)) == 0) {
                result[i] = 1;
                nearest = i;
               // System.out.println("If " + Arrays.toString(result));
            } else {
                result[i] = result[i-nearest] + result[nearest];
               // System.out.println("Else " + Arrays.toString(result));
            }
        }

        return result;
    }

    public static int[] upgradCountBits(int num) {
        int[] result = new int[num+1];
        result[0] = 0;
        for (int i = 1; i <= num; i++) {
            int count = decimalToBinaryNumberCounts(i);
            result[i] = count;
        }
        return result;
    }
    static int decimalToBinaryNumberCounts(int n){
        int count =0;
        while (n!=0){
            if(n%2 !=0){
                count++;
            }
            n = n/2;
        }
        return  count;
    }

    static int test(int num){
        int n = num;
        int count =0;
        while (n!=0){
            if(n%2 !=0){
                count++;
            }
            n = n/2;
        }
        return  count;
    }
}
