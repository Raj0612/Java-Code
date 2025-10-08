package com.datastructures.graphs;

import java.util.LinkedList;
import java.util.Queue;

//You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
//Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 /*      0 <= j <= nums[i] and
        i + j < n

  */
//Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
/*
Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [2,3,0,1,4]
Output: 2
 */
public class JumpGameII {

    public static void main(String[] args) {
        input1();
        input2();
    }
    static void input1(){
        int nums[] = {2,3,1,1,4};
        System.out.println("input1 canJump: " + canJump(nums));
    }

    static void input2(){
        int nums[] = {3, 2, 1, 0, 4};
        System.out.println("input2 canJump: " + canJump(nums));
    }

    public static int canJump(int[] nums) {
        int n = nums.length;
        int visited[] = new int[n];
        Queue<NodeInfo2> queue = new LinkedList<>();
        queue.add(new NodeInfo2(0, 0));
        visited[0] = 1;
        while (!queue.isEmpty()){

            NodeInfo2 currNode = queue.poll();
            if(currNode.index == n-1){
                return currNode.level;
            }

            for(int j = currNode.index+1; j <=Math.min(n-1, currNode.index + nums[currNode.index]); j++ ){
                if(visited[j] == 0){
                    queue.add(new NodeInfo2(j, currNode.level+1));
                    visited[j] = 1;
                }
            }

        }
        return 0;
    }
}

class NodeInfo2{
    int index, level;

    public NodeInfo2(int index, int level) {
        this.index = index;
        this.level = level;
    }
}
