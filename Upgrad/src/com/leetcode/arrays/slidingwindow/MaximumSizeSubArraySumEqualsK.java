package com.leetcode.arrays.slidingwindow;

//Given an integer array nums and am integer k, return the maximum length of a subarray that sums to k. If there is not one return 0.
/*
Example 1:
Input: nums = [1, -1, 5, -2, 3],k =3
Output: 4
Explanation : The sub array [1, -1, 5, -2] sums to 3 and its the longest

Example 2:
Input: nums = [-2, -1, 2, 1],k =1
Output: 2
Explanation : The sub array [-1,  2] sums to 2 and its the longest
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubArraySumEqualsK {

    public static void main(String[] args) {
       // input1();
       // input2();
        input3();
    }

    public static int subarraySumByPrefixSum(int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>(); // sum → first index
        int sum = 0, maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                maxLen = i + 1; // subarray starts at 0
            }

            if (prefixMap.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - prefixMap.get(sum - k));
            }

            // only store first occurrence of prefix sum
            prefixMap.putIfAbsent(sum, i);
        }

        return maxLen;
    }

    public static int subarraySumByPrefixSum1(int[] nums, int k) {
        int prefixSum = 0;
        int logestSubArray = 0;
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if(prefixSum == k){
                logestSubArray = i + 1;
            }

            if(indices.containsKey(prefixSum - k)){
                logestSubArray = Math.max(logestSubArray, i - indices.get(prefixSum  - k));
            }

            if(!indices.containsKey(prefixSum)){
                indices.put(prefixSum, i);
            }

        }

        return logestSubArray;
    }
    public static int subarraySumByBruteForceNCube(int[] nums, int k) {
        int count = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int x = i; x <= j; x++) {
                    sum += nums[x];
                }
                if (sum == k) {
                    count++;
                    ans = Math.max(ans, (j - i + 1));
                }
            }
        }
        return ans;
    }


    public static int subarraySumByBruteForceNSquare(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    ans = Math.max(ans, (j - i + 1));
                }
            }
        }
        return ans;
    }

    public static int subarraySumByBruteForceNSquare1(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;

            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];

                if (currentSum == k) {
                    count++;
                }
            }
        }

        return count;
    }


    public static int maxSubArrayLen(int[] nums, int target) {
       // System.out.println("minSubArrayLen " + Arrays.toString(nums));
        if (nums == null || nums.length == 0)
            return 0;
        int maxLen = Integer.MIN_VALUE;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            if(sum == target){
                maxLen = Math.max(maxLen, right - left + 1);
            }
            while (sum >= target) {
                maxLen = Math.max(maxLen, right - left + 1);
                sum -= nums[left++];
            }
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
    static void input1(){
        int nums[] = {1,-1,5,-2,3};
        int k =3;
        System.out.println("input1 " + Arrays.toString(nums) + " k "  + k);
        System.out.println("input1 subarraySumByBruteForceNCube " + subarraySumByBruteForceNCube(nums, k));
      //  System.out.println("input1 maxSubArrayLen " + maxSubArrayLen(nums, k));
        System.out.println("input1 subarraySumByPrefixSum " + subarraySumByPrefixSum(nums, k));
        System.out.println("input1 subarraySumByBruteForceNSquare " + subarraySumByBruteForceNSquare(nums, k));
        System.out.println("input1 subarraySumByBruteForceNSquare1 " + subarraySumByBruteForceNSquare1(nums, k));
        System.out.println("input1 subarraySumByPrefixSum1 " + subarraySumByPrefixSum1(nums, k));
    }


    static void input2(){
        int nums[] = {-2, -1, 2, 1};
        int k =1;
        System.out.println("input2 " + Arrays.toString(nums) + " k "  + k);
        System.out.println("input2 subarraySumByBruteForceNCube " + subarraySumByBruteForceNCube(nums, k));
        System.out.println("input2 subarraySumByBruteForceNSquare " + subarraySumByBruteForceNSquare(nums, k));
        System.out.println("input2 subarraySumByBruteForceNSquare1 " + subarraySumByBruteForceNSquare1(nums, k));
      //  System.out.println("input2 maxSubArrayLen " + maxSubArrayLen(nums, k));
        System.out.println("input2 subarraySumByPrefixSum " + subarraySumByPrefixSum(nums, k));
        System.out.println("input2 subarraySumByPrefixSum1 " + subarraySumByPrefixSum1(nums, k));
    }

    static void input3(){
        int nums[] = {1,2,-4,4,5,-2,-3};
        int k =3;
        System.out.println("input3 " + Arrays.toString(nums) + " k "  + k);
        System.out.println("input3 subarraySumByBruteForceNCube " + subarraySumByBruteForceNCube(nums, k));
        System.out.println("input3 subarraySumByBruteForceNSquare " + subarraySumByBruteForceNSquare(nums, k));
        System.out.println("input3 subarraySumByBruteForceNSquare1 " + subarraySumByBruteForceNSquare1(nums, k));
        //  System.out.println("input2 maxSubArrayLen " + maxSubArrayLen(nums, k));
        System.out.println("input3 subarraySumByPrefixSum " + subarraySumByPrefixSum(nums, k));
        System.out.println("input3 subarraySumByPrefixSum1 " + subarraySumByPrefixSum1(nums, k));
    }
}
