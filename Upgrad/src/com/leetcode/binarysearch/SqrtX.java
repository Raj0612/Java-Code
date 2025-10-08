package com.leetcode.binarysearch;
//Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
//You must not use any built-in exponent function or operator.
// For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

/*
Example 1:
        Input: x = 4
        Output: 2
        Explanation: The square root of 4 is 2, so we return 2.

Example 2:
        Input: x = 8
        Output: 2
        Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 */
 public class SqrtX {

    public static void main(String[] args) {
        int x= 10000;
        x = 10;
      //  System.out.println("mySqrtNotOptimized " + mySqrtNotOptimized(x));
        System.out.println("mySqrtOptimized " + mySqrtOptimized(x));
    }

    static int mySqrtNotOptimized(int x){
        for(int i=1; i<=x; i++){
            if(i*i == x){
                return  i;
            }else if(i*i > x){
                return i-1;
            }
        }
     return  x;
    }


    static int mySqrtNotOptimized1(int x){
        for(int i=1; i<=x; i++){
            if(i*i == x){
                return  i;
            }
            if((i*i < x) && ((i+1)*(i+1) > x))
                return i;
        }
        return  x;
    }

    static int mySqrtOptimized(int x){
       int start = 0;
       start = 1;
       int end = x;
       end = x/2;
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            long sqr = mid*mid;
            if (sqr == x) {
                return mid;
            } else if (sqr < x) {
                start = mid + 1;
                result = mid;
            }else {
                end = mid - 1;
            }
        }
        return result;
    }
}
