package com.leetcode.arrays.slidingwindow;

//Given an array of positive integers nums and a positive integer target, return the minimal length of a
//subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

import java.util.Arrays;

/*Example1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example2:
Input: target = 4, nums = [1,4,4]
Output: 1
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        input1();
        input2();
        input3();
        input4();
    }

    //O(n)
    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum = sum - nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    //O(n^3)
    public static int minSubArrayLenByBruteForce(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        //O(n)
        for (int i = 0; i < n; i++) {
            //O(n)
            for (int j = i; j < n; j++) {
                int sum = 0;
                //O(n)
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum >= target) {
                    ans = Math.min(ans, (j - i + 1));
                    break;
                }
            }
        }
        if (ans == Integer.MAX_VALUE){
            return 0;
        }else{
            return ans;
        }
    }


    public static int minSubArrayLenByBruteForceByMe(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        //O(n)
        for (int i = 0; i < n; i++) {
            //O(n)
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                //O(n)
                if (sum >= target) {
                    ans = Math.min(ans, (j - i + 1));
                    break;
                }
            }
        }
        if (ans == Integer.MAX_VALUE){
            return 0;
        }else{
            return ans;
        }
    }
    static void input1(){
        int nums[] = {2,3,1,2,4,3};
        int target = 7;
        System.out.println("input1 " + Arrays.toString(nums));
        System.out.println("input1 minSubArrayLen " + minSubArrayLen(target,nums));
        System.out.println("input1 minSubArrayLenByBruteForce " + minSubArrayLenByBruteForce(target,nums));
        System.out.println("input1 minSubArrayLenByBruteForceByMe " + minSubArrayLenByBruteForceByMe(target,nums));
    }


    static void input2(){

        int nums[] = {1,4,4};
        int target = 1;
        System.out.println("input2 " + Arrays.toString(nums));
        System.out.println("input2 minSubArrayLen " + minSubArrayLen(target,nums));
        System.out.println("input2 minSubArrayLenByBruteForce " + minSubArrayLenByBruteForce(target,nums));
        System.out.println("input2 minSubArrayLenByBruteForceByMe " + minSubArrayLenByBruteForceByMe(target,nums));
    }
    static void input3(){
        int nums[] = {1,1,1,1,1,1,1,1,1};
        int target = 10;
        System.out.println("input3 " + Arrays.toString(nums));
        System.out.println("input3 minSubArrayLen " + minSubArrayLen(target,nums));
        System.out.println("input3 minSubArrayLenByBruteForce " + minSubArrayLenByBruteForce(target,nums));
        System.out.println("input3 minSubArrayLenByBruteForceByMe " + minSubArrayLenByBruteForceByMe(target,nums));
    }

    static void input4(){
        int nums[] = {1, 2, 3, 4, 5, 6};
        int target = 7;
        System.out.println("input4 " + Arrays.toString(nums));
        System.out.println("input4 minSubArrayLen " + minSubArrayLen(target,nums));
        System.out.println("input4 minSubArrayLenByBruteForce " + minSubArrayLenByBruteForce(target,nums));
        System.out.println("input4 minSubArrayLenByBruteForceByMe " + minSubArrayLenByBruteForceByMe(target,nums));
    }
}
