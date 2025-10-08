package com.leetcode.dynamicprogramming;

import java.util.Arrays;
//The Tribonacci sequence Tn is defined as follows:
//T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
//Given n, return the value of Tn.
public class NthTribonacciNumber {

    public static void main(String[] args) {
        input1();
    }

    static int tribonacciByRecursive(int n){

        if(n<=1 )
            return n;
        if(n==2)
            return n-1;

        return tribonacciByRecursive(n-1) +  tribonacciByRecursive(n-2) + tribonacciByRecursive(n-3);
    }


    static int tribonacciDPByMemo(int n){
        int arr[] = new int[n+1];
        Arrays.fill(arr, -1);
        return tribonacciDPByMemo(n, arr);
    }
    //Time -- O(n)
    static int tribonacciDPByMemo(int n, int arr[]){

        if(arr[n]!=-1)
            return arr[n];
        if(n<=1 )
            return n;
        if(n==2)
            return n-1;

        int n1 = tribonacciDPByMemo(n-1, arr );
        int n2 = tribonacciDPByMemo(n-2, arr);
        int n3 = tribonacciDPByMemo(n-3, arr);
        arr[n] = n1 + n2 + n3;
       // arr[n] = tribonacciDPByMemo(n-1, arr )+  tribonacciDPByMemo(n-2, arr) + tribonacciDPByMemo(n-3, arr);
        return arr[n];
    }


    static int tribonacciDPByTabulation(int n){
        int arr[] = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;

        for(int i =3; i<=n; i++){
            arr[i] = arr[i-3] + arr[i-2] + arr[i-1];
            System.out.println("arr["+i+"]: " + arr[i] );
        }

        return arr[n];
    }

    static void input1(){
        int n = 10;
        System.out.println("input1 " + n + ":" +tribonacciByRecursive(n));
        System.out.println("input1 by memo " + n + ":" +tribonacciDPByMemo(n));
        System.out.println("input1 by Tabulation " + n + ":" +tribonacciDPByTabulation(n));
    }
}
