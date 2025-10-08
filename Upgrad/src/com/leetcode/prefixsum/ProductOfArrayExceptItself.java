package com.leetcode.prefixsum;

//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//You must write an algorithm that runs in O(n) time and without using the division operation.

import java.util.Arrays;

/*
Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */
public class ProductOfArrayExceptItself {

    public static void main(String[] args) {
        input1();
        System.out.println();
        input2();
    }

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int leftProduct = 1;
        for (int i = 0; i < length; i++) {
            result[i] = leftProduct;
            leftProduct = leftProduct * nums[i];
        }
        System.out.println("productExceptSelf After Left " +Arrays.toString(result));
        int rightProduct = 1;
        for (int i = length - 1; i >= 0; i--) {
            result[i] = result[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }
        System.out.println("productExceptSelf After Right " +Arrays.toString(result));
        return result;
    }

    static void input1(){
        int[] nums ={1,2,3,4};
        System.out.println("input1 " + Arrays.toString(nums));
        System.out.println("input1 productExceptSelf " + Arrays.toString(productExceptSelf(nums)));
    }

    static void input2(){
        int[] nums ={-1,1,0,-3,3};
        System.out.println("input2 " + Arrays.toString(nums));
        System.out.println("input2 productExceptSelf"  + Arrays.toString(productExceptSelf(nums)));
    }
}
