package com.leetcode.zothers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

//Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
/*
Example 1:
        Input: nums = [1,2,3,1]
        Output: true
        Explanation:
        The element 1 occurs at the indices 0 and 3.
*/

//Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
/*
Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums={1,2,3,1};
       // int[] nums={1,2,3,1,2,3};
        int k=3;
        System.out.println("containsDuplicate " + containsDuplicate(nums));
        System.out.println("containsNearbyDuplicate " + containsNearbyDuplicate(nums, k));
        System.out.println("containsDuplicateByList " + containsDuplicateByList(nums));
        System.out.println("containsDuplicateBySet " + containsDuplicateBySet(nums));
        System.out.println("containsDuplicateNotOptimized " + containsDuplicateNotOptimized(nums));
    }

    //O(n logn)
    public static boolean containsDuplicate(int[] nums) {
        int i;
        Arrays.sort(nums);
        for(i=0;i<nums.length-1;i++)  {
            if(nums[i]==nums[i+1])
                return true;
        }
        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k)  {
        for(int i=0;i<nums.length;i++)
            for(int j=i+1;j<nums.length && j<=i+k;j++) {
                if(nums[j]==nums[i])
                    return true;
            }
        return false;
    }

    public static boolean containsDuplicateByList(int[] nums)  {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            if (list.contains(nums[i]))
                return true;
            list.add(nums[i]);
        }
        return false;
    }

    public static boolean containsDuplicateBySet(int[] nums)  {
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            if (!hs.add(nums[i]))
                return true;
            hs.add(nums[i]);
        }
        return false;
    }

    public static boolean containsDuplicateNotOptimized(int[] nums)  {
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if(nums[i]==nums[j])
                    return true;
            }
        }
        return false;
    }

}
