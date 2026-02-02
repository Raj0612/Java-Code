package com.leetcode.prefixsum;
//Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
//A subarray is a contiguous non-empty sequence of elements within an array.
/*
        Example 1:
        Input: nums = [1,1,1], k = 2
        Output: 2

        Example 2:
        Input : nums [ 1, 2, -4, 4,5, -2 , -3, 6] k =3
        Output

        Example 3:
        Input: nums = [1,2,3], k = 3
        Output: 2
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class SubArraySumEqualsK {
    public static void main(String[] args) {
        //input1();
        input2();
      //  input3();
       // input4();
    }
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int subarraySum(int[] nums, int K) {
        HashMap <Integer, Integer> hash = new HashMap < > ();
        int count = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == K) {
                count++;
            }
            if (hash.get(sum - K) != null) {
                count += hash.get(sum - K);
            }
            if (hash.get(sum) != null) {
                hash.put(sum, hash.get(sum) + 1);
            } else {
                hash.put(sum, 1);
            }

        }
        System.out.println("hash " + hash);
        return count;
    }

    public static int subarraySumUpgrad(int[] nums, int k) {
        int count = 0, curr_sum =0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            curr_sum += nums[i];
            if(map.containsKey(curr_sum-k)){
                count =count + map.get(curr_sum-k);
            }

            if(map.containsKey(curr_sum))
                map.put(curr_sum, map.get(curr_sum)+1);
            else
                map.put(curr_sum, 1);

            System.out.println("subarraySum1 map " +map + " count: " + count);
            System.out.println();
        }
        return count;
    }

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int subarraySum2(int[] nums, int k) {
        System.out.println("subarraySum2 nums " + Arrays.toString(nums) + " k:" +k);
        int answer = 0, prefixSum = 0;
        Map<Integer, Integer> prefixSumsFrequency = new HashMap<>();
        prefixSumsFrequency.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            answer += prefixSumsFrequency.getOrDefault(prefixSum - k, 0);
           // System.out.println("subarraySum2 (prefixSum=k):" + (prefixSum-k) +" map value " + prefixSumsFrequency.getOrDefault(prefixSum - k, 0) + " answer " +answer);
            prefixSumsFrequency.put(prefixSum, prefixSumsFrequency.getOrDefault(prefixSum, 0) + 1);
           // System.out.println("subarraySum2 prefixSumsFrequency " +prefixSumsFrequency);
           // System.out.println();
        }
        return answer;
    }

    //Time-O(n*n) Space-O(1)
    public static int subarraySumNotOptimized(int[] nums, int k) {
        System.out.println("subarraySumNotOptimized nums " + Arrays.toString(nums) + " k:" +k);
        int n = nums.length;
        int count = 0;

        for(int i=0;i<n;i++){
            int sub_array_sum =0;
            for(int j=i; j<n; j++){
                sub_array_sum = sub_array_sum + nums[j];
                if(sub_array_sum ==k) {
                    count++;
                }
            }
        }
        return count;
    }

    static void input1(){
        int[] nums = { 1, 2, 3, 0 };
        int k = 3;
        System.out.println("input1 " + Arrays.toString(nums) + " k:" +k );
        System.out.println("input1 subarraySum: " + subarraySum(nums, k));
        System.out.println("******************************************");
        System.out.println("input1 subarraySumUpgrad: " + subarraySumUpgrad(nums, k));
        System.out.println("******************************************");
        System.out.println("input1 subarraySum2: " + subarraySum2(nums, k));
        System.out.println("******************************************");
        System.out.println("input1 subarraySumNotOptimized: " + subarraySumNotOptimized(nums, k));
    }

    static void input2(){
        System.out.println();
        int[] nums = { 1, 2, -4, 4,5, -2 , -3, 6};
        int k = 3;
        System.out.println("input2 " + Arrays.toString(nums) + " k:" +k);
       // System.out.println("input2 subarraySum " + subarraySum(nums, k));
        System.out.println("******************************************");
        System.out.println("input2 subarraySumUpgrad " + subarraySumUpgrad(nums, k));
        System.out.println("******************************************");
      //  System.out.println("input2 subarraySum2 " + subarraySum2(nums, k));
        System.out.println("******************************************");
       // System.out.println("input2 subarraySumNotOptimized " + subarraySumNotOptimized(nums, k));
    }

    static void input3(){
        System.out.println();
        int[] nums = { 1, 2, 3, 0, 0, 0};
        int k = 3;
        //System.out.println("subarraySum " + subarraySum(nums, k));
        //System.out.println("******************************************");
        System.out.println("subarraySumUpgrad " + subarraySumUpgrad(nums, k));
        //System.out.println("******************************************");
        //System.out.println("******************************************");
       //System.out.println("subarraySum2 " + subarraySum2(nums, k));
        System.out.println("subarraySumNotOptimized " + subarraySumNotOptimized(nums, k));
    }

    static void input4(){
        System.out.println();
        int[] nums = {1, 2, -4, 4, 5, -2, -3};
        int k = 3;
        System.out.println("subarraySum " + subarraySum(nums, k));
        System.out.println("******************************************");
        System.out.println("subarraySumUpgrad " + subarraySumUpgrad(nums, k));
        System.out.println("******************************************");
        System.out.println("subarraySum2 " + subarraySum2(nums, k));
        System.out.println("******************************************");
        System.out.println("subarraySumNotOptimized " + subarraySumNotOptimized(nums, k));
    }
}
