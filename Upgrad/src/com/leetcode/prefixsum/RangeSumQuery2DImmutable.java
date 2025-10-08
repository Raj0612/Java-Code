package com.leetcode.prefixsum;

import java.util.Arrays;

//Given a 2D matrix matrix, handle multiple queries of the following type:
//* Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
//Implement the NumMatrix class:
/*
#)NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
#)int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1)
and lower right corner (row2, col2).
 */
//You must design an algorithm where sumRegion works on O(1) time complexity.
/*
Input
["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
Output
[null, 8, 11, 12]

Explanation
NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
 */
public class RangeSumQuery2DImmutable {

    static int matrix[][] ={{3,0,1,4,2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
    };

    static int[][] array;
    static int[][] sumRowArray;

    static int[][] sumColArray;
    public static void main(String[] args) {
        RangeSumQuery2DImmutable obj = new RangeSumQuery2DImmutable(matrix);
       // obj.nonOptimized();
        obj.optimized();

    }

    public void nonOptimized(){
        int param_1 = sunRegionNotOptimized(2, 1, 4, 3);
        int param_2 = sunRegionNotOptimized(1, 1, 2, 2);
        int param_3 = sunRegionNotOptimized(1, 2, 2, 4);
        System.out.println("nonOptimized param_1: " + param_1 + " param_2: " + param_2 + " param_3: " + param_3);
    }

    public void optimized(){
        int param_1 = sumRegionByRowArray(2, 1, 4, 3);
        int param_2 = sumRegionByRowArray(1, 1, 2, 2);
        int param_3 = sumRegionByRowArray(1, 2, 2, 4);
        System.out.println("optimized param_1: " + param_1 + " param_2: " + param_2 + " param_3: " + param_3);
    }

    public RangeSumQuery2DImmutable(int[][] matrix) {
        array = new int[matrix.length][matrix[0].length];
        array = matrix;
        System.out.println("Array " + Arrays.deepToString(array));
        populateSumArrayByRow();
      //  populateSumArray1();
        populateSumArrayByColumn();
    }

    void populateSumArrayByRow(){
        sumRowArray = new int[matrix.length][matrix[0].length];
        for(int i = 0; i<matrix.length; i++){
             int sum = 0;
            for(int j = 0; j<matrix[0].length; j++){
                sum = sum + matrix[i][j];
                sumRowArray[i][j] = sum;
            }
        }
        System.out.println("populateSumArrayByRow " + Arrays.deepToString(sumRowArray));
    }

    void populateSumArray1(){
        sumRowArray = new int[matrix.length][matrix[0].length];
        sumRowArray = matrix;
        for(int i = 0; i<matrix.length; i++){
            for(int j = 1; j<matrix[0].length; j++){
                sumRowArray[i][j] = sumRowArray[i][j-1] + sumRowArray[i][j];
            }
        }
        System.out.println("populateSumArray1 " + Arrays.deepToString(sumRowArray));
    }


    void populateSumArrayByColumn(){
        sumColArray = new int[matrix.length][matrix[0].length];
        sumColArray = matrix;
        for(int col = 0; col<matrix[0].length; col++){
            for(int row = 1; row<matrix.length; row++){
                sumColArray[row][col] = sumColArray[row-1][col] + sumColArray[row][col];
            }
        }
        System.out.println("populateSumArrayByColumn " + Arrays.deepToString(sumColArray));
    }

    public static int sumRegionByRowArray(int row1, int col1, int row2, int col2){
        System.out.println("sumRegion row1: " + row1 + " col1: " + col1 + " row2: " + row2 + " col2: " + col2);
        int sum = 0;
        for(int i = row1; i<=row2; i++){
            if(col1==0){
                sum = sum + sumRowArray[i][col2];
            }else{
                sum = sum + sumRowArray[i][col2] - sumRowArray[i][col1-1];
            }
        }
        return sum;
    }


    public static int sumRegionByColumnArray(int row1, int col1, int row2, int col2){
        int sum = 0;
        for(int i = col1; i<=col2; i++){
            if(row1==0){
                sum = sum + sumColArray[row2][i];
            }else{
                sum = sum + sumColArray[row2][i] - sumColArray[row1-1][i];
            }
        }
        return sum;
    }

    public static int sunRegionNotOptimized(int row1, int col1, int row2, int col2){
        int sum = 0;

        for(int i = row1; i<=row2; i++){
            for(int j = col1; j<=col2; j++){
                sum = sum + array[i][j];
            }
        }
        return sum;
    }
}
