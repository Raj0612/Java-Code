package com.leetcode.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
            input1();
           //input2();
    }

    static void mergeSort(int a[], int left, int right){
        if(left >=right)
            return;
        if (left < right){
            int mid = (left + right) / 2;
            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }

    //Time: O(m+n)
    static void merge(int nums[], int left, int mid, int right){
        //System.out.println("merge left: " + left +" mid: " + mid  + " end: " + end);
        //System.out.println("merge nums: " + Arrays.toString(nums));

        int i, j, k;
        int n1 = mid - left + 1;
        int n2 = right - mid;
       // System.out.println("merge n1: " +n1 + " n2: " + n2);
        int LeftArray[] = new int[n1];
        int RightArray[] = new int[n2];

        for (i = 0; i < n1; i++)
            LeftArray[i] = nums[left + i];
        for (j = 0; j < n2; j++)
            RightArray[j] = nums[mid + 1 + j];

       // System.out.println("merge LeftArray " + Arrays.toString(LeftArray));
        //System.out.println("merge RightArray " + Arrays.toString(RightArray));
        i = 0;
        j = 0;
        k = left;
        //System.out.println("merge i: " + i + " j: " + j + " k: " + k);
       // System.out.println("merge nums before while: " + Arrays.toString(nums) );
        while (i < n1 && j < n2){
            if(LeftArray[i] <= RightArray[j]){
                nums[k] = LeftArray[i];
                i++;
            }else{
                nums[k] = RightArray[j];
                j++;
            }
            k++;
          //  System.out.println("merge inside while nums: " + Arrays.toString(nums) );
           // System.out.println("merge inside while i: " + i + " j: " + j + " k: " + k);
        }

       // System.out.println("merge after while: " + Arrays.toString(nums) );
       // System.out.println("merge i: " + i + " j: " + j + " k: " + k + " n1: " +n1 + " n2: " + n2);
        while (i<n1){
            nums[k] = LeftArray[i];
            i++;
            k++;
        }
       // System.out.println("merge nums2: " + Arrays.toString(nums) );
        while (j<n2){
            nums[k] = RightArray[j];
            j++;
            k++;
        }
        //System.out.println("merge nums3: " + Arrays.toString(nums) );
       // System.out.println();
    }


    public static void input1(){
        int nums[] = { 12, 31, 25, 8, 32, 17, 40, 42 };
        System.out.println("input1 " + Arrays.toString(nums));
        int n = nums.length;
        mergeSort(nums, 0, n - 1);
        System.out.println("input1 Result " + Arrays.toString(nums));
    }

    public static void input2(){
        int nums[] = { 5,2,1,3};
        System.out.println("input2 " + Arrays.toString(nums));
        int n = nums.length;
        mergeSort(nums, 0, n - 1);
        System.out.println("input2 Result " + Arrays.toString(nums));
    }
}
