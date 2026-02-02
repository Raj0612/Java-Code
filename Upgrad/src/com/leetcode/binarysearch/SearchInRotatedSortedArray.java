package com.leetcode.binarysearch;
//There is an integer array nums sorted in ascending order (with distinct values).
//Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the
// resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
// For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
//Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
//You must write an algorithm with O(log n) runtime complexity.

import java.util.Arrays;

/*Example 1:
        Input: nums = [4,5,6,7,0,1,2], target = 0
        Output: 4
Example 2:
        Input: nums = [4,5,6,7,0,1,2], target = 3
        Output: -1*/
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
     //   input1();
      // input2();
      input3();
   //    input4();
    }

    public static int search(int[] nums, int target) {
        int left=0;
        int right = nums.length -1;
        System.out.println("search left " + left + " right " + right + " mid " + (left+right)/2 + " target: " + target);
        while (left <= right){

            int mid = left +(right-left)/2;

            if(nums[mid] == target) {
                return mid;
            }
            System.out.println("search inside left " + left + " right " + right + " mid " + mid + " target: " + target);
            // Check if left half is sorted
            if(nums[left] <= nums[mid]){
                // Target lies in left sorted half
                if(nums[left] <= target && target < nums[mid]){
                    right = mid -1;
                }else{
                    left = mid +1;
                }
            }else{
                // Otherwise right half must be sorted
                if(nums[mid] < target && target <= nums[right]){
                    left = mid +1;
                }else {
                    right = mid -1;
                }
            }
            //System.out.println("search left " + left + " right " + right + " mid " + (left+right)/2);
        }
    return -1;
    }


    static void input1(){
        int nums[] = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println("input1 " + Arrays.toString(nums));
        System.out.println("input1 " + search(nums, target));
    }

    static void input2(){
        System.out.println();
        int nums[] = {4,5,6,7,0,1,2};
        int target = 3;
        System.out.println("input2 " + Arrays.toString(nums));
        System.out.println("input2 " + search(nums, target));
    }


    static void input3(){
        System.out.println();
        int nums[] = {6,7,0,1,2,3,4,5};
        int target = 0;
        System.out.println("input3 " + Arrays.toString(nums));
        System.out.println("input3 " + search(nums, target));
    }

    static void input4(){
        System.out.println();
        int nums[] = {3, 4, 5, 6, 7, 8, 0,1,2};
        int target = 8;
        System.out.println("input4 " + Arrays.toString(nums));
        System.out.println("input4 " + search(nums, target));
    }
}
