package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

//Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
//The solution set must not contain duplicate subsets. Return the solution in any order.

/*
Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
 */
public class SubsetsII {
    static List<List<Integer>> subsets = null;
    private static int[] numbers;
    public static void main(String[] args) {
        input1();
        input2();
    }

    static void input1(){
        int[] nums ={1,2,2};
        System.out.println("input1 subsetsWithDup " + subsetsWithDup(nums));
    }

    static void input2(){
        int[] nums ={0};
        System.out.println("input2 subsetsWithDup " + subsetsWithDup(nums));
    }
    public static  List<List<Integer>> subsetsWithDup(int[] nums){
        subsets = new ArrayList<>();
        numbers = nums;
        backtrack(0, new ArrayList<>());
        return subsets;
    }
    private static void backtrack(int index, List<Integer> currentSubset) {
        subsets.add(new ArrayList<>(currentSubset));

        for (int i = index; i < numbers.length; ++i) {
            if (i != index && numbers[i] == numbers[i - 1]) {
                continue; // If it's a duplicate, skip it
            }
            currentSubset.add(numbers[i]);
            backtrack(i + 1, currentSubset);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
