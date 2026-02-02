package com.leetcode.binarysearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.*;

//Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
//Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
// If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

//Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

//Return the minimum integer k such that she can eat all the bananas within h hours.

/*Example 1:
        Input: piles = [3,6,7,11], h = 8
        Output: 4
Example 2:
        Input: piles = [30,11,23,4,20], h = 5
        Output: 30*/
public class KokoEatingBananas {

    public static void main(String[] args) {

        input1();
      // input2();
    }

    //O(log(max) *n ) n - length of the piles
    static int minEatingSpeedWithOptimization(int[] piles, int H){
        int left = 1, right = stream(piles).max().getAsInt();
      //   right = stream(piles).sum();
        System.out.println("minEatingSpeedWithOptimization left: " + left + " right: " + right + " mid " + (left + right) / 2);
        while (left < right) {
            int mid = (left + right) / 2;
            System.out.println("minEatingSpeedWithOptimization mid: " + mid);
            int total = 0;
            int total1 = 0;
            for (int p : piles){
                int val = (p + mid - 1) / mid;
             //   int val1 = (int) Math.ceil((float)p/(float)mid);
                total += val;
             //   total1 = total1 + val1;
            }
            System.out.println("minEatingSpeedWithOptimization  final total: " + total);
            //System.out.println("minEatingSpeedWithOptimization  final total1: " + total1);

            if(total == H)
                return mid;
            else if (total > H)
                left = mid + 1;
            else
                right = mid -1;
            System.out.println("minEatingSpeedWithOptimization left: " + left + " right: " + right + " mid " + mid);
            System.out.println();
        }
        return left;
    }

    static int minEatingSpeedWithoutOptimization(int[] piles, int h){
        System.out.println("minEatingSpeedWithoutOptimization input " + Arrays.toString(piles));
        int max_speed = find_Max(piles);
      /*  List list = Arrays.asList(piles);
        System.out.println("list " + list);
        System.out.println("MAx of Array " + Collections.max(list));*/
        System.out.println("minEatingSpeedWithoutOptimization max_speed " + max_speed);
        for(int k =1; k <=max_speed; k++){
            if(isPossibleToFinish(piles, h, k)){
                return k;
            }
        }
    return max_speed;
    }

    //Time: O(n)
    static int find_Max(int[] piles){
        int max = piles[0];
        for(int i =1; i<piles.length; i++){
            max = Math.max(max,piles[i]);
        }
        return  max;
    }

    //Time: O(n)
    static boolean isPossibleToFinish(int[] piles, int h, int k){
        int hours_needed = 0;

        //O(n)
        for(int i=0; i< piles.length; i++) {
            System.out.println("Num in Pile: " + piles[i] + " No of Bananas: " +  k +  " Total Time: " + (int) Math.ceil((float)piles[i]/(float)k));
            hours_needed = hours_needed + (int) Math.ceil((float)piles[i]/(float)k);
        }
        System.out.println("k: " + k + " hours_needed: " + hours_needed) ;

        if(hours_needed <= h)
            return true;

        return false;
    }

    static void input1(){
        int[] piles = {3,6,7,11};

        int h =8;
        System.out.println("input1 Array " + Arrays.toString(piles)  + " hour " + h);
       System.out.println("input1 minEatingSpeedWithoutOptimization " + minEatingSpeedWithoutOptimization(piles, h) );
       System.out.println("input1 minEatingSpeedWithOptimization " + minEatingSpeedWithOptimization(piles, h) );
    }

    static void input2(){
        System.out.println();
        int[] piles = {30,11,23,4,20};

        int h =5;
        System.out.println("input2 Array " + Arrays.toString(piles) + " hour " + h);
      //  System.out.println("input2 minEatingSpeedWithoutOptimization " + minEatingSpeedWithoutOptimization(piles, h) );
        System.out.println("input2 minEatingSpeedWithOptimization " + minEatingSpeedWithOptimization(piles, h) );
    }
}
