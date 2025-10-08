package com.leetcode.matrix;
//Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
//Integers in each row are sorted in ascending from left to right.
//Integers in each column are sorted in ascending from top to bottom.

/*
Example1:
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true

Example2:
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false
*/
public class SearchA2DMatrixII {
    public static void main(String[] args) {
        input1();
    }

    //O(nlogm)
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length, i = 0, j = matrix[0].length - 1;
        while (i < m && j >= 0) {
            int value = matrix[i][j];
            if (value == target) return true;
            else if (value > target) j--;
            else i++;
        }
        return false;
    }
    static void input1(){
        int[][] matrix ={{1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}};

        int target = 20;
    }
}
