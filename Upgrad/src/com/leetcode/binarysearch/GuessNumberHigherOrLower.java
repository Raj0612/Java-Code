package com.leetcode.binarysearch;

//We are playing the Guess Game. The game is as follows:
//I pick a number from 1 to n. You have to guess which number I picked.
//Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
//You call a pre-defined API int guess(int num), which returns three possible results:
/*    1. -1: Your guess is higher than the number I picked (i.e. num > pick).
    2. 1: Your guess is lower than the number I picked (i.e. num < pick).
    3. 0: your guess is equal to the number I picked (i.e. num == pick).*/
//Return the number that I picked.

/*Example 1:
        Input: n = 10, pick = 6
        Output: 6
Example 2:
        Input: n = 1, pick = 1
        Output: 1
Example 3:
        Input: n = 2, pick = 1
        Output: 1*/

public class GuessNumberHigherOrLower {
    public static void main(String[] args) {
        input1();
        input2();
    }

    public static int guessNumber(int n, int pick) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2; // (left + right/2)
            int g = guess(mid, pick);
            if (g == 0) {
                return mid;
            }  else if (g == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    public static int guessNumber1(int n, int pick) {
        int left = 1;
        int right = n;
        while (left < right) {
            //final int m = left + (right - left) / 2;
            final int m = (left + right) / 2;
            if (guess(m, pick) <= 0) // -1, 0
                right = m;
            else
                left = m + 1;
        }

        return left;
    }

    static int guess(int n, int pick){
        if(n < pick)
            return 1;
        else if(n > pick)
            return -1;
        else
            return 0;
    }
    static void input1(){
        int n = 10;
        int pick = 6;
        System.out.println("input 1 " + guessNumber(n, pick));

    }

    static void input2(){
        int n = 1;
        int pick =1;
        System.out.println("input 2 " + guessNumber1(n, pick));
    }
}
