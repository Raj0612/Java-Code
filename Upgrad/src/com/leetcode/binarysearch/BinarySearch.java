package com.leetcode.binarysearch;

//Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums.
// If target exists, then return its index. Otherwise, return -1.

//You must write an algorithm with O(log n) runtime complexity.

/*Example 1:
        Input: nums = [-1,0,3,5,9,12], target = 9
        Output: 4
        Explanation: 9 exists in nums and its index is 4

Example 2:
        Input: nums = [-1,0,3,5,9,12], target = 2
        Output: -1
        Explanation: 2 does not exist in nums so return -1*/

public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = {-1,0,3,5,9,12, 14};
        int target = 9;
        //testMiddle();
       // System.out.println("binarySearch " + binarySearch(nums, target));
        System.out.println("binarySearchByRecursion " + binarySearchByRecursion(nums, 0, nums.length-1, target));
    }

    static int binarySearchByRecursion(int arr[], int left, int right, int target){
        if (left <= right /* && left <= arr.length - 1*/) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                return binarySearchByRecursion(arr, left, mid - 1, target);
            else
                 return binarySearchByRecursion(arr, mid + 1, right, target);
        }
        return -1;
    }

    //Time O(log n)
    static int binarySearch(int[] nums, int target){

        int left = 0;
        int right= nums.length -1;

        while(left<=right){
            int mid = (left+right)/2;

            if(nums[mid] ==target)
                return  mid;
            else if(nums[mid] < target)
                left= mid +1;
            else
                right= mid -1;
        }
        return  -1;
    }


    static int linearSearch(int[] nums, int target){

        for(int i=0; i <nums.length; i++){
            if(nums[i] == target)
                return i;
        }
        return -1;
    }

    static void testMiddle(){
        int first = 0;
        int last = 5;

        System.out.println("Mid " + ((first+ last)/2));
    }
}
