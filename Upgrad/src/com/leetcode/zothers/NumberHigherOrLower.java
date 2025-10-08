package com.leetcode.zothers;

public class NumberHigherOrLower {

    public static void main(String[] args) {

        int n = 10;

        System.out.println("guessNumber " + guessNumber(n));
    }

    static int guessNumber(int n){
        int start = 1, end = n;
        while(start<=end) {
            int pick = start+(end-start)/2;
            if(pick==0)
                return pick;
            else if(pick==1)
                start = pick+1;
            else
                end = pick-1;
        }
        return -1;
    }
}

