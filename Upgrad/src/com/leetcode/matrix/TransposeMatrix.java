package com.leetcode.matrix;

import java.util.Arrays;

//Given a 2D integer array matrix, return the transpose of matrix.
//The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
/*
Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]

Example 2:
Input: matrix = [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]*/
public class TransposeMatrix {

    public static void main(String[] args) {
        input1();
    }

    //Time - O(m*n)
    //Space - O(m*n)
    static int[][] transpose(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[n][m];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                result[j][i] = matrix[i][j];
            }
        }

    return  result;
    }


    static void input1(){
        int[][] matrix ={{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("input1 transpose " + Arrays.deepToString(transpose(matrix)));
    }

    static void input2(){
        int[][] matrix ={{1, 2, 3},
                {4, 5, 6}
        };
        System.out.println("input2 transpose " + Arrays.deepToString(transpose(matrix)));
    }
}
