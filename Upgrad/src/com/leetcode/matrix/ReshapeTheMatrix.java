package com.leetcode.matrix;
//In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
//You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.
//The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
//If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

import java.util.Arrays;

/*Example1:
Input: mat = [[1,2],[3,4]], r = 1, c = 4
Output: [[1,2,3,4]]

Example2:
Input: mat = [[1,2],[3,4]], r = 2, c = 4
Output: [[1,2],[3,4]]

Example3:
Input: mat = [[1,2],[3,4],[5, 6]], r = 1, c = 6
Output: [[1,2,3,4,5,6]]
*/
public class ReshapeTheMatrix {

    public static void main(String[] args) {
        //input1();
       // input2();
        input3();
    }

    //Time - O(n*n)
    //Space - O(r*c)/O(m*n)
    public static int[][] matrixReshape(int[][] mat, int r, int c) {

        int m = mat.length;
        int n = mat[0].length;

        if(m*n != r*c)
            return mat;

        int[][] mat2 = new int[r][c];

        //"To find index of a matrix element  --> i*n+j   (i--> row index, n -->row length, j --> col index)
        //To find row using index = index/c; To find column using index --> index%c (c--> column length)"
        for(int row=0;row<m; row++){
            for(int col=0; col<n; col++){
                int index =  row*n +col;
                int row1 = index/c;
                int col1 = index%c;
                mat2[row1][col1] = mat[row][col];
            }
        }
        return mat2;
    }
    static void input1(){
        int[][] mat = {{1, 2},
                {3, 4}};
        int r = 1, c =4;
        int[][] result = matrixReshape(mat, r, c);
        System.out.println("input 1 " + Arrays.deepToString(result));
    }

    static void input2(){
        int[][] mat = {{1, 2},
                {3, 4}};
        int r = 2, c =2;
        int[][] result = matrixReshape(mat, r, c);
        System.out.println("input 2 " + Arrays.deepToString(result));
    }

    static void input3(){
        int[][] mat = {{1, 2},
                {3, 4},
                {5, 6}};
        System.out.println("input 3 mat " + Arrays.deepToString(mat));
        int r = 1, c =6;
        int[][] result = matrixReshape(mat, r, c);
        System.out.println("input 3 " + Arrays.deepToString(result));

    }
}
