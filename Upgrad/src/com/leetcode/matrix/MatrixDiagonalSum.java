package com.leetcode.matrix;
//Given a square matrix mat, return the sum of the matrix diagonals.
//Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

import java.util.Arrays;

/*
Example1:
Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.
*/
public class MatrixDiagonalSum {

    public static void main(String[] args) {
        input1();
      //  input2();
        //input3();
    }

    static int diagonalSum(int[][] mat) {
        int n = mat.length; //rows
        int col = mat[0].length; //column
        System.out.println("diagonalSum mat row length: " + n + " column length: " + col);

        int sum = 0;
        int i = 0, j = 0;

        while (i < n) {
            System.out.println("mat[i][j]: mat[" + i + "][" + j + "]");
            sum += mat[i][j];
            i++;
            j++;
        }
        System.out.println("diagonalSum Primary Sum " + sum);
        i = 0;
        j = n - 1;

        while (i < n) {
            if (i != j) {
                System.out.println("mat[i][j]: mat[" + i + "][" + j + "]");
                sum += mat[i][j];
            }

            i++;
            j--;
        }
        return sum;
    }

    static int diagonalSumUpgrad(int[][] mat) {
        int rows = mat.length; //rows
        int cols = mat[0].length; //column
        System.out.println("diagonalSum1 mat row length: " + rows + " column length: " + cols);
        int n = rows;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + mat[i][i]; //Primary Diagonal
            sum = sum + mat[i][n - 1 - i]; //Secondary Diagonal
        }

        if (n % 2 == 1) {
            sum = sum - mat[n / 2][n / 2];
        }
        return sum;
    }

    static void input1() {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.deepToString(mat));
        System.out.println("diagonalSum input1 " + diagonalSum(mat));
       // System.out.println("diagonalSum1 input1 " + diagonalSumUpgrad(mat));
    }

    static void input2() {
        int[][] mat = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        System.out.println(Arrays.deepToString(mat));
        System.out.println("diagonalSum input2 " + diagonalSum(mat));
        System.out.println("diagonalSum1 input2 " + diagonalSumUpgrad(mat));
    }

    static void input3() {
        int[][] mat = {
                {5}
        };
        System.out.println(Arrays.deepToString(mat));
        System.out.println("diagonalSum input3 " + diagonalSum(mat));
        System.out.println("diagonalSum1 input3 " + diagonalSumUpgrad(mat));
    }
}
