package com.leetcode.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
      //  input1();
        input2();
    }

    public static int[] sortArray(int[] nums){
        int n = nums.length;
        for(int i=0; i<n; i++){
            int min  = i;
            for(int j=i+1; j<n; j++){
                if(nums[j]<nums[min]){
                    min =j;
                }
            }
            if(min==i){
                continue;
            }
            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
            System.out.println("sortArray " + Arrays.toString(nums));
            System.out.println();
        }
        return  nums;
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
