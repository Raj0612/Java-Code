package com.leetcode.zothers;
//Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.
//The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
/*
Example 1:
    Input: nums = [2,5,6,9,10]
    Output: 2
    Explanation:
    The smallest number in nums is 2.
    The largest number in nums is 10.
    The greatest common divisor of 2 and 10 is 2.

Example 2:
    Input: nums = [7,5,6,8,3]
    Output: 1
    Explanation:
    The smallest number in nums is 3.
    The largest number in nums is 8.
    The greatest common divisor of 3 and 8 is 1.
*/
public class GreatestCommonDivisor {

    public static void main(String[] args) {
       // int arr[] = {2,5,6,9,10};

        int arr[] = {12,20};

        System.out.println("findGreatestCommonDivisor " + findGreatestCommonDivisor(arr));

    }

    static int findGreatestCommonDivisor(int[] nums){

        int min = nums[0];
        int max = -1;
        int gcd = 1;
        for(int i=0;i<nums.length;i++)  {
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }

        System.out.println("Min " + min + " Max " + max);
        System.out.println("Result " + gcd(min, max));
        for(int i=2;i<=min;i++)  {
            if(min%i==0&&max%i==0)  {
                gcd=Math.max(gcd,i);
                //return i;
            }
        }
        return gcd;
    }

    static int gcd(int a, int b){
        for(int i=a; i>=0; i--){
            if((a%i==0) && (b%i==0))
                return  i;
        }
        return 1;
    }

    static int findSmallest(int[] arr){
        int ans = arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i]< ans){
                ans = arr[i];
            }
        }
        return  ans;
    }

    static int findLargest(int[] arr){
        int ans = arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i] > ans){
                ans = arr[i];
            }
        }
        return  ans;
    }
}
