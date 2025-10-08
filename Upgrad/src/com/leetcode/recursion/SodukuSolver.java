package com.leetcode.recursion;

public class SodukuSolver {

    public static void main(String[] args) {

        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                          {'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','8','.','.','7','9'}
        };

        upgradSolveSoduku(board);
    }

    static void upgradSolveSoduku(char[][] board){
        System.out.println(upgradHelper(board));
    }

    static boolean upgradHelper(char[][] board){
        int row = 0;
        int col = 0;

        boolean unfilled = false;

        for(int i =0; i<board.length; i++){
            for(int j =0; j<board[0].length; j++){
                if(board[i][j] =='.'){
                    unfilled= true;
                    row =i;
                    col =j;
                    break;
                }

            }
        }

        if(!unfilled)
            return true;

        if(unfilled){
            for(int k =1; k<=9; k++){
                if(isSafe(row,col,k, board)){
                    board[row][col] =(char)(k+'0');

                    if(upgradHelper(board)){
                        return true;
                    }else{
                        board[row][col] = '.';
                    }
                }
            }
        }
        return false;
    }

    static boolean isSafe(int row, int col, int k, char[][] board){
        for(int i=0;i<9;i++){
            if(board[i][col] == k+'0'){
                return false;
            }
        }

        for(int i=0; i<9; i++){
            if(board[row][i] == k+'0')
                return false;
        }

        int rowi = row - row%3;
        int coli = col - col%3;
        for(int i= rowi; i<rowi+3; i++){
            for(int j =coli; j<coli+3; j++){
                if(board[i][j] == k+'0'){
                    return false;
                }
            }
        }
        return true;
    }

}
