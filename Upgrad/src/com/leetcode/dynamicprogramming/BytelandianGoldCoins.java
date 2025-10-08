package com.leetcode.dynamicprogramming;

//Each Bytelandian gold coin has an integer number written on it. A coin n can be exchanged in a bank into three coins: n/2, n/3 and n/4.
// But these numbers are all rounded down (the banks have to make a profit).

//You can also sell Bytelandian coins for American dollars. The exchange rate is 1:1. But you can not buy Bytelandian coins.

//You have one gold coin. What is the maximum amount of American dollars you can get for it?

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BytelandianGoldCoins {

    public static void main(String[] args) {
        input1();
    }

    static long find_maxByRecursiveWODP (long n){

      /*  if(n==0)
            return 0;
        if(n==1)
            return 1;*/

        if(n<12)
            return n;

        return Math.max(n,find_maxByRecursiveWODP(n/2) + find_maxByRecursiveWODP(n/3) + find_maxByRecursiveWODP(n/4) );

    }

    static int find_MaxByMemoisation(int n){
        int arr[] = new int[n+1];
        Arrays.fill(arr, -1);
        return find_MaxByMemoisation(n, arr);
    }
    static int find_MaxByMemoisation(int n, int arr[]){
        if(arr[n]!=-1)
            return arr[n];

        if(n<6) {
            arr[n] = n;
            return n;
        }

        arr[n] = Math.max(n, find_MaxByMemoisation(n/2, arr) + find_MaxByMemoisation(n/3, arr) + find_MaxByMemoisation(n/4, arr));
        return arr[n];
    }

    static int find_MaxByTabulation(int n){
        if(n<6)
            return n;
        int arr[] = new int[n+1];
        for(int i =0; i<=11; i++){
            arr[i] = i;
        }

        for(int i =12; i<=n; i++){
            arr[i] = Math.max(i, arr[i/2] + arr[i/3] + arr[i/4]);
        }

        return arr[n];
    }
    static long find_maxByMap(long n, Map<Long,Long> map){
        if(n ==0|| n==1)
            return n;
        if(map.containsKey(n))
            return map.get(n);
        long max = Math.max(n, find_maxByMap(n/2,map) + find_maxByMap(n/3,map) + find_maxByMap(n/4,map));
        if(n<10000)
            map.put(n,max);
        return max;
    }

    static void find_maxByMap(long n){
        final HashMap<Long,Long> map = new HashMap();
        long max = find_maxByMap(n, map);
        System.out.println("find_max n: " + n + " result: " + max);
    }

    static void input1(){
        int n = 13;
        System.out.println("input1 find_maxByRecursiveWODP " + find_maxByRecursiveWODP(n));
        find_maxByMap(n);
        System.out.println("input1 findMaxByMemoisation " + find_MaxByMemoisation(n));
        System.out.println("input1 find_MaxByTabulation " + find_MaxByTabulation(n));

    }
}
