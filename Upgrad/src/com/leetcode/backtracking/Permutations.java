package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
/*
Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]
 */
public class Permutations {
    public static void main(String[] args) {
        //input1();
        input2();
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, result);
        return result;
    }

    public static void helper(int start, int[]nums, List<List<Integer>> result){

        if(start==nums.length-1){
            ArrayList<Integer> list = new ArrayList<>();
            for(int num: nums){
                list.add(num);
            }
            result.add(list);
            return;
        }

        for(int i =start; i<nums.length; i++){
            swap(nums, i, start);
            helper (start+1, nums, result);
            swap(nums, i, start);
        }

    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static List<List<Integer>> upgradPermute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int[] permutation = new int[nums.length];
        upgradHelper(0, nums, permutation, result, set);
        return result;
    }
    public static void upgradHelper(int i, int[] nums ,int[] permutation, List<List<Integer>> result, HashSet<Integer> set){
        if (i == nums.length){
            ArrayList<Integer> list = new ArrayList<>();
            for(int k=0; k<permutation.length; k++){
                list.add(permutation[k]);
            }
            result.add(list);
            return;
        }

        for(int k=0; k<nums.length; k++){
            if(!set.contains(nums[k])){
                permutation[i] = nums[k];
                set.add(nums[k]);
                upgradHelper(i+1, nums, permutation, result, set);
                set.remove(nums[k]);
            }
        }
    }

    static void input1(){
        int arr[] = {1, 2, 3};
        //System.out.println("permute " + permute(arr));
        System.out.println("input1 permute " + upgradPermute(arr));
    }

    static void input2(){
        int arr[] = {1, 1, 2};
        //System.out.println("permute " + permute(arr));
        System.out.println("input2 permute " + upgradPermute(arr));
    }
}
