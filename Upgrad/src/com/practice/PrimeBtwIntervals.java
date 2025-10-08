package com.practice;

public class PrimeBtwIntervals {

    public static void main(String[] args) {

        int low =50, high =100;

        while(low<high){
            boolean flag = false;
            for(int i = 2; i *i<= low; ++i) {
                if(low % i == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag && low != 0 && low != 1)
                System.out.print(low + " ");

            ++low;
        }
    }
}
