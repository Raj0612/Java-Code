package com.leetcode.sorting;

import java.util.Arrays;

//You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//Merge nums1 and nums2 into a single array sorted in non-decreasing order
/*The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n,
        where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.*/

//1,2,3,0,0,0
//2,5,6
public class MergeSortedArray {

    public static void main(String[] args) {
        input1();
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.out.println("nums1 " + Arrays.toString(nums1));
        System.out.println("nums2 " + Arrays.toString(nums2));
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.out.println("nums1 " + Arrays.toString(nums1));
        System.out.println("nums2 " + Arrays.toString(nums2));
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i>0 && j>0) {
            if (nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }
//        while (j >= 0) {
//            if (i >= 0 && nums1[i] > nums2[j])
//                nums1[k--] = nums1[i--];
//            else
//                nums1[k--] = nums2[j--];
//        }
    }

    public static void mergeUpgrad(int[] nums1, int m, int[] nums2, int n) {
        int result[] = new int[m+n];
        int i = 0; int j =0; int k=0 ;

        while (i<m && j<n) {
            if (nums1[i] < nums2[j])
                result[k++] = nums1[i++];
            else
                result[k++] = nums2[j++];
        }

        while(j<n){
            result[k++] = nums2[j++];
        }

        while (i < m) {
            result[k++] = nums1[i++];
        }

        System.out.println("mergeUpgrad result " + Arrays.toString(result));
    }

    static void input1(){
        int[] nums1={1,2,3,0,0,0, 0};
        int[] nums2={2,5,4,6, };
        int m =3;
        int n =4;
        merge(nums1, m, nums2, n);
      //  mergeUpgrad(nums1, m, nums2, n);
        System.out.println("merge1 nums1 " + Arrays.toString(nums1));

    }

}
