package com.datastructures.graphs;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//You are given an m x n grid where each cell can have one of three values:
/*
1) 0 representing an empty cell,
2) 1 representing a fresh orange, or
3) 2 representing a rotten orange.
 */
//Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
//Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
/*
Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 */
public class RottingOranges {

    public static void main(String[] args) {
        input1();
        System.out.println();
     //   input2();
        System.out.println();
      //  input3();
    }

    static void input1(){
        int[][] grid ={{2,1,1},
                {1,1,0},
                {0,1,1}};
        System.out.println("input1 : " +orangesRotting(grid));
    }

    static void input2(){
        int[][] grid ={{2,1,1},
                {0,1,1},
                {1,0,1}};
        System.out.println("input2 : " +orangesRotting(grid));
    }

    static void input3(){
        int[][] grid ={{0,2}};
        System.out.println("input3 : " +orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int freshOranges = 0;
        Deque<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                 freshOranges++;
                }
            }
        }
        System.out.println("freshOranges " + freshOranges);
        int minutesElapsed = 0;
        int[] directions = {1, 0, -1, 0, 1};
        while (!queue.isEmpty() && freshOranges > 0) {
            minutesElapsed++;
            for (int i = queue.size(); i > 0; --i) {
                int[] position = queue.poll();
                for (int j = 0; j < 4; ++j) {
                    int x = position[0] + directions[j];
                    int y = position[1] + directions[j + 1];
                    if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        freshOranges--;
                        queue.offer(new int[] {x, y});
                    }
                }
                }

        }
        return freshOranges > 0 ? -1 : minutesElapsed;
    }
}
