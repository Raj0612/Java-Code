package com.leetcode.binarysearch;
//Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
//If target is not found in the array, return [-1, -1].
//You must write an algorithm with O(log n) runtime complexity.

import java.util.Arrays;

/*Example 1:
        Input: nums = [5,7,7,8,8,10], target = 8
        Output: [3,4]
Example 2:
        Input: nums = [5,7,7,8,8,10], target = 6
        Output: [-1,-1]
Example 3:
        Input: nums = [], target = 0
        Output: [-1,-1]
Example 4:
        Input: nums = [5,6,7,7,8,10], target = 8
        Output: [4,4]
Example 4:
        Input: nums = [5,7,7,7,7,8,8,10], target = 7
        Output: [1,4]*/



public class FindFirstAndLastPositionOfAnElement {

    public static void main(String[] args) {
        input1();
        input2();
    }

    static int first_occur(int[] nums , int target){
        int left = 0;
        int right = nums.length -1;
        System.out.println("first_occur left " + left + " right " + right + " mid " + (left+ (right-left)/2));
        while(left<=right){
            int mid = (left +(right-left)/2);

            if(nums[mid] == target){
                if(mid==0 || nums[mid-1]!=target)
                    return mid;
                else{
                    right = mid -1;
                }
            }else if(nums[mid]< target){
                left = mid + 1;
            }else{
                right= mid - 1;
            }
            System.out.println("first_occur last left " + left + " right " + right + " mid " + (left +(right-left)/2));
        }
        System.out.println();
        return -1;
    }

    static int last_occur(int[] nums , int target){
        int left = 1;
        int right = nums.length;
        System.out.println("last_occur left " + left + " right " + right + " mid " + (left+ (right-left)/2));
        while(left<=right){
            int mid = (left +(right-left)/2);

            if(nums[mid] == target){
                if(mid==nums.length || nums[mid+1]!=target)
                    return mid;
                else{
                    left = mid +1;
                }
            }else if(nums[mid]< target){
                left = mid + 1;
            }else{
                right= mid - 1;
            }
            System.out.println("last_occur last left " + left + " right " + right + " mid " + (left +(right-left)/2));
        }

        return -1;
    }
    public static int[] searchRange(int[] nums, int target) {

        int[] ans = new int[2];

        ans[0] = first_occur(nums, target);
        ans[1] = last_occur(nums, target);
        return ans;
    }

    public static int[] searchRangeByBruteForce(int[] nums, int target) {

        int res[] = new int[2];
        int first = -1;
        int last = -1;

        for(int i=0; i <nums.length; i++){
            if(nums[i] == target){
                if(first==-1)
                    first= i;

                last = i;
            }
        }

        res[0] = first;
        res[1] = last;
        return res;
    }

    static void input1(){
        int nums[] = {5,7,7,8,8,10};
        int target = 8;

        System.out.println("input1 " + Arrays.toString(searchRange(nums, target)));

    }
    static void input2(){
        int nums[] = {5,7,7,7,7,8,8,10};
        int target = 7;
        System.out.println("input2 " +  Arrays.toString(searchRange(nums, target)));
    }

    static void input3(){
        int nums[] = {5,6,7,7,8,10};
        int target = 8;
        System.out.println("input3 " +  Arrays.toString(searchRange(nums, target)));
    }
}
