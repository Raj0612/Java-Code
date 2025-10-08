package com.recursion;

public class PrintHiNTimes {

    public static void main(String[] args) {
        int n = 10;
        printHiByRecursion(n);
    }

   static  void printHiByRecursion(int n){

        if(n==0 )
            return;
       System.out.println("HI");
       printHiByRecursion(n-1);

   }
}
