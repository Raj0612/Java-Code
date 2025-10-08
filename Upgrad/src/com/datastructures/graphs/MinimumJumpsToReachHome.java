package com.datastructures.graphs;

import java.util.*;

//A certain bug's home is on the x-axis at position x. Help them get there from position 0.
//The bug jumps according to the following rules:
/*
* It can jump exactly a positions forward (to the right).
* It can jump exactly b positions backward (to the left).
* It cannot jump backward twice in a row.
* It cannot jump to any forbidden positions.
 */
//The bug may jump forward beyond its home, but it cannot jump to positions numbered with negative integers.
//Given an array of integers forbidden, where forbidden[i] means that the bug cannot jump to the position forbidden[i], and integers a, b, and x,
// return the minimum number of jumps needed for the bug to reach its home. If there is no possible sequence of jumps that lands the bug on position x, return -1.
/*
Example 1:
Input: forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9
Output: 3
Explanation: 3 jumps forward (0 -> 3 -> 6 -> 9) will get the bug home.

Example 2:
Input: forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11
Output: -1

Example 3:
Input: forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7
Output: 2
Explanation: One jump forward (0 -> 16) then one jump backward (16 -> 7) will get the bug home.
 */
/*
Constraints:
1 <= forbidden.length <= 1000
1 <= a, b, forbidden[i] <= 2000
0 <= x <= 2000
All the elements in forbidden are distinct.
Position x is not forbidden
 */
public class MinimumJumpsToReachHome {

    public static void main(String[] args) {
     //   input1();
        System.out.println();
        input2();
        System.out.println();
        input3();
    }

    static void input1(){
        int[] forbidden = {14,4,18,1,15};
        int a = 3;
        int b = 15;
        int x = 9;
        System.out.println("input1 minimumJumpsByUpgrad " + minimumJumpsByUpgrad(forbidden, a, b, x));
        System.out.println("input1 minimumJumps " + minimumJumps(forbidden, a, b, x));
    }
    static void input2(){
        int[] forbidden = {18,3,16,6,12,20};
        int a = 15;
        int b = 13;
        int x = 11;
        System.out.println("input2 minimumJumpsByUpgrad " + minimumJumpsByUpgrad(forbidden, a, b, x));
        System.out.println("input2 minimumJumps " + minimumJumps(forbidden, a, b, x));
    }

    static void input3(){
        int[] forbidden = {1,6,2,14,5,17,4};
        int a = 16;
        int b = 9;
        int x = 7;
        System.out.println("input2 minimumJumpsByUpgrad " + minimumJumpsByUpgrad(forbidden, a, b, x));
        System.out.println("input3 minimumJumps " + minimumJumps(forbidden, a, b, x));
    }

    public static int minimumJumpsByUpgrad(int[] forbidden, int forwardJump, int backwardJump, int x) {
        Set<Integer> forbiddenSet = new HashSet<>();
        for (int position : forbidden) {
            forbiddenSet.add(position);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 1}); // currentPosition, cost, canJumpBack
        forbiddenSet.add(0);
        while (!queue.isEmpty()){
            int[] t = queue.poll();
            int position = t[0];
            int cost = t[1];
            int canJumpBack = t[2];

            if(position == x)
                return cost;

            int next = position + forwardJump;
            int prev = position - backwardJump;

            if(!forbiddenSet.contains(prev) && prev >= 0 && canJumpBack == 1){
                queue.offer(new int[]{prev, cost +1, 0});
                forbiddenSet.add(prev); // Added for TLE
            }

            if(!forbiddenSet.contains(next) && next < 6000){
                queue.offer(new int[]{next, cost +1, 1});
                forbiddenSet.add(next); // Added for TLE
            }
        }

        return -1;
    }

    public static int minimumJumpsByUpgrad1(int[] forbidden, int forwardJump, int backwardJump, int x) {
        Set<Integer> forbiddenSet = new HashSet<>();
        for (int position : forbidden) {
            forbiddenSet.add(position);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 1}); // currentPosition, cost, canJumpBack
        forbiddenSet.add(0);
        while (!queue.isEmpty()){
            int[] t = queue.poll();
            int position = t[0];
            int cost = t[1];
            int canJumpBack = t[2];

            if(position == x)
                return cost;

            if(forbiddenSet.contains(position))
                continue;

            forbiddenSet.add(position);

            int next = position + forwardJump;
            int prev = position - backwardJump;

            if(!forbiddenSet.contains(prev) && prev >= 0 && canJumpBack == 1){
                queue.offer(new int[]{prev, cost +1, 0});
            }

            if(!forbiddenSet.contains(next) && next < 6000){
                queue.offer(new int[]{next, cost +1, 1});
            }
        }

        return -1;
    }

    public static int minimumJumps(int[] forbidden, int forwardJump, int backwardJump, int x) {
        Set<Integer> forbiddenSet = new HashSet<>();
        for (int position : forbidden) {
            forbiddenSet.add(position);
        }
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 1}); // Starting at position 0; 1 indicates next jump can be either forward or backward

        // Define upper bound of positions to avoid infinite searching
        final int MAX_POSITION = 6000;
        // Create a visited matrix to track visited positions; two states for forward [][1] or backward [][0] jump
        boolean[][] visited = new boolean[MAX_POSITION][2];
        visited[0][1] = true; // We start at position 0 and can move either forward or backward
        for (int steps = 0; !queue.isEmpty(); ++steps) {
            for (int size = queue.size(); size > 0; --size) {
                int[] currentPosition = queue.poll();
                int position = currentPosition[0];
                int canJumpBackward = currentPosition[1];
                if (position == x) {
                    return steps;
                }
                // Store next positions from current position
                List<int[]> nextPositions = new ArrayList<>();
                nextPositions.add(new int[] {position + forwardJump, 1}); // Always can jump forward

                // Check if we can jump backward from the current position
                if (canJumpBackward == 1) {
                    nextPositions.add(new int[] {position - backwardJump, 0}); // After jumping back, can't jump back again right away
                }

                // Explore next positions
                for (int[] nextPos : nextPositions) {
                    int newPosition = nextPos[0];
                    int newCanJumpBackward = nextPos[1];

                    // Validate new position (not forbidden, within bounds, and not visited)
                    if (newPosition >= 0 &&
                            newPosition < MAX_POSITION &&
                            !forbiddenSet.contains(newPosition) &&
                            !visited[newPosition][newCanJumpBackward]) {

                        // Add valid position to the queue and mark it as visited
                        queue.offer(new int[] {newPosition, newCanJumpBackward});
                        visited[newPosition][newCanJumpBackward] = true;
                    }
                }
            }
        }
        return -1;
    }

}
