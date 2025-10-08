package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
/*
Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        input1();
        input2();
    }

    static void input1(){
        int[] nums1 = {1,2,2,1};
        int[] nums2 ={2, 2};
        System.out.println("input1 Result " + Arrays.toString(intersection(nums1, nums2)));
    }

    static void input2(){
        int[] nums1 = {4,9,5};
        int[] nums2 ={9,4,9,8,4};
        System.out.println("input2 Result " + Arrays.toString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        boolean[] seen = new boolean[1001];
        for (int num : nums1) {
            seen[num] = true;
        }

        List<Integer> intersectionElements = new ArrayList<>();
        for (int num : nums2) {
            if (seen[num]) {
                intersectionElements.add(num);
                seen[num] = false;
            }
        }
        int[] result = new int[intersectionElements.size()];
        for (int i = 0; i < intersectionElements.size(); i++) {
            result[i] = intersectionElements.get(i);
        }
        return result;
    }
}
