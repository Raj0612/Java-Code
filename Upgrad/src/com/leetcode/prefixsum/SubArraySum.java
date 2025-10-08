package com.leetcode.prefixsum;
//Given an array of integers and a target sum, return the start and end index of the subarray that adds up to the target.
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

    public static void main(String[] args) {
        input1();
    }

    static void input1(){
        int nums[] = {2, 4, 1, 7, 3, 2, 1};
        int target = 10;
        System.out.println("input1 subarraySum " + Arrays.toString(subarraySum(nums, target)));
    }

    public static int[] subarraySum(int[] nums, int target) {
        Map<Integer, Integer> prefixMap = new HashMap<>(); // sum → index
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // Case 1: subarray from start
            if (sum == target) {
                return new int[]{0, i};
            }

            // Case 2: subarray in the middle
            if (prefixMap.containsKey(sum - target)) {
                return new int[]{prefixMap.get(sum - target) + 1, i};
            }

            // store prefix sum index
            prefixMap.putIfAbsent(sum, i);
        }
        return new int[]{-1, -1};
    }
}
