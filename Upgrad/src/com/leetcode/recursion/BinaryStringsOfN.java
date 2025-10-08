package com.leetcode.recursion;

import java.util.Arrays;

public class BinaryStringsOfN {
    // 2^n -1
    public static void main(String[] args) {
        int n = 3;
        int[] arr = new int[n];
        System.out.println( Arrays.toString(arr));
       // binaryStringsOfNWithRecursion(n, arr, 0);
        binaryStringsOfNWithRecursion1(n, arr, 0);
       // printTheArray(arr, n);
       // System.out.println("binaryStringsOfNWithRecursion " + Arrays.toString(arr));
    }

    static void binaryStringsOfNWithRecursion1(int n, int[] arr, int i){
        if (i == n) {
            printTheArray(arr, n);
            return;
        }
        for(int val= 0; val<=1; val++){
            arr[i] = val;
            binaryStringsOfNWithRecursion1(n, arr, i + 1);
        }

    }


    static void binaryStringsOfNWithRecursion(int n, int[] arr, int i){
        if (i == n) {
            printTheArray(arr, n);
            return;
        }
        arr[i] = 0;
        binaryStringsOfNWithRecursion(n, arr, i + 1);
        arr[i] = 1;
        binaryStringsOfNWithRecursion(n, arr, i + 1);
    }

    static void binaryStringsOfNWORecursion(int num){

        int start = 0;
        int end = (int)Math.pow(2, num)-1;

      for(int i=0; i<=end; i++){
          //convert each to binary
      }

    }

    static void printTheArray(int arr[], int n) {
       // System.out.println("printTheArray n " + Arrays.toString(arr));
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


}
