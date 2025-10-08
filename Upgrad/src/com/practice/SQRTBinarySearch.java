package com.practice;

public class SQRTBinarySearch {
    public static void main(String[] args) {
        int n = 40;
        int p= 3;
        System.out.println(sqrt(n,p));
    }

    //Time: O(log(n))
    static double sqrt(int n, int p){
        int start = 0;
        int end =n;
        double result = 0.0;
        while(start<=end){
            int mid = start+(end-start)/2;
            System.out.println("Mid " + mid);
            if(mid * mid ==n){
                return mid;
            }
            if(mid * mid >n){
                end = mid-1;
            }else {
                start = mid +1;
            }
        }


        double incr = 0.1;
        int count =0;
        for(int i=0; i<p; i++){
            while(result * result <=n){
                result+= incr;
                count++;
                System.out.println("Result " + result);
            }
            System.out.println("Result " + result + " result*result " + (result*result));
            result-= incr;
            incr /=10;
            System.out.println("result " + result + " incr " + incr);
        }
        System.out.println("count " + count);
        return  result;
    }
}
