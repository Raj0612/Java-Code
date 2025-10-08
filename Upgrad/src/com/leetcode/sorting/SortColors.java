package com.leetcode.sorting;


import java.util.Arrays;

//Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//You must solve this problem without using the library's sort function.
/*
Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]
 */
public class SortColors {

    public static void main(String[] args) {
        input1();
        //input2();
        //input3();
    }

    //O(n) where n is the size of the array

    public static void sortColors(int[] nums){
        int i = 0, j = nums.length - 1, k = 0;
        while( k <= j ) {
            System.out.println("nums " + Arrays.toString(nums) + " i " +  i + " j " + j + " k " + k);
            if( nums[k] == 0 )  {
                swap(nums, i, k);
                i++;k++;
            } else if( nums[k] == 2) {
                swap(nums, j, k);
                j--;
            }  else {
                k++;
            }
        }
    }

    public static void sortColors1(int[] nums){
        int i = 0, j = nums.length - 1, k = 0;
        while( k <= j ) {
            if( nums[k] == 0 )  {
                swap(nums, i, k);
                i++;k++;
            }
            else if( nums[k] == 2) {
                swap(nums, j, k);
                j--;

            }
            else {
                k++;
            }
        }
    }


    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int sortColorsByUpgrad(int[] nums, int s, int e, int val) { // divide the arr in 2 parts

        int i = s;
        int j = e;

        while (i < j){
            while (i < j && (nums[i] == val)){ // type == val
                i++;
            }

            while (j > i && (nums[j] != val)){ // type == non-val
                j--;
            }
            System.out.println("sortColorsByUpgrad i " + i + " j  " + j);
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++; j--;

        }
        System.out.println("sortColorsByUpgrad  nums " +  Arrays.toString(nums) + " i " + i);
        if(i>0 && nums[i-1]!=val) return i-1;
        else if(i -1 >0 && nums[i-2]!=val) return i-2;
        else if(i< nums.length && nums[i] == val) return i+1;

        System.out.println("sortColorsByUpgrad i " + i);
        return i;
    }

    public static void sortColorsByUpgrad(int[] nums) {

        int idx = sortColorsByUpgrad(nums, 0, nums.length-1, 0); // val == 0

        System.out.println("sortColorsByUpgrad idx " + idx );

        sortColorsByUpgrad(nums, idx, nums.length-1, 1); // val == 1

        System.out.println("sortColorsByUpgrad " + Arrays.toString(nums));
    }

    public static void sortColorsByPartition(int[] nums) {
        int index = sortColorsByPartition(nums, 0, nums.length-1, 0); // val == 0
        System.out.println("srtColorsByPartition index " + index);

        sortColorsByPartition(nums, index, nums.length-1, 1); // val == 1
        System.out.println("sortColorsByPartition " + Arrays.toString(nums));
    }
    public static int sortColorsByPartition(int[] nums, int s, int e, int val) {

        int i =s;
        int j = e;
        System.out.println("srtColorsByPartition i " + i  + " j " + j);
        while(i<=j){
            if(nums[i]==val){
                i++;
            }else{
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            }
            System.out.println("srtColorsByPartition inside while " + Arrays.toString(nums));
        }
        System.out.println("srtColorsByPartition i " + i  + " Array " + Arrays.toString(nums));
        return i;
    }

    //Time : O(n)
    //Space : O(1)
    public static void sortColorsByBruteForce(int[] nums){
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i]== 0)
                c0++;
            else if(nums[i]==1)
                c1++;
            else if (nums[i] ==2)
                c2++;
        }
        System.out.println("c0 " + c0 + " c1 " + c1 + " c2 " + c2);
        for(int i=0; i<c0; i++)
            nums[i] = 0;

        for(int i=c0; i<c0+c1; i++)
            nums[i] = 1;

        for(int i=c0+c1; i<nums.length; i++)
            nums[i] = 2;

    }

    static void input1(){
      //  int nums[] = {2,0,2,1,1,0};
        int nums[] = {1,2,0,0,1,2};
        System.out.println("sortColorsByPartition input1 " + Arrays.toString(nums));
    //    sortColors(nums);
      //  sortColorsByPartition(nums);
       // System.out.println("sortColors input1 " + Arrays.toString(nums));

        //sortColorsByUpgrad(nums);
        sortColorsByPartition(nums);
    }

    static void input2(){
        int nums[] = {2,0,1};
        System.out.println("sortColorsByPartition input2 " + Arrays.toString(nums));
       // sortColors(nums);
        //sortColorsByPartition(nums);
        //System.out.println("sortColors input2 " + Arrays.toString(nums));

        sortColorsByUpgrad(nums);
     //   sortColorsByBruteForce(nums);
    }

    static void input3(){
        int nums[] = {1,0,2,1,1,0};
        sortColors(nums);

        //sortColorsByPartition(nums);
        //System.out.println("sortColors input3 " + Arrays.toString(nums));
        System.out.println("sortColorsByPartition input3 " + Arrays.toString(nums));
         sortColorsByUpgrad(nums);
        sortColorsByBruteForce(nums);
    }
}
