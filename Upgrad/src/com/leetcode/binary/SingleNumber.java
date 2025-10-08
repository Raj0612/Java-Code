package com.leetcode.binary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//You must implement a solution with a linear runtime complexity and use only constant extra space.
/*
Input: nums = [2,2,1]
Output: 1

Input: nums = [4,1,2,1,2]
Output: 4
 */
public class SingleNumber {
    public static void main(String[] args) {
        input1();
        input2();
    }
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int x : nums) {
            res = res ^ x;
            System.out.println("singleNumber x: " + x + " res: " + res );
        }
        return res;
    }

    public static int singleNumberNonOptimized(int[] nums) {
        boolean flag = false;
        for(int i=0; i<nums.length; i++){
            flag = false;
            for(int j=0; j<i; j++){
                if(nums[i] == nums[j]){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                for(int j =i+1; j<nums.length; j++){
                    if(nums[i] == nums[j]){
                        flag = true;
                        break;
                    }
                }
            }

            if(!flag)
                return nums[i];
        }
        return 0;
    }

    public static int singleNumberNonOptimized1(int[] nums) {
        int len = nums.length;
        boolean isTwice = false;
        for (int i=0; i < len; i++) {
            isTwice = false;
            for (int j=0; j<len; j++) {
                if (isTwice)
                    break;
                if (i != j)
                    if(nums[i] == nums[j])
                        isTwice = true;
            }
            if(!isTwice)
                return nums[i];
        }
        return nums[len - 1];
    }

    public static int singleNumberUsingHashMap(int[] numbers) {
        Map<Integer, Boolean> map = new HashMap();
        for (int number: numbers) {
            map.put(number, !map.getOrDefault(number, false));
        }
        System.out.println("singleNumberUsingHashMap map " + map);
        for (Map.Entry<Integer, Boolean> entry: map.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
        return Integer.MIN_VALUE;
    }
        static void input1(){
        int nums[] = {2,2,1};
        System.out.println("input1 singleNumber " + Arrays.toString(nums));
        System.out.println("input1 singleNumber " +singleNumber(nums));
        System.out.println("input1 singleNumberNonOptimized " +singleNumberNonOptimized(nums));
        System.out.println("input1 singleNumberUsingHashMap " +singleNumberUsingHashMap(nums));
    }

    static void input2(){
        int nums[] = {4,1,2,1,2};
        System.out.println();
        System.out.println("input2 singleNumber " + Arrays.toString(nums));
        System.out.println("input2 singleNumber " +singleNumber(nums));
        System.out.println("input2 singleNumberNonOptimized " +singleNumberNonOptimized(nums));
        System.out.println("input2 singleNumberUsingHashMap " +singleNumberUsingHashMap(nums));
    }
}
