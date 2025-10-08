package com.leetcode.matrix;

//Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
//A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

/*
Example1:
Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.

Example2:
Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.

Example3:
Input: matrix = [[7,8],[1,2]]
Output: [7]
Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LuckyNumbersInMatrix {
    public static void main(String[] args) {

        input1();
        //input2();
    }
    static List<Integer> luckyNumbers(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] row = new int[n];
        for(int i=0;i<n;i++)
            row[i] = Integer.MAX_VALUE;

        int[] col = new int[m];
        for(int i=0;i<m;i++)
            col[i] = Integer.MIN_VALUE;


        System.out.println("luckyNumbers row " + Arrays.toString(row));
        System.out.println("luckyNumbers col " + Arrays.toString(col));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                row[i] = Math.min(row[i], matrix[i][j]);
        }
        System.out.println("luckyNumbers row1 " + Arrays.toString(row));

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                col[i] = Math.max(col[i], matrix[j][i]);
        }
        System.out.println("luckyNumbers col1 " + Arrays.toString(col));
        HashSet<Integer> s = new HashSet<Integer>();
        for(int i=0;i<n;i++)
            s.add(row[i]);
        for(int i=0;i<m;i++)
            if(s.contains(col[i]))
                return new ArrayList(Arrays.asList((col[i])));
        return new ArrayList();
    }

    //Time -  O(m*n)
    //Space - O(m+n)
    static List<Integer> luckyNumbersUpgrad(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] min = new int[m];
        int[] max = new int[n];

        Arrays.fill(min, Integer.MAX_VALUE);

        //O(m*n)
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                min[i] = Math.min(min[i], matrix[i][j]);
                max[j] = Math.max(max[j], matrix[i][j]);
            }
        }
        System.out.println();
        System.out.println("luckyNumbersUpgrad min " + Arrays.toString(min));
        System.out.println("luckyNumbersUpgrad max " + Arrays.toString(max));
        List<Integer> result = new ArrayList<>();
        //O(m*n)
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                if(min[i] == max[j]){
                    result.add(min[i]);
                    break;
                }

            }
        }
        return result;
    }

    //Time - O(m*n*(m+n))
    static List<Integer> luckyNumbersNonOptimized (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();

        for(int i=0;i<m; i++){
            for(int j=0; j<n; j++){
                    int x = matrix[i][j];

                    if(isLucky(x, i, j, matrix)){
                        result.add(x);
                    }
            }
        }
    return result;

    }

    public static boolean isLucky(int x, int i, int j, int matrix[][]){ //O(m+n) == O(max(m,n))
        int m = matrix.length;
        int n = matrix[0].length;

        int min_in_row = matrix[i][0];
        for(int k=1; k<n; k++){ //O(n)
            min_in_row = Math.min(min_in_row, matrix[i][k]);
        }

        int max_in_col = matrix[0][j];
        for(int k=1; k<m; k++){ //O(m)
            max_in_col = Math.max(max_in_col, matrix[k][j]);
        }
        return (x== min_in_row && x== max_in_col);

    }

    static void input1(){
        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};

        System.out.println("input matrix " + Arrays.deepToString(matrix));
       // List<Integer> output = luckyNumbers(matrix);
       // List<Integer> output = luckyNumbersNonOptimized(matrix);
        List<Integer> output = luckyNumbersUpgrad(matrix);
        if(output.size() > 0)
            System.out.print(output.get(0));
    }

    static void input2(){
        int[][] matrix = {{1,10,4, 2},{9,3, 8 , 7},{15, 16,17, 12}};

        System.out.println("input2 matrix " + Arrays.deepToString(matrix));
        // List<Integer> output = luckyNumbers(matrix);
        // List<Integer> output = luckyNumbersNonOptimized(matrix);
        List<Integer> output = luckyNumbersUpgrad(matrix);
        if(output.size() > 0)
            System.out.print(output.get(0));
    }
}

