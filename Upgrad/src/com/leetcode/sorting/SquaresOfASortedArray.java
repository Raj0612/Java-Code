package com.leetcode.sorting;

import java.util.Arrays;

//Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
public class SquaresOfASortedArray {

    public static void main(String[] args) {
        //input1();
        input2();
    }

    //Two Pointers high to low Runtime: 1 ms, faster than 100.00%, Memory Usage: 41.1 MB, less than 9.24% of Java online submissions
    public static int[] sortedSquares(int[] nums) {
        System.out.println("sortedSquares nums " + Arrays.toString(nums));
        int n = nums.length;
        int[] result = new int[n];
        int index = n - 1;
        int l = 0, r = n - 1;
        while (l <= r) {
            System.out.println(nums[l] + " Absolute: " + Math.abs(nums[l]) +  "::" + nums[r] + " Absolute: " +  Math.abs(nums[r]));
            if (Math.abs(nums[l]) < Math.abs(nums[r])) {
                result[index--] = nums[r] * nums[r];
                r--;
            }else {
                result[index--] = nums[l] * nums[l];
                l++;
            }
            System.out.println("sortedSquares nums " + Arrays.toString(result));
            System.out.println();
        }
        System.out.println("sortedSquares result " + Arrays.toString(result));
        return result;
    }

    //Two Pointers low to high Runtime: 1 ms, faster than 100.00%, Memory Usage: 41.1 MB, less than 9.24% of Java online submissions
    public static int[] sortedSquares1(int[] nums) {
        System.out.println("sortedSquares1 nums " + Arrays.toString(nums));
        int n = nums.length;
        int small = 0;
        for (int i = 0; i < n; i++) {
            if (Math.abs(nums[i]) < Math.abs(nums[small])) {
                small = i;
            }
        }
        System.out.println("sortedSquares1 small " + small);
        int[] result = new int[n];
        int index = 0;
        int l = small, r = small + 1;
        while (l >= 0 || r < n) {
            if (l < 0 || r < n && Math.abs(nums[l]) > Math.abs(nums[r])) {
                result[index++] = nums[r] * nums[r];
                r++;
            } else {
                result[index++] = nums[l] * nums[l];
                l--;
            }
        }
        System.out.println("sortedSquares1 result " + Arrays.toString(result));
        return result;
    }
    public static int[] sortedSquares2(int[] nums) {
        int N = nums.length;
        int[] result = new int[N];
        for (int i = 0; i < N; ++i) {
            result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result); //O(n*logn)
        return result;
    }

    public static int[] sortedSquaresUpgrad(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int i= 0;
        while(i< n && nums[i] < 0){
            i++;
        }
        i--;

        int j = i+1;
        int k=0;

        while(i>=0 && j<n){
            if(nums[i]* nums[i] < nums[j]* nums[j]){
                result[k++] = nums[i]* nums[i];
                i--;
            }else{
                result[k++] = nums[j]* nums[j];
                j++;
            }
        }
//        System.out.println("Initial result " + Arrays.toString(result));
//        System.out.println("i " + i + " j " + j + " k " + k);
        while(i >=0){
            result[k] = nums[i] * nums[i];
            k++; i--;
        }

        while(j < n){
            result[k] = nums[j] * nums[j];
            k++; j++;
        }

        return result;
    }
    static void input1(){
        int nums[] = {-4,-1,0,3,10};
        System.out.println("input1 nums " + Arrays.toString(nums));
       // sortedSquares(nums);
      //  System.out.println("input1 sortedSquares result " + Arrays.toString(sortedSquares(nums)));
        //System.out.println("input1 sortedSquares1 result " + Arrays.toString(sortedSquares1(nums)));
        System.out.println("input1 sortedSquaresUpgrad result " + Arrays.toString(sortedSquaresUpgrad(nums)));
    }

    static void input2(){
        int nums[] = {-7,-3,2,3,11};
        System.out.println("input2 nums " + Arrays.toString(nums));
       // sortedSquares(nums);
        //sortedSquares1(nums);
        //  System.out.println("input2 sortedSquares result " + Arrays.toString(sortedSquares(nums)));
        //System.out.println("input2 sortedSquares1 result " + Arrays.toString(sortedSquares1(nums)));
        System.out.println("input2 sortedSquaresUpgrad result " + Arrays.toString(sortedSquaresUpgrad(nums)));
    }
}
