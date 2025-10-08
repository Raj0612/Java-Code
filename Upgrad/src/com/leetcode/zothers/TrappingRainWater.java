package com.leetcode.zothers;

//Session 9

import java.util.Arrays;

//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

/*
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 */
public class TrappingRainWater {


    public static void main(String[] args) {
       // input1();
        //input2();
       input3();
       // input4();
       // input5();
    }

    static int leftMax(int[] height, int i){
        int max = -1;
        for(int j =0; j<i; j++){
            max = Math.max(max,height[j]);
        }
        return max;
    }

    static int rightMax(int[] height, int i){
        int max = -1;
        for(int j = i+1; j<height.length; j++){
            max = Math.max(max,height[j]);
        }
        return max;
    }

    //Time  - O(n^2) as for each individual value right and left side is traversed.
    //Sapce - O(1) as no additional space is used while implementing this approach.
    public static int findTrappingRainWaterNonOptimized(int[] height) {
        System.out.println("findTrappingRainWaterNonOptimized " + Arrays.toString(height));
        int ans = 0;
        for(int i=1; i <height.length-1; i++){
           int water = Math.min(leftMax(height, i),rightMax(height, i)) - height[i];
            if(water>0){
                ans = ans + water;
            }
        }
        return ans;
    }
    public static int findTrappingRainWaterUsingTwoPointer(int[] height) {
        System.out.println("findTrappingRainWaterUsingTwoPointer " + Arrays.toString(height));
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        int lMax = 0, rMax = 0;
        while(left <= right){
            lMax = Math.max(height[left], lMax);
            rMax = Math.max(height[right], rMax);
            System.out.println("left: "+ left + " right: " + right + " lMax: " + lMax+ " rMax: " + rMax);
            if (lMax < rMax){
                ans += lMax - height[left++];
                System.out.println("findTrappingRainWaterUsingTwoPointer ans " + ans);
            }
            else {
                ans += rMax - height[right--];
                System.out.println("findTrappingRainWaterUsingTwoPointer ans1 " + ans);
            }
        }
        return ans;
    }

    //Time  - O(N) + O(N) = O(N), as the array is traversed thrice. Once we have traversed the array for evaluating the left_maximum and right_maximum of each block,
    // then on second traversal we are calculating the amount of water can be filled in each block according to left_maximum and right_maximum of that block.

    //Space - O(N), as we are creating 2 arrays of combined size n, it means we are using 'n' extra space.
    public static int findTrappingRainWaterByArray(int[] height) {
        System.out.println("findTrappingRainWaterByArray " + Arrays.toString(height));
        int n = height.length;
        int ans = 0;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = height[0];
        right[n-1] = height[n-1];
       // System.out.println("findTrappingRainWaterByArray left[0] " + left[0] + " right[n-1] " + right[n-1]);
        //System.out.println("findTrappingRainWaterByArray left array " + Arrays.toString(left) + " right array " + Arrays.toString(right));
        for(int i= 1; i<n;i++){
            left[i] = Math.max(left[i-1],height[i]);
        }
        System.out.println("findTrappingRainWaterByArray left Array " + Arrays.toString(left));
        for(int i= n-2; i>=0;i--){
            right[i] = Math.max(right[i+1],height[i]);
        }
        System.out.println("findTrappingRainWaterByArray right array " + Arrays.toString(right));
        for(int i=1; i <height.length-1; i++){
            int water = Math.min(left[i],right[i]) - height[i];
            if(water>0){
                ans = ans + water;
            }
        }
        return ans;
    }

    static void input1(){
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println("input1 findTrappingRainWaterNonOptimized " + findTrappingRainWaterNonOptimized(arr));
       // System.out.println("input1 findTrappingRainWaterUsingTwoPointer " + findTrappingRainWaterUsingTwoPointer(arr));
        System.out.println("input1 findTrappingRainWaterByArray " + findTrappingRainWaterByArray(arr));
    }

    static void input2(){
        System.out.println();
       // int arr[] = { 4,2,0,3,2,5 };
       // int arr[] = { 1,4,2,5,2,3 };
        int arr[] = { 1,2,4,5,2,3 };
        //System.out.println("input2 findTrappingRainWaterNonOptimized " + findTrappingRainWaterNonOptimized(arr));
        //System.out.println("input2 findTrappingRainWaterUsingTwoPointer " + findTrappingRainWaterUsingTwoPointer(arr));
         System.out.println("input2 findTrappingRainWaterByArray " + findTrappingRainWaterByArray(arr));
    }

    static void input3(){
        System.out.println();
        int arr[] = { 4,3,0,2,0,2,3 };
        //System.out.println("input3 findTrappingRainWaterNonOptimized " + findTrappingRainWaterNonOptimized(arr));
       // System.out.println("input3 findTrappingRainWaterUsingTwoPointer " + findTrappingRainWaterUsingTwoPointer(arr));
        System.out.println("input3 findTrappingRainWaterByArray " + findTrappingRainWaterByArray(arr));
    }

    static void input4(){
        System.out.println();
        int arr[] = { 3, 0, 2, 0, 4 };
        //System.out.println("input4 findTrappingRainWaterNonOptimized " + findTrappingRainWaterNonOptimized(arr));
         System.out.println("input4 findTrappingRainWaterUsingTwoPointer " + findTrappingRainWaterUsingTwoPointer(arr));
        //System.out.println("input4 findTrappingRainWaterByArray " + findTrappingRainWaterByArray(arr));
    }

    static void input5(){
        System.out.println();
        int arr[] = {1, 3, 2, 1};
        //System.out.println("input5 findTrappingRainWaterNonOptimized " + findTrappingRainWaterNonOptimized(arr));
      //  System.out.println("input5 findTrappingRainWaterUsingTwoPointer " + findTrappingRainWaterUsingTwoPointer(arr));
        System.out.println("input5 findTrappingRainWaterByArray " + findTrappingRainWaterByArray(arr));
    }

}
