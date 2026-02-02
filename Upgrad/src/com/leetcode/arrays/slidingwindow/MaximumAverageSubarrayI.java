package com.leetcode.arrays.slidingwindow;
//You are given an integer array nums consisting of n elements, and an integer k.
//Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
// Any answer with a calculation error less than 10-5 will be accepted.

/*Example1:
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
*/
public class MaximumAverageSubarrayI {

    public static void main(String[] args) {
        input1();
        input2();
    }

    public static double findMaxAverage(int[] nums, int k) {

        double max_sum, curr_sum = 0;
        //O(k)
        for(int i=0; i<k; i++){
            curr_sum = curr_sum + nums[i];
        }
        max_sum = curr_sum;
        System.out.println("max_sum " + max_sum + " curr_sum " + curr_sum);
        //O(n-k)
        for(int i=k; i< nums.length; i++){
            curr_sum = curr_sum + nums[i] ;
            curr_sum = curr_sum  - nums[i-k];
            max_sum = Math.max(max_sum, curr_sum);
        }
       double ans = max_sum/k;
       return ans;
    }

    static void input1(){
        int nums[] = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println("input1 findMaxAverage " + findMaxAverage(nums,k));
    }

    static void input2(){
        int nums[] = {1, 99, 3, 42, 1, 63, 1, 100};
        int k = 3;
        System.out.println("input2 findMaxAverage " + findMaxAverage(nums,k));
    }

}
