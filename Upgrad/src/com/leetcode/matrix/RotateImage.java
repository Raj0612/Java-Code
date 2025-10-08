package com.leetcode.matrix;
//You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
//You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.


import java.util.Arrays;

/*
Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example2:
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
*/
public class RotateImage {

    public static void main(String[] args) {
      input1();

       //input2();
    }

    static void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length / 2; i++) {
            int[] temp = matrix[i];
            System.out.println("rotate temp " + Arrays.toString(temp) + " matrix[length - i - 1] " + Arrays.toString(matrix[length - i - 1]));
            matrix[i] = matrix[length - i - 1];
            matrix[length - i - 1] = temp;
        }
        System.out.println("rotate matrix " + Arrays.deepToString(matrix));
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println("rotate matrix final " + Arrays.deepToString(matrix));
    }

    static void rotate1(int[][] matrix) {
        int n = matrix.length;
        System.out.println("rotate1 n " + n + " (n+1)/2 " + (n+1)/2 + "  n/2 " +  n / 2 );
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    static void input1(){
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(mat);
      //  rotate1(mat);

    }

    static void input2(){
        int[][] mat = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
       rotate(mat);
     //   rotate1(mat);

    }
}