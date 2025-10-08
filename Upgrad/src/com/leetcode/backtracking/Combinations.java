package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

//Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
//You may return the answer in any order.
/*
Example 1:
Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

Example 2:
Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
 */
public class Combinations {
    static List<List<Integer>> subsets = null;
    public static void main(String[] args) {
        input1();
        input2();
    }

    static List<List<Integer>> combine(int n, int k) {
        subsets = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();
        helper(1, n, k, subset);
        return subsets;
    }

    static void helper(int i, int n, int k, ArrayList<Integer> subset ){
        if(i == n+1){
            ArrayList<Integer> list = new ArrayList<>(subset);
            if(list.size()== k)
              subsets.add(list);
            return;
        }
        //Not Pick
        helper(i+1, n, k, subset);

        //Pick - Include
        subset.add(i);
        helper(i+1, n, k,subset);
        subset.remove(subset.size()-1);
    }

    static void input1(){
        int n = 4, k =2;
        System.out.println("input1 combine " + combine(n, k));
    }

    static void input2(){
        int n = 1, k =1 ;
        System.out.println("input2 combine " + combine(n , k));
    }
}


