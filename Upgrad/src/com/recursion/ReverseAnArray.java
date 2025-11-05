package com.recursion;

public class ReverseAnArray {

    public static void main(String[] args) {

        int[] arr = new int[5];

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        arr[4] = 4;

        reverseArrayByForLoop(arr);
        System.out.println("reverseArrayByForLoopBySwap:");
        reverseArrayByForLoopBySwap(arr);
        System.out.println();
        reverseArrayByForLoopByRecursion(arr, 0, arr.length-1);
        for(int k =0; k< arr.length; k++){
            System.out.print(arr[k] + " ");
        }
    }

    static void reverseArrayByForLoopByRecursion(int arr[], int i, int j){

        if(i>=j)
            return;

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        reverseArrayByForLoopByRecursion(arr, i+1, j-1);
    }

    static void reverseArrayByForLoop(int[] arr){

        for(int i =0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("By Reverse: ");
        for(int i = arr.length-1; i>= 0; i--){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void reverseArrayByForLoopBySwap(int[] arr){
        int i =0, j= arr.length-1;

        while(i<j){

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }

        for(int k =0; k< arr.length; k++){
            System.out.print(arr[k] + " ");
        }
    }
}
