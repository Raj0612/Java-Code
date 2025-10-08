package com.leetcode.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {
    //f(0) - 0
    //f(1) - 1
    //f(2) - 1
    //f(3) - 2
    //f(4) - 3
    //f(5) - 5
    //f(6) - 8
    //f(7) - 13
    //static Map< Integer, Integer > memoizeTable = new HashMap< >();
    public static void main(String[] args) {
        input1();
    }

    //Time - O(2^n)
    //Space - O(n)
    public static int fibByRecursionWODP(int n){
        if(n==1|| n==0)
            return n;
        int n1 = fibByRecursionWODP(n-1);
        int n2 = fibByRecursionWODP(n-2);
     //   System.out.println("fibByRecursionWODP n: " + n + " n1: " + n1 + " n2: "+ n2) ;
      //return   fibByRecursionWODP(n-1) + fibByRecursionWODP(n-2);
         return n1 + n2;
    }


    //Time -- O(n)
    //Space -- O(n)
    public static int fibByMemo(int n) {

        int arr[] = new int[n + 1];

        Arrays.fill(arr, -1);

        return fibByMemo(n, arr);
    }

    public static int fibByMemo(int n, int[] arr){

        if(arr[n]!=-1)
            return arr[n];

        if(n<=1){
            arr[n] = n;
            return n;
        }
        int n1 = fibByMemo(n-1, arr);
        int n2 = fibByMemo(n-2,arr);
        arr[n] = n1 + n2;
       // arr[n] =  fibByMemo(n-1, arr) + fibByMemo(n-2,arr);
        return arr[n];
    }
    //Time -- O(n)
    static int fibMemoize(int n){
          Map< Integer, Integer > memoizeTable = new HashMap< >();
         return  fibMemoize(n, memoizeTable);
    }

    static public int fibMemoize(int n, Map< Integer, Integer > memoizeTable) {
        if ((n == 0) || (n == 1)) {
            return n;
        }

        if (memoizeTable.containsKey(n)) {
            return memoizeTable.get(n);
        }

        int n1 = fibMemoize(n-1);
        int n2 = fibMemoize(n-2);
        int result = n1 + n2;
      //  int result = fibMemoize(n - 1) + fibMemoize(n - 2);

        memoizeTable.put(n, result);

        return result;
    }

    static int fibDPByTabulation(int n){

        if(n<=1)
            return n;
        int arr[] = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;

        for(int i =2; i<=n; i++){
            arr[i] = arr[i-2] + arr[i-1];
        }
        return arr[n];
    }

    static void input1(){
        int n =4;
        System.out.println("input1 " + n + ": " + fibByRecursionWODP(n));
        System.out.println("input1 by fibByMemo " + n + " is: " + fibByMemo(n));
      // System.out.println("input1 by fibMemoize " + n + ":" +fibMemoize(n));
      //  System.out.println("input1 by Tabulation " + n + ":" +fibDPByTabulation(n));
    }
}
