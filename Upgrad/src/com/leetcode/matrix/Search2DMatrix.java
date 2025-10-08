package com.leetcode.matrix;
//You are given an m x n integer matrix matrix with the following two properties:
/*
* Each row is sorted in non-decreasing order.
* The first integer of each row is greater than the last integer of the previous row.
 */
//Given an integer target, return true if target is in matrix or false otherwise.

//You must write a solution in O(log(m * n)) time complexity.
/*Example1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
* */
public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {  {1, 3, 5, 7},
                            {10, 11, 16, 20},
                            {23, 30, 34, 60} };
        int target = 16;
        //System.out.println("searchMatrix " + searchMatrix(matrix, target));
        System.out.println("searchMatrixBinarySearch " + searchMatrixBinarySearch(matrix, target));
        //System.out.println("searchMatrixNotOptimized " + searchMatrixNotOptimized(matrix, target));
    }

    static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, i = 0, j = n - 1;
        while (i < m && j >= 0) {
            System.out.println("searchMatrix i " + i + " j " + j);
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    static boolean searchMatrixBinarySearch(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
      //  System.out.println("searchMatrixBinarySearch row " + row + " col " + col);
        int l = 0;
        int r = row * col - 1;
       // System.out.println("searchMatrixBinarySearch l " + l + " r " + r);
        while(l <=r ){
          //  int mid = l + (r-l)/2;
            int mid = (l+r)/2;

            int val = matrix[mid/col][mid%col];
         //   System.out.println("searchMatrixBinarySearch l: " + l + " r: " + r + " mid: " + mid + "    matrix["+mid+"/"+col+"] " + " matrix["+mid+"%"+col+"] " +  "matrix[" +mid/col+"]["+mid%col+"] " + matrix[mid/col][mid%col] );
            if(val == target) return true;
            if(val > target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return false;
    }

    //Time - O(m*n)
    //Space - O(1)
    static boolean searchMatrixNotOptimized(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        for(int i=0; i<m; i++){
            for(int j=0;j<n; j++){
                if(matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }

}

