package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target.
// You may return the combinations in any order.
//The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
//The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
/*
Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []
 */
public class CombinationSum {
    private static List<List<Integer>>  combinations = new ArrayList<>();
    private static List<Integer> currentCombination = new ArrayList<>();
    private static int[] candidateNumbers;
    public static void main(String[] args) {
        input1();
        input2();
        input3();
    }

    static void input1(){
        int[] candidates ={2,3,6,7};
        int target = 7;
        System.out.println("input1 " + (combinationSum(candidates, target)));
    }

    static void input2(){
        int[] candidates ={2,3,5};
        int target = 8;
        System.out.println("input2 " + combinationSum(candidates, target));
    }

    static void input3(){
        int[] candidates ={2};
        int target = 1;
        System.out.println("input3 " +  combinationSum(candidates, target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        candidateNumbers = candidates;
        backtrack(0, target);
        return combinations;
    }

    private static void backtrack(int startIndex, int remainingSum) {
        if (remainingSum == 0) {
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = startIndex; i < candidateNumbers.length; i++) {
            if (remainingSum - candidateNumbers[i] >= 0) {
                currentCombination.add(candidateNumbers[i]);
                backtrack(i, remainingSum - candidateNumbers[i]);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }

    private static void backtrack1(int startIndex, int remainingSum) {
        if (remainingSum == 0) {
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }
        if (startIndex >= candidateNumbers.length || remainingSum < candidateNumbers[startIndex]) {
            return;
        }
        backtrack1(startIndex + 1, remainingSum);

        currentCombination.add(candidateNumbers[startIndex]);
        backtrack1(startIndex, remainingSum - candidateNumbers[startIndex]);
        currentCombination.remove(currentCombination.size() - 1);
    }
}
