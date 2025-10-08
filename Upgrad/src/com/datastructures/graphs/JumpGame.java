package com.datastructures.graphs;

import java.util.LinkedList;
import java.util.Queue;

//You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
//Return true if you can reach the last index, or false otherwise.
/*
Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {

    public static void main(String[] args) {
       // input1();
        input2();
    }

    static void input1(){
        int nums[] = {2,3,1,1,4};
        System.out.println("input1 canJump: " + canJump(nums));
    }

    static void input2(){
        int nums[] = {3,2,1,0,4};
        System.out.println("input2 canJump: " + canJump(nums));
    }

    public static boolean canJump(int[] nums) {

        int n = nums.length;
        int visited[] = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = 1;
        while (!queue.isEmpty()){

            int currNode = queue.poll();
            if(currNode == n-1){
                return true;
            }
            int min = Math.min(n-1, currNode + nums[currNode]);
            for(int j = currNode+1; j <=Math.min(n-1, currNode + nums[currNode]); j++ ){
                if(visited[j] == 0){
                    queue.add(j);
                    visited[j] = 1;
                }
            }
        }
        return false;
    }
}
