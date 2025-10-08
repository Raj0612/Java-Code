package com.leetcode.matrix;
//Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
//You must do it in place.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Example1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example2:
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
*/
public class SetMatrixZeroes {
    public static void main(String[] args) {

       // input1();
        input2();
    }

    static void setZeroesSpaceOptimized(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        // Traverse row wise
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // Set all the elements that are not zero as -9999
                    for (int k = 0; k < n; k++) {
                        if (matrix[i][k] != 0) {
                            matrix[i][k] = -9999;
                        }
                    }
                }
            }
        }
        System.out.println(" setZeroesSpaceOptimized row " + Arrays.deepToString(matrix));
        // Traverse column wise
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] == 0) {
                    // Set all the elements that are not zero as -9999
                    for (int k = 0; k < m; k++) {
                        if (matrix[k][j] != 0) {
                            matrix[k][j] = -9999;
                        }
                    }
                }
            }
        }
        System.out.println(" setZeroesSpaceOptimized col " + Arrays.deepToString(matrix));
        // Update all -9999 as 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -9999) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //Time - O(m*n)

    static void setZeroesUpgrad(int[][] matrix){

        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for(int i = 0; i< m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        System.out.println("setZeroesUpgrad  rows " + rows + " cols " + cols);
        for(int i = 0; i< m; i++) {
            for (int j = 0; j < n; j++) {
                    if(rows.contains(i) || cols.contains(j))
                        matrix[i][j] =0;
            }
        }
    }

    static void setZeroesUpgradOptimizedWithSpace(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        boolean isCol = false;
        boolean isRow = false;

        for(int i=0; i<m; i++){
            if(matrix[i][0] ==0){
                isCol = true;
            }
        }

        for(int i=0; i<n; i++){
            if(matrix[0][i] ==0){
                isRow = true;
            }
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j]==0){
                    matrix[0][j] =0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][0]==0 || matrix[0][j] == 0){
                    matrix[i][j] =0;
                }
            }
        }

        if(isCol){
            for(int i=0; i<m; i++){
                matrix[i][0] = 0;
            }
        }

        if(isRow){
            for(int i=0; i<n; i++){
                matrix[0][i] = 0;
            }
        }
    }


    static void setZeroesNotOptimized(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int answer[][] = new int[m][n];
        // Set all elements of answer array as 1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = 1;
            }
        }

        System.out.println("Answer " + Arrays.deepToString(answer) );

        // Traverse row wise
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // Set this row as zero in answer array
                    for (int k = 0; k < n; k++) {
                        answer[i][k] = 0;
                    }
                    break;
                }
            }
        }
        System.out.println("Answer1 " + Arrays.deepToString(answer) );
        // Traverse column wise
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] == 0) {
                    // Set this column as 0 in answer array
                    for (int k = 0; k < m; k++) {
                        answer[k][j] = 0;
                    }
                }
            }
        }
        System.out.println("Answer2 " + Arrays.deepToString(answer) );
        // Update the elements in matrix array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (answer[i][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    static void input1(){
        int[][] matrix = new int[][] {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println("input1 " + Arrays.deepToString(matrix));
       // setZeroesNotOptimized(matrix);
        //setZeroesUpgrad(matrix);
        setZeroesSpaceOptimized(matrix);
        //setZeroesUpgradOptimizedWithSpace(matrix);
        System.out.println("input1 matrix " + Arrays.deepToString(matrix));
    }


    static void input2(){
        int[][] matrix = new int[][] {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        System.out.println("input2 " + Arrays.deepToString(matrix));
         setZeroesNotOptimized(matrix);
        // setZeroesUpgrad(matrix);
        // setZeroesSpaceOptimized(matrix);
        //setZeroesUpgradOptimizedWithSpace(matrix);
        System.out.println("input2 matrix " + Arrays.deepToString(matrix));
    }
}
