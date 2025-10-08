package com.leetcode.backtracking;

public class PrintNumbers {

    public static void main(String[] args) {
           input1();
       // input2();
    }

    static void input1(){
        int n = 3;
        int arr[] = new int[n];
        printAllNumbers(n, arr, 0);
    }

    static void input2(){
        int n = 4;
        int arr[] = new int[n];
        printAllNumbers(n, arr, 0);
    }


    static  void printAllNumbers(int n, int arr[], int i) {
        if(i == n) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr[j]);
            }
            System.out.println();
            return;
        }
        for(int k=1; k<=n; k++) {
            arr[i] =k;
            printAllNumbers(n, arr, i + 1);
        }
    }
}
