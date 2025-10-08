package com.leetcode.prefixsum;

import java.util.*;

public class SubarraySumEqualsKAll {
    public static void main(String[] args) {
      //  input1();
        input2();
    }
    public static List<int[]> findAllSubarrays(int[] nums, int k) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> prefixMap = new HashMap<>();

        int sum = 0;
        prefixMap.put(0, new ArrayList<>(Arrays.asList(-1))); // prefix sum 0 before array starts

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (prefixMap.containsKey(sum - k)) {
                for (int startIdx : prefixMap.get(sum - k)) {
                    result.add(new int[]{startIdx + 1, i}); // subarray from startIdx+1 to i
                }
            }

            prefixMap.computeIfAbsent(sum, x -> new ArrayList<>()).add(i);
        }
        return result;
    }

    public static List<int[]> findAllSubarraysByBruteForce(int[] nums, int k) {
        List<int[]> result = new ArrayList<>();

        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) {
                    result.add(new int[]{start, end});
                }
            }
        }
        return result;
    }

    // Helper to print subarrays
    private static void printSubarrays(int[] nums, List<int[]> subarrays) {
        for (int[] range : subarrays) {
            int start = range[0], end = range[1];
            System.out.print("[");
            for (int i = start; i <= end; i++) {
                System.out.print(nums[i] + (i < end ? ", " : ""));
            }
            System.out.println("]  (indices: " + start + " to " + end + ")");
        }
    }

    static void input1(){
        int[] nums = {1, 2, 3, -2, 5};
        int k = 3;

        List<int[]> subarrays = findAllSubarrays(nums, k);
        printSubarrays(nums, subarrays);
        List<int[]> subarrays1 = findAllSubarraysByBruteForce(nums, k);
        printSubarrays(nums, subarrays1);
    }

    static void input2(){
        int[] nums = { 1, 2, -4, 4,5, -2 , -3};
        int k = 3;
        List<int[]> subarrays = findAllSubarrays(nums, k);
        printSubarrays(nums, subarrays);
      //  List<int[]> subarrays1 = findAllSubarraysByBruteForce(nums, k);
       // printSubarrays(nums, subarrays1);
    }

}
