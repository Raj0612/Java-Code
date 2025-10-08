package com.leetcode.arrays;

//You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
//Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n,
// return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

/*
Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true

Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
 */
public class CanPlaceFlowers {

    public static void main(String[] args) {
        input1();
        input2();
    }

    static boolean canPlaceFlowersUpgrad(int[] flowerbed, int n){

        int m = flowerbed.length;

        for(int i=0; i<m; i++){
            boolean left = false;
            boolean right = false;

            if(i==0 || flowerbed[i-1]==0){
                left = true;
            }else{
                continue;
            }

            if(i== m-1 || flowerbed[i+1]==0){
                right = true;
            }else{
                continue;
            }

            if(left && right && flowerbed[i]==0){
                flowerbed[i] = 1;
                n--;
            }

            if(n==0)
                return true;
        }

        if(n<=0)
            return true;

        return false;

    }

    static void input1(){
        int[] arr = {1, 0, 0, 0, 1};
        int n =1;
        System.out.println("input1 canPlaceFlowersUpgrad " + canPlaceFlowersUpgrad(arr, n));
    }

    static void input2(){
        int[] arr = {1, 0, 0, 0, 1};
        int n = 2;
        System.out.println("input2 canPlaceFlowersUpgrad " + canPlaceFlowersUpgrad(arr, n));
    }
}
