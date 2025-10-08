package com.practice;

import java.util.ArrayList;
import java.util.List;

//Given an integer n, return the number of prime numbers that are strictly less than n.
public class CountPrimes {

    public static void main(String[] args) {
        int n = 100;
        System.out.println("Prime Nums " + countPrimes(n));
        System.out.println("Prime Nums " + getPrimes(n));
    }

    static int countPrimes(int N)  {
        if(N < 3)
            return 0;
        int cnt = 1;//since number is atleast 3, 2 is a prime less than N
        for(int i = 3 ; i < N ; i += 2)
            if(isPrime(i))
                cnt++;
        return cnt;
    }

    static boolean isPrime(int N) {
        for(int i = 2 ; i * i <= N ; i++)
            if(N % i == 0)
                return false;
        return true;
    }

    static  List<Integer> getPrimes(int N){
        List<Integer> list = new ArrayList<>();
        if(N < 3)
            return list;
        list.add(2);
        int cnt = 1;//since number is atleast 3, 2 is a prime less than N
        for(int i = 3 ; i < N ; i += 2)
            if(isPrime(i))
                list.add(i);
        return list;
    }

}
