package com.leetcode.matrix;

import java.util.Arrays;

//Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:
/*
* Players take turns placing characters into empty squares ' '.
* The first player A always places 'X' characters, while the second player B always places 'O' characters.
* 'X' and 'O' characters are always placed into empty squares, never on filled ones.
* The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
* The game also ends if all squares are non-empty.
* No more moves can be played if the game is over.
* */
//Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli]. return the winner of the game if it exists (A or B).
// In case the game ends in a draw return "Draw". If there are still movements to play return "Pending".
//You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.
/*
Example1:
Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
Output: "A"
Explanation: A wins, they always play first.

Example2:
Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
Output: "B"
Explanation: B wins.

Example3:
Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
Output: "Draw"
Explanation: The game ends in a draw since there are no moves to make.
 */
public class FindWinnerInTicTocGame {
    static int[][] board;
    static  int n = 3;
    public static void main(String[] args) {
        input1();
        //input2();
        //input3();
    }

    //Time: O(m*(n + n+ n+n)) == O(m*4n) == O(m*n)
    public static String tictactoe(int[][] moves) {
/*        int m = moves.length;
        if(m<5)
            return "Pending";
        else if(m==9)
            return "Draw";*/
        //board = n* n;
        //m = no of moves, 1 <=m <= n*n
         board = new int[n][n];
        System.out.println("tictactoe board " + Arrays.deepToString(board));
        int player = 1;  //A
        for(int[] move: moves){ //O(m * n) == O(n * n * n) m could be max 9 (3*3)
            int row = move[0], col = move[1];

            board[row][col] = player;

            if(checkRow(row, player)||
                checkCol(col, player)||
                    (row == col && checkDiagonal(player))||
                    (row == n-1-col && checkAntiDiagonal(player))){
                return player == 1 ? "A" : "B";
            }

            player = player * -1;
        }
        return  moves.length == n* n? "Draw" : "Pending";
    }


    //Time: O(n)
    private static  boolean checkRow(int row, int player){
        for(int col =0; col < n; col++){
            if(board[row][col]!=player)
                return false;
        }
        return true;
    }
    //Time: O(n)
    private static boolean checkCol(int col, int player){
        for(int row =0; row < n; row++){
            if(board[row][col]!=player)
                return false;
        }
        return true;
    }
    //Time: O(n)
    private static boolean checkDiagonal(int player){
        for(int row =0; row < n; row++){
            if(board[row][row] !=player)
                return false;
        }
        return true;
    }
    //Time: O(n)
    private static boolean checkAntiDiagonal(int player){
        for(int row=0; row<n; row++){
            if(board[row][n-1-row]!=player)
                return false;
        }
        return true;
    }
    public static String tictactoeOptimized(int[][] moves) {
        board = new int[n][n];
        int player = 1;

        int[] rows = new int[n];
        int[] cols = new int[n];

        int diag =0, anti_diag =0;
        for(int[] move: moves){ //O(m) == O(n * n) m could be max 9 (3*3)
          //  System.out.println("tictactoeOptimized move " + Arrays.toString(move));
            int row = move[0], col = move[1];

            rows[row] = rows[row] + player;
            cols[col] = cols[col] + player;
         //   System.out.println("tictactoeOptimized rows " + Arrays.toString(rows));
        //    System.out.println("tictactoeOptimized cols " + Arrays.toString(cols));
            if(row ==col)
                diag += player;

            if(row + col == n-1)
                anti_diag += player;

            if(Math.abs(rows[row]) == n ||
            Math.abs(cols[col]) ==n ||
                    Math.abs(diag) == n || Math.abs(anti_diag) ==n){
                return player ==1? "A": "B";
            }

            player = player * -1;
        }
        return  moves.length == n* n? "Draw" : "Pending";
    }


    static void input1(){
        int[][] moves ={{0, 0},
                {2, 0},
                {1, 1},
                {2, 1},
                {2, 2}
        };

        //System.out.println("input1 tictactoe " + tictactoe(moves));
        System.out.println("input1 tictactoeOptimized " + tictactoeOptimized(moves));
    }

    static void input2(){
        int[][] moves ={{0, 0},
                {1, 1},
                {0, 1},
                {0, 2},
                {1, 0},
                {2, 0}
        };

        System.out.println("input2 tictactoe " + tictactoe(moves));
        System.out.println("input2 tictactoeOptimized " + tictactoeOptimized(moves));
    }

    static void input3(){
        int[][] moves ={{0, 0},
                {1, 1},
                {2, 0},
                {1, 0},
                {1, 2},
                {2, 1},
                {0, 1},
                {0, 2},
                {2, 2}
        };

        System.out.println("input3 tictactoe " + tictactoe(moves));
    }
}
