package com.leetcode.sorting;

import java.util.Arrays;

public class DutchNationalFlag {
    public static void main(String[] args) {
        int arr[] = {1,2,0,1,0,2,2,1,0};
        System.out.println("Array " + Arrays.toString(arr));
        sortArray(arr);
        System.out.println("Result " + Arrays.toString(arr));
    }

    static void sortArray(int[] nums){
        int left= 0, mid = 0, right= nums.length-1;
        while (mid <= right) {
            if (nums[mid] == 0) {
              //  swap(nums[mid], nums[mid]);
                int temp = nums[mid];
                nums[mid] = nums[left];
                nums[left] = temp;
                left++;
                mid++;
            }
            else if (nums[mid] == 1) {
                mid++;
            }
            else if (nums[mid] == 2) {
                //swap(nums[mid], nums[right]);
                int temp = nums[mid];
                nums[mid] = nums[right];
                nums[right] = temp;
                right--;
            }
        }
    }
}
