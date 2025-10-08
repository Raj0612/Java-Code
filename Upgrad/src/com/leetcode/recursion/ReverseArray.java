package com.leetcode.recursion;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {

        int[] arr ={1,2,3,4,5};

        int[] arr1 ={1,2,3,4,5};

        reverseArrayWithRecursion(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));

        reverseArrayWithOutRecursion(arr1);

    }

    static void reverseArrayWithRecursion(int[] arr, int i, int j){

        if(i>=j)
            return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        System.out.println("reverseArrayWithRecursion i: " + i +  " j: " + j + " : " + Arrays.toString(arr));
        reverseArrayWithRecursion(arr, i+1, j-1);
    }

    static void reverseArrayWithOutRecursion(int[] arr){

        int i =0;
        int j = arr.length-1;

        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            System.out.println("reverseArrayWithOutRecursion i: " + i +  " j: " + j + " : " + Arrays.toString(arr));
            i++; j--;
        }
        System.out.println("reverseArrayWithOutRecursion " + Arrays.toString(arr));
    }
}

