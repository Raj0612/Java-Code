package com.leetcode.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
//Return any array that satisfies this condition.
/*
Example 1:
Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

Example 2:
Input: nums = [0]
Output: [0]
 */
public class SortAnArrayByParity {

    public static void main(String[] args) {
       // input1();
        input2();
    }

    public static int[] sortArrayByParity(int[] nums) {
        System.out.println();
        System.out.println("sortArrayByParity nums " + Arrays.toString(nums));
        int left = 0;
        int right = nums.length - 1;
        while(left < right ){
            if(nums[left] % 2 != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            } else {
                left++;
            }
        }
        System.out.println("sortArrayByParity nums final " + Arrays.toString(nums));
        return nums;
    }

    //Time : O(n)
    //Space: O(n)
    public static int[] sortAnArrayByParityBruteForce1(int[] nums){

        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if(nums[i]%2==0)
                even.add(nums[i]);
            else
                odd.add(nums[i]);
        }

        even.addAll(odd);

        int result[] = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            result[i] = even.get(i);
        }
        return result;
    }

    public static int[] sortAnArrayByParityBruteForce(int[] nums){
        int result[] = new int[nums.length];
        int p = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] % 2 == 0) {
                result[p] = nums[i];
                p++;
            }
        }
        for (int i = 0; i < nums.length; i++)
            if (nums[i] % 2 != 0)  {
                result[p] = nums[i];
                p++;
            }
        return result;
    }

    public static int[] sortAnArrayByParityBruteForce2(int[] nums){
        System.out.println();
        int odd_count = 0;
        int even_count =0;

        for(int i=0; i<nums.length; i++){
            if(nums[i]%2==0)
                even_count++;
            else
                odd_count++;
        }

        int i=0;
        int j=even_count;

        int result[] = new int[nums.length];
        for(int k=0; k<nums.length; k++){
            if(nums[k] % 2 ==0) {
                result[i] = nums[k];
                i++;
            } else{
                result[j] =nums[k];
                j++;
            }
        }
        return result;
    }
    static void input1(){
        int[] nums = {3,1,2,4};
        System.out.println("input1 " + Arrays.toString(nums));
        System.out.println("input1 sortArrayByParity Result" + Arrays.toString(sortArrayByParity(nums)));
        System.out.println("input1 sortAnArrayByParityBruteForce1 Result" + Arrays.toString(sortAnArrayByParityBruteForce1(nums)));
        System.out.println("input1 sortAnArrayByParityBruteForce2 Result" + Arrays.toString(sortAnArrayByParityBruteForce2(nums)));
        System.out.println("input1 sortAnArrayByParityBruteForce Result" + Arrays.toString(sortAnArrayByParityBruteForce(nums)));
    }

    static void input2(){
        int[] nums = {3,1,2,4, 5, 6, 8};
        System.out.println("input2 " + Arrays.toString(nums));
       // System.out.println("input2 sortArrayByParity Result" + Arrays.toString(sortArrayByParity(nums)));
       // System.out.println("input2 sortAnArrayByParityBruteForce1 Result" + Arrays.toString(sortAnArrayByParityBruteForce1(nums)));
        //System.out.println("input2 sortAnArrayByParityBruteForce2 Result" + Arrays.toString(sortAnArrayByParityBruteForce2(nums)));
       // System.out.println("input2 sortAnArrayByParityBruteForce Result" + Arrays.toString(sortAnArrayByParityBruteForce(nums)));
    }
}
