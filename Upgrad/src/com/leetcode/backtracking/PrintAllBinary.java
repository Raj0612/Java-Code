package com.leetcode.backtracking;

public class PrintAllBinary {

    public static void main(String[] args) {
     //   input1();
        input2();
    }

    static void input1(){
        int n = 2;
        int arr[] = new int[n];
        printAllBinary(n, arr, 0);
    }

    static void input2(){
        int n = 3;
        int arr[] = new int[n];
        printAllBinary(n, arr, 0);
    }

    static  void printAllBinary(int n, int arr[], int i) {
        if(i == n) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr[j]);
            }
            System.out.println();
            return;
        }
        arr[i] = 0;
        printAllBinary(n, arr, i + 1);
        arr[i] = 1;
        printAllBinary(n, arr, i + 1);
    }

    static  void printAllBinary1(int n, int arr[], int i) {
        if(i == n) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr[j]);
            }
            System.out.println();
            return;
        }
        for(int k=0; k<=1; k++) {
            arr[i] =k;
            printAllBinary1(n, arr, i + 1);
        }
    }
}
