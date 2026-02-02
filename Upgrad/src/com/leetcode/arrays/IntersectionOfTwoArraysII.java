package com.leetcode.arrays;
//Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays
// and you may return the result in any order.

import java.util.*;

/*
Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 */
public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
     //   input1();
        input2();
    }

    static void input1(){
        int[] nums1 = {1,2,2,1};
        int[] nums2 ={2, 2};
        System.out.println("input1 Result " + Arrays.toString(intersection(nums1, nums2)));
    }

    static void input2(){
        int[] nums1 = {4,9,9,5, 4};
        int[] nums2 ={9,4,9,8,4};
        System.out.println("input2 Result " + Arrays.toString(intersection(nums1, nums2)));
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numberCounts = new HashMap<>();
        for (int number : nums1) {
            numberCounts.put(number, numberCounts.getOrDefault(number, 0) + 1);
        }
        List<Integer> intersectionList = new ArrayList<>();
        for (int number : nums2) {
            if (numberCounts.getOrDefault(number, 0) > 0) {
                intersectionList.add(number);
                numberCounts.put(number, numberCounts.get(number) - 1);
            }
        }
        int[] result = new int[intersectionList.size()];
        for (int i = 0; i < result.length; ++i) {
            result[i] = intersectionList.get(i);
        }
        return result;
    }
}
