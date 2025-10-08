package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
//Each number in candidates may only be used once in the combination.
// Note: The solution set must not contain duplicate combinations.
/*
Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[ [1,1,6], [1,2,5], [1,7], [2,6] ]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output:
[ [1,2,2], [5] ]
 */
public class CombinationSumII {
    private static List<List<Integer>> combinations = null;
    private static List<Integer> combination = new ArrayList<>();
    private static int[] sortedCandidates;
    public static void main(String[] args) {
        input1();
        input2();
    }

    static void input1(){
        int[] candidates ={10,1,2,7,6,1,5};
        int target = 8;
        System.out.println("input1 combinationSum2 " + (combinationSum2(candidates, target)));
    }

    static void input2(){
        int[] candidates ={2,5,2,1,2};
        int target = 5;
        System.out.println("input2 combinationSum2 " + combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        combinations = new ArrayList<>();
        sortedCandidates = candidates;
        Arrays.sort(sortedCandidates);
        backtrack(0, target);
        return combinations;
    }

    private static void backtrack(int startIndex, int remainingSum) {
        if (remainingSum == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        if (startIndex >= sortedCandidates.length || remainingSum < sortedCandidates[startIndex]) {
            return;
        }
        for (int i = startIndex; i < sortedCandidates.length; ++i) {
            // Skip duplicates to avoid redundant combinations.
            if (i > startIndex && sortedCandidates[i] == sortedCandidates[i - 1]) {
                continue;
            }

            combination.add(sortedCandidates[i]); // Add the candidate to the current combination.
            // Recursively call the method with the next index and the updated remaining sum.
            backtrack(i + 1, remainingSum - sortedCandidates[i]);

            combination.remove(combination.size() - 1); // Backtrack: remove the last added candidate to try other candidates.
        }
    }
}
