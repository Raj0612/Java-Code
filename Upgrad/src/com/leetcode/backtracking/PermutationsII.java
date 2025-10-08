package com.leetcode.backtracking;
//Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
/*
Example1:
Input: nums = [1,1,2]
Output:
[[1,1,2],
[1,2,1],
[2,1,1]]

Example2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public static void main(String[] args) {
        input1();
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
       // Arrays.sort(nums);
        permute(nums, new boolean[nums.length], new ArrayList<>(), ans);
        return ans;
    }

    public static void permute(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> ans){
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (used[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            used[i] = true;
            path.add(nums[i]);
             permute(nums, used, path, ans);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
    static void input1(){
        int arr[] = {1, 1, 2};
        System.out.println("permute " + permute(arr));
    }

    static void input2(){
        int arr[] = {1, 2, 3};
        System.out.println("permute " + permute(arr));
    }
}
