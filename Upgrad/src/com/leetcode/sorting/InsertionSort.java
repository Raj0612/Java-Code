package com.leetcode.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        //input1();
        //input2();
        input3();
    }
    public static int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i-1;
           // System.out.println("sortArray key " + key + " j " + j );
            while ( (j >= 0) && ( nums [j] > key ) ) {
                nums [j+1] = nums [j];
              //  System.out.println(" j: " + j +  " nums[j] " + nums[j] + " array " +  Arrays.toString(nums));
                j--;
            }
            nums[j+1] = key;
            System.out.println("sortArray i " + i  + " Array: " + Arrays.toString(nums));
            System.out.println();
        }
        return nums;
    }

    static void input1(){
        int[] nums = {5,2,3,1};
        System.out.println("input1 " + Arrays.toString(nums));
        System.out.println("input1 Result " + Arrays.toString(sortArray(nums)));
    }

    static void input2(){
        int[] nums = {13,32,26,9,36,10};
        System.out.println("input2 " + Arrays.toString(nums));
        System.out.println("input2 Result " + Arrays.toString(sortArray(nums)));
    }

    static void input3(){
        int[] nums = {8,4,10,3,12,1};
        System.out.println("input3 " + Arrays.toString(nums));
        System.out.println("input3 Result " + Arrays.toString(sortArray(nums)));
    }
}
