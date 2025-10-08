package com.leetcode.binarysearch;

import java.util.Arrays;

//Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//You must write an algorithm with O(log n) runtime complexity.
/*
Example 1:
        Input: nums = [1,3,5,6], target = 5
        Output: 2
Example 2:
        Input: nums = [1,3,5,6], target = 2
        Output: 1*/
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};

        int target =5;
        target = 2;
        target = 4;
        System.out.println("input " + Arrays.toString(nums));
       System.out.println("searchInsert " + searchInsert(nums, target));
        System.out.println("searchInsert1 " + searchInsert1(nums, target));
        //System.out.println("searchInsert2 " + searchInsert1(nums, target));
    }

    static int searchInsert(int[] nums, int target){

        int left = 0;
        int right = nums.length -1;
        System.out.println("searchInsert left  " + left + " right " + right + " mid " + (left+right)/2);
        while(left<right){
            int mid = (left+right)/2;

            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid +1;
            else
                right = mid;
            System.out.println("searchInsert left  " + left + " right " + right + " mid " + (left+right)/2);
        }
        if(nums[left] >= target)
            return left;
       else
           return left+1;
    }

    static int searchInsert1(int[] nums, int target){

        int left = 0;
        int right = nums.length -1;
        System.out.println("searchInsert1 left  " + left + " right " + right + " mid " + (left+right)/2);
        while(left<right){
            int mid = (left+right)/2;

            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid +1;


            if(nums[mid] > target){
                if(mid==1 || nums[mid-1] < target){
                    return mid;
                }
                right =mid -1;
            }

            System.out.println("searchInsert1 left  " + left + " right " + right + " mid " + (left+right)/2);
        }
        return  left;
    }

    static int searchInsert2(int[] nums, int target){

        int left = 0;
        int right = nums.length -1;
        System.out.println("searchInsert2 left  " + left + " right " + right + " mid " + (left+right)/2);
        while(left<right){
            int mid = (left+right)/2;

            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid +1;
            if(nums[mid] > target){
                right =mid -1;
            }

            System.out.println("searchInsert2 last left  " + left + " right " + right + " mid " + mid);
        }
        return  left;
    }
}
