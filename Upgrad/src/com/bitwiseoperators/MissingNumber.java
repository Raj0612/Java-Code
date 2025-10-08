package com.bitwiseoperators;

import java.util.HashSet;
import java.util.Iterator;
//Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

/*
Example 1:
Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:
Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

Example 3:
Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 */
public class MissingNumber {

    public static void main(String[] args) {
      //  int[] array = {3,0,1};
        //int[] array = {2,4,5};
        //int[] array = {2,4,3};
        int[] array = {2,3,4};
       // int[] array = {1,2,3};
     //   System.out.println("Missing Num in Array by Bitwise: " +  missingNumberByBitwise(array));
      //  System.out.println("Missing Num in Array by Bitwise1: " +  missingNumberByBitwise1(array));
       // System.out.println("Missing Num in Array by Compare: " +  missingNumberByCompare(array));
        System.out.println("Missing Num in Array by Sum: " +  missingNumberBySum(array));
    }

    public static int missingNumberByBitwise(int[] nums) {
        int res = 0;
        for (int x : nums) {
            System.out.print(res + "^" +x + ": ");
            res ^= x;
            System.out.println(res);
        }
        return res;
    }

    public static int missingNumberByBitwise1(int[] nums) {
        int x = nums[0];
        for (int i=1; i<nums.length; i++) {
            System.out.print(x + "^" +nums[i] + ": ");
            x ^= nums[i];
            System.out.println(x);
        }
        System.out.println();
        int y =0;
        for (int i=1; i<=nums.length; i++) {
            System.out.print(y + "^" +i + ": ");
            y ^= i;
            System.out.println(y);
        }
        return x^y;
    }

    public static int missingNumberByCompare(int[] nums) {
        int n = nums.length;

        for(int i=0;i<n;i++){
            //int num = nums[i];
            if(isMissing(i, nums))
                return i;
        }
        return n;
    }

   static boolean isMissing(int num, int[] nums){
        for(int i=0; i<nums.length; i++){
            if(num == nums[i])
                return false;
        }
        return true;
    }

    static int missingNumberBySum(int[] nums){
        int arrayLen = nums.length;
        int totalSum = (arrayLen *(arrayLen+1))/2;
        int arraySum = 0;
        for(int i=0; i<nums.length; i++){
            arraySum += nums[i];
        }
        return (totalSum-arraySum);
    }
}
