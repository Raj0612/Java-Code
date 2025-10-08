package com.leetcode.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
      //  input1();
        input2();
    }
    public static int[] sortArray(int[   ] nums) {
        int n = nums.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (nums[j - 1] > nums[j]) {
                    temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
            System.out.println("sortArray i " + i  + " Array: " + Arrays.toString(nums));
            System.out.println();
        }
        return nums;
    }

    public static int[] sortArrayUpgrad(int[] nums) {
        int n = nums.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < (n - 1- i); j++) {
                if (nums[j] > nums[j+1]) {
                    flag = true;
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    System.out.println("sortArray "+ Arrays.toString(nums));
                }
            }
            if(!flag) break;
            System.out.println("sortArray  i: " + i + " res " + Arrays.toString(nums));
            System.out.println();
        }
        return nums;
    }

    static void bubbleSort(int arr[]){
        int n  = arr.length;;
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped by inner loop, then break
            if (swapped == false)
                break;
        }
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
}
