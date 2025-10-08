package com.leetcode.arrays;

import java.util.Arrays;

public class RotateAnArray {
    public static void main(String[] args) {
         //int[] nums = {1,2,3,4,5};
         int[] nums = {1,2,3,4,5, 6, 7};
         int k = 4;
         rotate(nums, k);
    }


    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        // Normalize the number of steps k to avoid extra rotations
        k %= n;
        System.out.println("rotate k " + k);

        // Reverse the entire array
        reverse(nums, 0, n - 1);
        System.out.println("After Reverse1 " + Arrays.toString(nums));

        // Reverse the first part (up to k elements)
        reverse(nums, 0, k - 1);
        System.out.println("After Reverse2 " + Arrays.toString(nums));

        // Reverse the second part (from k to the end of the array)
        reverse(nums, k, n - 1);
        System.out.println("After Reverse3 " + Arrays.toString(nums));
    }

    private static void reverse(int[] nums, int i, int j) {
        // Using two pointers approach, swap elements until pointers meet or cross
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            ++i;
            --j;
        }
    }
}
