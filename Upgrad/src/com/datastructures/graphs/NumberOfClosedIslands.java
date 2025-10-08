package com.datastructures.graphs;

import java.util.Arrays;

//Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally
// (all left, top, right, bottom) surrounded by 1s.
//Return the number of closed islands.
/*
Input: grid = [
    [1,1,1,1,1,1,1,0],
    [1,0,0,0,0,1,1,0],
    [1,0,1,0,1,1,1,0],
    [1,0,0,0,0,1,0,1],
    [1,1,1,1,1,1,1,0]]
Output: 2
Explanation:
Islands in gray are closed because they are completely surrounded by water (group of 1s).

Example 2:
Input: grid = [
    [0,0,1,0,0],
    [0,1,0,1,0],
    [0,1,1,1,0]]
Output: 1

Example 3:
Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2
 */
public class NumberOfClosedIslands {

    public static void main(String[] args) {
        //   input1();
         //input2();
         // input3();
       //  input4();
        input5();
    }

    static void input1() {
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}};
        System.out.println("input1 : Grid " + Arrays.deepToString(grid));
        System.out.println("input1 closedIsland : " + closedIsland(grid));
     //  System.out.println("input1 : countClosedIsland: " + countClosedIsland(grid));
        System.out.println("input1 : Final grid " + Arrays.deepToString(grid));
    }

    static void input2() {
        int[][] grid = {
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0}};
        System.out.println("input2 : Grid " + Arrays.deepToString(grid));
        System.out.println("input2 : closedIsland " + closedIsland(grid));
      // System.out.println("input2 : countClosedIsland " + countClosedIsland(grid));
        System.out.println("input2 : Final grid " + Arrays.deepToString(grid));
    }

    static void input3() {
        int[][] grid = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1}};
        System.out.println("input3 : Grid " + Arrays.deepToString(grid));
        System.out.println("input3 : closedIsland " + closedIsland(grid));
       // System.out.println("input3: countClosedIsland" + countClosedIsland(grid));
        System.out.println("input3 : Final grid " + Arrays.deepToString(grid));
    }

    static void input4() {
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}};
        System.out.println("input4 : Grid " + Arrays.deepToString(grid));
        System.out.println("input4 : closedIsland " + closedIsland(grid));
       //System.out.println("input4 : countClosedIsland " + countClosedIsland(grid));
        System.out.println("input4 : Final grid " + Arrays.deepToString(grid));
    }

    static void input5() {
        int[][] grid = {
                {1, 1, 1, 1, 0, 1},
                {1, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 1},
                {1, 0, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}};
        System.out.println("input5 : Grid " + Arrays.deepToString(grid));
        System.out.println("input5 : closedIsland " + closedIsland(grid));
        //System.out.println("input4 : countClosedIsland " + countClosedIsland(grid));
        System.out.println("input5 : Final grid " + Arrays.deepToString(grid));
    }

    private static int height;
    private static int width;
    private static int[][] grid;



    private static final int[][] directions = {
            {1, 0}, // Down
            {-1, 0}, // Up
            {0, 1}, // Right
            {0, -1} // Left
    };
    // static int[] directions = {-1, 0, 1, 0, -1};
    static int closedIsland(int[][] grid1) {
        grid = grid1;
        height = grid.length;
        width = grid[0].length;
        int count = 0;
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (grid[i][j] == 0 && (i > 0 && i < height - 1 && j > 0 && j< width - 1)) {
                    count += dfs(i, j);
                }
            }
        }
        return count;
    }


    private static int dfs(int row, int col) {
        int isClosed = (row > 0 && row < height - 1 && col > 0 && col < width - 1) ? 1 : 0;
        grid[row][col] = 1;
        for (int k = 0; k < 4; ++k) {
            int nextRow = row + directions[k][0];
            int nextCol = col + directions[k][1];
            //  int nextRow = row + directions[k];           // Calculate the next row index
            // int nextCol = col + directions[k + 1];
            if (nextRow >= 0 && nextRow < height && nextCol >= 0 && nextCol < width
                    && grid[nextRow][nextCol] == 0) {
                isClosed &= dfs(nextRow, nextCol);
            }
        }

        return isClosed;
    }

    //https://www.geeksforgeeks.org/number-of-closed-islands-in-a-binary-matrix/' : Total number of closed islands
    //Wrong
    static int countClosedIsland(int[][] matrix) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    // explore this island
                    if (dfs(grid, visited, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static boolean dfs(int[][] grid, boolean[][] visited, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        // If we hit the border and it's land, this island is not closed
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return false;
        }

        if (grid[row][col] == 1 || visited[row][col]) {
            return true; // water or already visited
        }
        visited[row][col] = true;

        boolean up    = dfs(grid, visited, row - 1, col);
        boolean down  = dfs(grid, visited, row + 1, col);
        boolean left  = dfs(grid, visited, row, col - 1);
        boolean right = dfs(grid, visited, row, col + 1);

        // island is closed only if ALL sides remain closed
        return up && down && left && right;
    }
}