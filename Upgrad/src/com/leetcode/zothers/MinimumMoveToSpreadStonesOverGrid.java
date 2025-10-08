package com.leetcode.zothers;

//You are given a 0-indexed 2D integer matrix grid of size 3 * 3, representing the number of stones in each cell.
// The grid contains exactly 9 stones, and there can be multiple stones in a single cell.

//In one move, you can move a single stone from its current cell to any other cell if the two cells share a side.

//Return the minimum number of moves required to place one stone in each cell.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Example1:
Input: grid = [[1,1,0],[1,1,1],[1,2,1]]
Output: 3
Explanation: One possible sequence of moves to place one stone in each cell is:
1- Move one stone from cell (2,1) to cell (2,2).
2- Move one stone from cell (2,2) to cell (1,2).
3- Move one stone from cell (1,2) to cell (0,2).
In total, it takes 3 moves to place one stone in each cell of the grid.
It can be shown that 3 is the minimum number of moves required to place one stone in each cell.

Example2:
Input: grid = [[1,3,0],[1,0,0],[1,0,3]]
Output: 4
Explanation: One possible sequence of moves to place one stone in each cell is:
1- Move one stone from cell (0,1) to cell (0,2).
2- Move one stone from cell (0,1) to cell (1,1).
3- Move one stone from cell (2,2) to cell (1,2).
4- Move one stone from cell (2,2) to cell (2,1).
In total, it takes 4 moves to place one stone in each cell of the grid.
It can be shown that 4 is the minimum number of moves required to place one stone in each cell.
*/
public class MinimumMoveToSpreadStonesOverGrid {

    public static void main(String[] args) {
        input1();
        input2();
    }

    public static int minimumMoves(int[][] grid) {
        int zeroCount = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 0)
                    ++zeroCount;
            }
        }
        if (zeroCount == 0)
            return 0;

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j)
                if (grid[i][j] == 0)
                    for (int x = 0; x < 3; ++x)
                        for (int y = 0; y < 3; ++y)
                            if (grid[x][y] > 1) {
                                --grid[x][y];
                                ++grid[i][j];
                                ans = Math.min(ans, Math.abs(x - i) + Math.abs(y - j) + minimumMoves(grid));
                                ++grid[x][y];
                                --grid[i][j];
                            }

        return ans;
    }

    private int cal(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
    static void input1(){
        int[][] grid = {{1,3,0},
                {1,0,0},
                {1,0,3}};
    }

    static void input2(){
        int[][] grid = {{1,1,0},
                {1,1,1},
                {1,2,1}};
    }
}
