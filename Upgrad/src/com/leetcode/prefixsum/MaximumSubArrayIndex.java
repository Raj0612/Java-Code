package com.leetcode.prefixsum;

import java.util.Arrays;

public class MaximumSubArrayIndex {

    public static void main(String[] args) {
        input1();
    }

    public static int[] findMaxSubarray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < nums.length; i++) {
            if (currentSum + nums[i] < nums[i]) {
                currentSum = nums[i];
                tempStart = i;  // reset start
            } else {
                currentSum += nums[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        return new int[]{start, end, maxSum}; // return indices + max sum
    }

    static void input1(){
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("input1 findMaxSubarray: " + Arrays.toString(findMaxSubarray(nums)));
    }

}
