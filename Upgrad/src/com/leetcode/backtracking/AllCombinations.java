package com.leetcode.backtracking;

public class AllCombinations {

    public static void main(String[] args) {

        int n = 3;
        int[] arr = new int[n];
        allCombinationWithRecursion(n,arr,0);
    }

    static void allCombinationWithRecursion(int n, int[] arr, int i){
        if (i == n) {
            printTheArray(arr, n);
            return;
        }
        for(int val= 1; val<=n; val++){
            arr[i] = val;
            allCombinationWithRecursion(n, arr, i + 1);
        }

    }

    static void printTheArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
