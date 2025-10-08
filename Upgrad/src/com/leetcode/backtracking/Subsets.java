package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
//Given an integer array nums of unique elements, return all possible subsets (the power set).
//The solution set must not contain duplicate subsets. Return the solution in any order.
/*
Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 */
public class Subsets {
    static List<List<Integer>> subsets = null;
    public static void main(String[] args) {
        input1();
        input2();
    }

    static List<List<Integer>> subsetsByUpgrad(int[] nums) {
        subsets = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();
        helper(0,nums, subset);
        return subsets;
    }

    static void helper(int i, int[] nums, ArrayList<Integer> subset ){
        if(i == nums.length){
            ArrayList<Integer> list = new ArrayList<>(subset);
            subsets.add(list);
            return;
        }
        //Not Pick
        helper(i+1, nums, subset);

        //Pick - Include
        subset.add(nums[i]);
        helper(i+1, nums, subset);
        subset.remove(subset.size()-1);
    }

    public static  List<List<Integer>> findSubsets(int[] nums){
        List<List<Integer>> subsets = new ArrayList<>();
        int n = nums.length;
        int totalSubsets = 1 << n; // 2^n subsets

        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            subsets.add(subset);
        }

        return subsets;
    }
    static void input1(){
        int[] nums ={1, 2,3};
        System.out.println("input1 subsets " + findSubsets(nums));
        System.out.println("input1 subsetsByUpgrad " + subsetsByUpgrad(nums));
    }

    static void input2(){
        int[] nums ={0};
        System.out.println("input2 subsets " + findSubsets(nums));
        System.out.println("input2 subsetsByUpgrad " + subsetsByUpgrad(nums));
    }
}
