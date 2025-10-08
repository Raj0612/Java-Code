package com.leetcode.zothers;

//You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
// To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored.
// nums2 has a length of n.

import java.util.Arrays;

/*
Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
* */
public class MergeSortedArray {

    public static void main(String[] args) {
        input1();
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0){
            if (i >= 0 && nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
    }

    //Time - llogl
    public static void mergeNonOptimized(int[] nums1, int m, int[] nums2, int n) {

        for(int i =m,  j=0; i<m+n; i++, j++){
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1); //l = m +n ,  (m+n)log(m+n)
    }

    //Time
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {

        int arr3[] = new int[m+n];
        int i= 0; int j =0 ; int k =0;

        while(i<m && j < n){
            if(nums1[i] < nums2[j]){
                arr3[k] = nums1[i++];
            }else{
                arr3[k] = nums2[j++];
            }
            k++;
        }

        while(i< m){
            arr3[k] = nums1[i++];
            k++;
        }

        while(j< n){
            arr3[k] = nums2[j++];
            k++;
        }

    }


     static void input1(){

        int nums1[] = {1,2,3,0,0,0};
        int nums2[] = {2,5,6};
        int m = 3;
        int n =3;

         merge(nums1, m, nums2, 3);

    }
}
