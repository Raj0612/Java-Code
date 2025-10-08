package com.practice;

import java.util.Arrays;

public class ContainsDuplicate {

    public static void main(String[] args) {

        int arr[] = {1,2,3,1};

        System.out.println("Result " + containsDuplicate(arr));
    }

    public static boolean containsDuplicate(int[] nums) {
        int i;
        Arrays.sort(nums);
        for(i=0;i<nums.length-1;i++) {
            if(nums[i]==nums[i+1])
                return true;
        }
        return false;
    }
}
