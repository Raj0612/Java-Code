package com.leetcode.matrix;
//You are given an n x n integer matrix grid.
//Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:
//maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid centered around row i + 1 and column j + 1.

//In other words, we want to find the largest value in every contiguous 3 x 3 matrix in grid. Return the generated matrix.

/*
Example1:
Input: grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
Output: [[9,9],[8,6]]
Explanation: The diagram above shows the original matrix and the generated matrix.
Notice that each value in the generated matrix corresponds to the largest value of a contiguous 3 x 3 matrix in grid.

Example2:
Input: grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
Output: [[2,2,2],[2,2,2],[2,2,2]]
Explanation: Notice that the 2 is contained within every contiguous 3 x 3 matrix in grid.
*/

import java.util.Arrays;

public class LargestLocalValueInAMatrix {

    public static void main(String[] args) {
        input1();
    }

    //Time - O(n*n*9) =O(n*n)
    //Space - O(n*n)
    static public int[][] largestLocal(int[][] grid) {

        int n = grid.length;
        int result[][] = new int[n-2][n-2];

        for(int i=0; i<n-2; i++){
            for(int j=0; j<n-2; j++){
                int max = -1;
                for(int k=0; k<3; k++){
                    for(int l=0; l<3; l++){
                        max = Math.max(max, grid[i+k][j+l]);
                    }
                }
                result[i][j] = max;
            }
        }

        return result;
    }

    static void input1(){
        int[][] matrix = {{9, 9, 8, 1},
                {5, 6, 2, 6},
                {8, 2, 6, 4},
                {6, 2, 2, 2}
        };

        System.out.println("input1 " + Arrays.deepToString(largestLocal(matrix)));
    }
}
